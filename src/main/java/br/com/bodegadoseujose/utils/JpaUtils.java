package br.com.bodegadoseujose.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("bodega");
	
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
	
	public static void closeEntityManagerFactory() {
		FACTORY.close();
	}
	
	

}
