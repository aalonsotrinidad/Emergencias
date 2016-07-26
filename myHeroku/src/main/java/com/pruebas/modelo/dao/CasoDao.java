package com.pruebas.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.modelo.dto.CasoDTO;


@Repository
public class CasoDao {

//	private static final SessionFactory sessionFactory = buildSessionFactory();
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<CasoDTO> getListaCasosHome(){
		System.out.println("Intento apertura session");
		Session session = sessionFactory.openSession();
		System.out.println("Session abierta");
		System.out.println("Crear consulta");
		SQLQuery query = session.createSQLQuery("select CaseNumber, Status from salesforce.Case limit 10");
		System.out.println("Consulta creada");
		List<CasoDTO> listaCasos = new ArrayList<CasoDTO>();
		System.out.println("Ejecutar consulta");
		List<Object[]> listObj = query.list();
		System.out.println("Consulta ejecutada");
		if (listObj != null && !listObj.isEmpty()){
			System.out.println("Lista size: "+listObj.size());
			Object[] ob = null;
			CasoDTO casoAux = null;
			for(int i=0; i<listObj.size();i++){
				ob = listObj.get(i);
				casoAux = new CasoDTO();
				casoAux.setNumeroCaso((String)ob[0]);
				casoAux.setEstado((String)ob[1]);
				listaCasos.add(casoAux);
			}
		}	
		session.close();
		return listaCasos;
	}
	
	@Transactional
	public void insertarCaso(CasoDTO caso){
		System.out.println("Intenta insertar");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        session.save(caso);
        //Commit the transaction
        session.getTransaction().commit();
        session.close();
	}
	
	@Transactional
	public void actualizarCaso(CasoDTO caso){
		System.out.println("Intenta actualizar");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        session.update(caso);
        //Commit the transaction
        session.getTransaction().commit();
        session.close();
	}
}
