package first_hibernate_project;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		User u = new User();
		System.out.println("Enter Id.");
		u.setId(sc.nextInt());
		
		System.out.println("Enter Name..");
		u.setName(sc.next());
		
		System.out.println("Enter mail Id..");
		u.setEmail(sc.next());
		
		System.out.println("Enter Phone no..");
		u.setPhone(sc.nextLong());
		
		System.out.println("Enter Password..");
		u.setPassword(sc.next());

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(u);
		et.commit();

	}

}
