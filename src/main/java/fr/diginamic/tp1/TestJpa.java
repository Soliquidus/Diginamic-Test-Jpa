package fr.diginamic.tp1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJpa {

    private static final Logger LOGGER = LoggerFactory.getLogger( TestJpa.class );

    public static void main( String[] args ) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "test-jpa" );
        EntityManager em = emf.createEntityManager();
        System.out.println(em);
        em.close();
        emf.close();
        LOGGER.info( "Hello, world!!" );
    }
}