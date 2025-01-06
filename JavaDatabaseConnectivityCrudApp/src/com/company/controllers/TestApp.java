package com.company.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.company.dto.Student;
import com.company.services.IStudentService;
import com.company.servicesFactory.StudentServiceFactory;

// Controller Layer
public class TestApp {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER YOUR CHOICE, PRESS[1/2/3/4/5] :: ");
			String option = br.readLine();

			switch (option) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateOperation();
				break;
			case "4":
				deleteOperation();
				break;
			case "5":
				System.out.println("*******Thanks for using the application*******");
				System.exit(0);
			default:
				System.out.println("Invalid option, Please Try again");
				break;
			}
		}
	}

	public static void updateOperation() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Student ID :: ");
		String sid = br.readLine();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(Integer.parseInt(sid));

		if (std != null) {
			Student newStudent = new Student();

			System.out.println("Student id is :: " + std.getSid());
			newStudent.setSid(std.getSid());

			System.out.print("Student old name is :: " + std.getSname() + " Enter new Name :: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				newStudent.setSname(std.getSname());
			} else {
				newStudent.setSname(newName);
			}

			System.out.print("Student old age is :: " + std.getSage() + " Enter new Age :: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				newStudent.setSage(std.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}

			System.out.print("Student old address is :: " + std.getSaddress() + " Enter new Address :: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				newStudent.setSaddress(std.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}

			System.out.println("new Object data is :: " + newStudent);
			System.out.println();
			String status = studentService.updateStudent(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("Record Updated Succussfully");
			} else {
				System.out.println("Record Updation Failed");
			}
		} else {
			System.out.println("Student record not available for the given ID :: " + sid);
		}
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
	}
}