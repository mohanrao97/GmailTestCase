package com.ty.assiagnment.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.assiagnment.dto.Account;
import com.ty.assiagnment.dto.Inbox;

public class AccountVerify implements GmailDao {
	Scanner scanner = new Scanner(System.in);
	Account account = new Account();
	Inbox inbox;
	int id;
	EntityManagerFactory factory;
	EntityManager manager;
	EntityTransaction transaction;

	@Override
	public void verify() {
		System.out.println("Enter your Email id");
		String email1 = scanner.next();
		System.out.println("Enter your password");
		String pass1 = scanner.next();
		factory = Persistence.createEntityManagerFactory("acc");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		String findAll = "from Account";
		Query query = manager.createQuery(findAll);
		List<Account> list = query.getResultList();
		for (Account mail : list) {
			if (mail.getEmail().equals(email1) && mail.getPass().equals(pass1)) {
				System.out.println(" Press A to compose\n Press B to show inbox");
				String input = scanner.next().toUpperCase();
				switch (input) {
				case "A":
					System.out.println("Enter your message :");
					String msg = scanner.next();

					msg = scanner.nextLine();
					id = account.getUid();
					inbox = new Inbox();
					inbox.setMsg(msg);
					inbox.setAccount(mail);
					transaction.begin();
					manager.persist(inbox);
					transaction.commit();
					break;

				case "B":
					System.out.println("hello");
					factory = Persistence.createEntityManagerFactory("acc");
					manager = factory.createEntityManager();
					transaction = manager.getTransaction();
					String find = "from Inbox where uid=:id";
					Query query1 = manager.createQuery(find);
					query1.setParameter("id", id);
					List<Inbox> list1 = query1.getResultList();
					System.out.println("*********************************************");
					for (Inbox in : list1) {
						System.out.println("bdhjcbdwc");
						System.out.println("Your messages are :"+in.getMsg());
					}

					break;

				default:
					System.out.println("Invalid input enter a or b");
					break;
				}
			} else
				System.out.println("Invalid crediential check user_name or password");

		}
		
	}

	@Override
	public void create() {
		System.out.println("Enter Username to create Account");
		String uname = scanner.next();
		System.out.println("Enter Password to create Account");
		String pass = scanner.next();
		System.out.println("Enter email to create Account");
		String email = scanner.next();
//		Account account = new Account();
		account.setUname(uname);
		account.setPass(pass);
		account.setEmail(email);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("acc");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(account);
		transaction.commit();

	}

}
