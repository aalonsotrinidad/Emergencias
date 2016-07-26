package com.pruebas.modelo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class PickListDao {

//	private static final SessionFactory sessionFactory = buildSessionFactory();
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Map<String, Map<String, String>> getPickListPorObjeto(String objeto){
		Map<String, Map<String, String>> datosRetorno = null;
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select campo, codigo, valor from salesforce.picklists where objeto = '" + objeto + "' order by campo");		

		System.out.println("Ejecutar consulta");
		List<Object[]> listObj = query.list();
		System.out.println("Consulta ejecutada");
		if (listObj != null && !listObj.isEmpty()){
			System.out.println("Lista size: "+listObj.size());
			Object[] ob = null;			
			Map<String, String> mapAux = null;
			for(int i=0; i<listObj.size();i++){
				ob = listObj.get(i);
				if (datosRetorno == null){
					 datosRetorno = new HashMap<String, Map<String, String>>();
				}
				
				if (!datosRetorno.containsKey((String)ob[0])){
					mapAux = new HashMap<String, String>();
				}else{
					mapAux = datosRetorno.get((String)ob[0]);
				}
				System.out.println("Objeto: " + (String)ob[0] + ". Codigo: " + (String)ob[1] + ". Valor: " + (String)ob[2]);
				
				mapAux.put((String)ob[1], (String)ob[2]);
				datosRetorno.put((String)ob[0], mapAux);
			}
		}
		session.close();
		return datosRetorno;
	}
	
	@Transactional
	public Map<String, String> getPickListPorCampo(String objeto, String campo){
		Map<String, String> datosRetorno = null;
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select campo, codigo, valor from salesforce.picklists where objeto = '" + objeto + "' and campo = '" + campo + "' order by campo");		
		System.out.println("Ejecutar consulta");
		List<Object[]> listObj = query.list();
		System.out.println("Consulta ejecutada");
		if (listObj != null && !listObj.isEmpty()){
			System.out.println("Lista size: "+listObj.size());
			Object[] ob = null;					
			for(int i=0; i<listObj.size();i++){
				ob = listObj.get(i);
				if (datosRetorno == null){
					 datosRetorno = new HashMap<String, String>();
				}
				datosRetorno.put((String)ob[1], (String)ob[2]);
				
				System.out.println("Objeto: " + (String)ob[0] + ". Codigo: " + (String)ob[1] + ". Valor: " + (String)ob[2]);
			}
		}
		session.close();
		return datosRetorno;
	}
	
}
