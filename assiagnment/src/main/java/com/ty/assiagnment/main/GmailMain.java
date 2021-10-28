package com.ty.assiagnment.main;

import java.util.Scanner;

import com.ty.assiagnment.dao.AccountVerify;
import com.ty.assiagnment.dto.Account;
import com.ty.assiagnment.dto.Inbox;

public class GmailMain {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Account account;
		AccountVerify accountVerify;
		Inbox inbox = new Inbox();
		System.out.println(" Press 1 to Login\n Press 2 to Register");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			accountVerify= new AccountVerify();
			accountVerify.verify();
			break;
		case 2:
			accountVerify = new AccountVerify();
			accountVerify.create();
			break;

		default:
			break;
		}
	}
}
