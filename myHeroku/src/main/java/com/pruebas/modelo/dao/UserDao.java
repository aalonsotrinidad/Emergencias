package com.pruebas.modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebas.modelo.dto.UserDTO;


@Repository
public class UserDao {

//	private static final SessionFactory sessionFactory = buildSessionFactory();
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Función que devuelve toda la información del usuario cuyo name y password coinciden con los parámetros pasados
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	@Transactional
	public UserDTO getUser(String name, String password){
		System.out.println("GetUser--- use: "+name);
		Session session = sessionFactory.openSession();
		System.out.println("Sesion creada--" + session);
		//session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select name  from salesforce.user");
		
		List<Object[]> lista = query.list();
		List<UserDTO> listaDir = new ArrayList<UserDTO>();
		System.out.println("query ejecutada");
		for(int i=0; i<lista.size();i++){
			Object[] ob = lista.get(i);
			System.out.println("mis valores: "+ob);
			System.out.println("mi componente name: "+ob[0]);
			UserDTO userAux = new UserDTO();
			userAux.setName((String)ob[0]);
			listaDir.add(userAux);
		}
//		System.out.println("InicioTransaccion");
//		Criteria criteria = session.createCriteria(UserDTO.class);
//		criteria.add(Restrictions.eq("name", name));
//		
		UserDTO  user = listaDir.get(0);
		session.close();
		
		return user;
	}
	
//	private static SessionFactory buildSessionFactory() {
//        try {
//        	System.out.println("BuildSessionFactory----inicio");
//            // Create the SessionFactory from hibernate.cfg.xml
//        	 return new Configuration().configure().buildSessionFactory();
//        }
//        catch (Throwable ex) {
//            // Make sure you log the exception, as it might be swallowed
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
	
}
