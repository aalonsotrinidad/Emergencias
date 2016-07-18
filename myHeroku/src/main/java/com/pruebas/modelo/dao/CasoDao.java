package com.pruebas.modelo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.force.api.ApiSession;
import com.force.api.DescribeSObject;
import com.force.api.DescribeSObject.Field;
import com.force.api.DescribeSObject.PicklistEntry;
import com.force.api.ForceApi;
import com.force.sdk.oauth.context.ForceSecurityContextHolder;
import com.force.sdk.oauth.context.SecurityContext;
import com.pruebas.modelo.dto.CasoDTO;
import com.sforce.soap.metadata.FieldType;


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
				casoAux.setEstado((String)ob[0]);
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
	
	
	
	
	
	public Map<String, Map<String, String>> recuperarPickList(){
		Map<String, Map<String, String>> mapaRetorno = null;
		Map<String, String> mapAux = null;
		DescribeSObject objDescribe = getForceApi().describeSObject("Case");
		// Get sObject metadata
		if (objDescribe != null) {
			System.out.println("sObject name: " +objDescribe.getName());
	        List<Field> fields = objDescribe.getFields();
	        List<PicklistEntry> picklistValues = null;
		    System.out.println("Has " + fields.size() + " fields");
		        // Iterate through each field and gets its properties
		    	Field field = null;
		        for (int i = 0; i < fields.size(); i++) {
		          field = fields.get(i);
		          // If this is a picklist field, show the picklist values
		          if (FieldType.Picklist.toString().equalsIgnoreCase(field.getType())) {
		              picklistValues = field.getPicklistValues();
		              System.out.println("Picklist recuperado: " + picklistValues);
		              if (picklistValues != null) {
		            	if (mapaRetorno ==null){
		            		mapaRetorno = new HashMap<String, Map<String, String>>();
		            	}
		                System.out.println("Picklist values: ");
		                mapAux = new HashMap<String, String>();
		                mapaRetorno.put(field.getName(), mapAux);
		                for (int j = 0; j < picklistValues.size(); j++) {
		                	mapAux.put(picklistValues.get(j).getValue(), picklistValues.get(j).getLabel());
		                	System.out.println("\tItem: Value: " + picklistValues.get(j).getValue() +
		                			" .Descipción: " + picklistValues.get(j).getLabel());
		                  }
		                }
		              }
		          }
		}
		return mapaRetorno;
	}
	
	
	
	
	
	
    private ForceApi getForceApi() {
        SecurityContext sc = ForceSecurityContextHolder.get();
        System.out.println("Security context: " + sc);
        ApiSession s = new ApiSession();
        s.setAccessToken(sc.getSessionId());
        s.setApiEndpoint(sc.getEndPointHost());
        return new ForceApi(s);
    }
}
