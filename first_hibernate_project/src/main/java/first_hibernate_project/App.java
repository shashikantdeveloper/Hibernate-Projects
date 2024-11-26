package first_hibernate_project;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Choose Option..");
			System.out.println("1) Create Account");
			System.out.println("2) View Account By Id");
			System.out.println("3) Delete Account by Id");
			System.out.println("4) Update Account by Id.");
			System.out.println("5) View All User");
			System.out.println("6) View User By name");
			System.out.println("7) Exit");
			switch (sc.nextInt()) {
			case 1:
				insert();
				break;
			case 2:
				viewAccount();
				break;
			case 3:
				break;
			case 4:
				updateById();
				break;

			case 5:
				viewAllUser();
				break;
			case 6:
				viewUserByName();
				break;
			case 7: {
				System.out.println("Thank you for Visiting..");
				System.exit(0);
			}
			default:
				break;
			}
		}
	}

	public static void insert() {
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

	static void viewAccount() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();
		System.out.println("Enter user Id");
		User u = em.find(User.class, new Scanner(System.in).nextInt());
		System.out.println(u);

	}

	static void deleteById() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

		EntityManager em = emf.createEntityManager();
		System.out.println("Enter user Id");
		User u = em.find(User.class, new Scanner(System.in).nextInt());
		if (u != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(u);
			et.commit();
			System.out.println("User deleted Successfully..");

		} else {

			System.out.println("Invalid User Id...");
		}

	}

	static void updateById() {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		System.out.println("Enter Id.");
		User u = em.find(User.class, sc.nextInt());
		if (u != null) {
			EntityTransaction et = em.getTransaction();
			System.out.println("Enter new Name..");
			String name = sc.next();
			u.setName(name);
			et.begin();
			em.merge(u);
			et.commit();
			System.out.println("Name Updated Syccessfully..");
		} else {
			System.out.println("Invalid User Id ...");
		}

	}

	static void viewAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select u from User u");

		List<User> ul = q.getResultList();

		for (User u : ul) {
			System.out.println(u);
		}

	}

	static void viewUserByName() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select u from User u where u.name=:name and u.password=:password");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name:");
		q.setParameter("name", sc.next());
		System.out.println("Enter Password.");
		q.setParameter("password", sc.next());
		List<User> ul = q.getResultList();
		for (User u : ul) {
			System.out.println(u);
		}

	}

}
