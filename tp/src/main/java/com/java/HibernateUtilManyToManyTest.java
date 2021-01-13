package com.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilManyToManyTest {
	
    public static void main(String[] args){
    	
    	StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	
	    MetadataSources sources = new MetadataSources(registry);
	
	    Metadata metadata = sources.getMetadataBuilder().build();
	
	    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
         
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();

        Marque marque = new Marque();
        marque.setNom("marqueTest");

        session.save(marque);

        Voiture voiture = new Voiture();
        voiture.setNom("voitureTest");
        voiture.setMatricule("matriculeTest");
        voiture.setMarque(marque);

        session.save(voiture);

        Chauffeur chauffeur = new Chauffeur();
        chauffeur.setNom("chauffeurTest");
        chauffeur.getVoitureSet().add(voiture);
        voiture.getChauffeurSet().add(chauffeur);

        session.save(chauffeur);

        transaction.commit();
        session.close();
    }
}
