package uni_one_to_one_2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapPersonAndPanCard {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
        EntityTransaction et =em.getTransaction();
        
        
        Person p = em.find(Person.class, 101);
        
        PanCard pc = em.find(PanCard.class, 1);
        p.setPc(pc);
        
        et.begin();
        em.merge(p);
        et.commit();
	}

}
