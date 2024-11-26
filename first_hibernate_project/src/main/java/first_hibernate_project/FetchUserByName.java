package first_hibernate_project;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchUserByName {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		
		//Query q = em.createQuery("select u from User u where u.name=?1 and u.password=?2");
		
		Query q = em.createQuery("select u from User u where u.name=:name and u.password=:password");
		System.out.println("Enter Name");
		//q.setParameter(1, new Scanner(System.in).next());
		q.setParameter("name", new Scanner(System.in).next());
		System.out.println("Enter Password");
		//q.setParameter(2, new Scanner(System.in).next());
		q.setParameter("password", new Scanner(System.in).next());
		List<User> ul = q.getResultList();
		for(User u :ul) {
		 System.out.println(u);	
		}
		
		
	}

}
