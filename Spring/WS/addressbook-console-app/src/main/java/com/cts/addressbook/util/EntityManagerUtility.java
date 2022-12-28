package com.cts.addressbook.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {

	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory==null) {
			entityManagerFactory=Persistence.createEntityManagerFactory("mysqlPU");
		}
		return entityManagerFactory;
	}
	
	public static void closeEntityManagerFactory() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
			entityManagerFactory=null;
		}
	}
}
