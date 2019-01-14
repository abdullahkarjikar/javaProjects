package com.cg.lms.main;

import java.util.Scanner;

import com.cg.lms.LMSdao.StudentDAO;
import com.cg.lms.LMSdao.StudentDAOImpl;
import com.cg.lms.exception.LMSException;
import com.cg.lms.model.Students;

public class Main {
	public static void main(String[] args) {

		System.out.println("------Menu------");
		System.out.println("1. Create Table");
		System.out.println("2. Insert Records");
		System.out.println("3. Modify Records");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your choice: ");
		int choice = scanner.nextInt();

		Students bookdetails = new Students();
		StudentDAO studentDao = new StudentDAOImpl();

		switch (choice) {
		case 1:

			try {
				studentDao.createTable();
			} catch (LMSException e) {
				e.getStackTrace();
			}
			break;
		case 2:
			System.out.println("====================");
			System.out.println("----Book Details----");
			System.out.println("Enter Book Name: ");
			scanner.nextLine();
			String bookName = scanner.nextLine();
			System.out.println("Enter Author Name: ");
			String authorName = scanner.nextLine();
			System.out.println("Enter Cost: ");
			Double cost = scanner.nextDouble();

			bookdetails.setBookName(bookName);
			bookdetails.setAuthorName(authorName);
			bookdetails.setBookCost(cost);

			try {
				int result = studentDao.insertBookRecord(bookdetails);
				System.out.println(result + " Records inserted...");
			} catch (LMSException e) {
				System.err.println("No records inserted");
			}
			break;
		case 3:
			System.out.println("========================");
			System.out.println("-----Update Details-----");
			System.out.println("Enter ID for which Cost has to be updated: ");
			int id = scanner.nextInt();
			System.out.println("Enter Cost: ");
			Double bookCost = scanner.nextDouble();

			bookdetails.setId(id);
			bookdetails.setBookCost(bookCost);

			try {
				int result = studentDao.updateRecords(bookdetails);
				System.out.println(result + " Records Sucessfully Updated...");
			} catch (LMSException e) {
				System.err.println("Get Connection failed");
			}
			break;

		default:
			System.err.println("Not a valid Choice");
			break;
		}
		scanner.close();
	}
}
