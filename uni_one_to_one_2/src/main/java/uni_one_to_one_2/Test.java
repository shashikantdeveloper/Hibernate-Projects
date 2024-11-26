package uni_one_to_one_2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		
		Person p = new Person();
		p.setId(101);
		p.setName("Abc");
		p.setEmail("abc@gmail.com");
		p.setPhone(96541236);
		p.setPassword("123");
		
//		PanCard pc = new PanCard();
//		pc.setId(1);
//		pc.setPinCode(829117);
//		pc.setpNo("96BOI123");
		
		
		
		
		et.begin();
		em.persist(p);
//		em.persist(pc);
		et.commit();
        

	}

}
