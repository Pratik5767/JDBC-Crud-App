package com.company.controllers;

import java.util.Scanner;

import com.company.dto.Student;
import com.company.services.IStudentService;
import com.company.servicesFactory.StudentServiceFactory;

// Controller Layer
public class TestApp {

	public static void main(String[] args) {

//		insertOperation();
//		selectOperation();
//		deleteOperation();
		updateOperation();
	}
	
	public static void updateOperation() {
		
		
	}

	public static void deleteOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Student ID :: ");
		int sid = scanner.nextInt();

		String status = studentService.deleteStudent(sid);
		if (status.equalsIgnoreCase("success")) {
			System.out.println("Record deleted Succussfully");
		} else if (status.equalsIgnoreCase("not found")) {
			System.out.println("Record not found for the given ID :: " + sid);
		} else {
			System.out.println("Record deletion Failed");
		}

		scanner.close();
	}

	public static void selectOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Student ID :: ");
		int sid = scanner.nextInt();

		Student std = studentService.searchStudent(sid);
		if (std != null) {
			System.out.println(std);
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
		} else {
			System.out.println("Record not found for given ID :: " + sid);
		}

		scanner.close();
	}

	public static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Name :: ");
		String sname = scanner.next();

		System.out.print("Enter the Age :: ");
		int sage = scanner.nextInt();

		System.out.print("Enter the Address :: ");
		String saddress = scanner.next();

		String msg = studentService.addStudent(sname, sage, saddress);

		if (msg.equals("success")) {
			System.out.println("Record Inserted Successfully");
		} else {
			System.out.println("Record Inserted Failed");
		}
		scanner.close();
	}
}