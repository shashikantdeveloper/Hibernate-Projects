package first_hibernate_project;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();
		System.out.println("Enter user Id");
		User u = em.find(User.class, new Scanner(System.in).nextInt());
		//System.out.println(u);

		//System.out.println(u.getName());
		
		if(u!=null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(u);
			et.commit();
			System.out.println("User deleted Successfully..");
			
		}else {
			
			System.out.println("Invalid User Id...");
		}
		
	}

}
