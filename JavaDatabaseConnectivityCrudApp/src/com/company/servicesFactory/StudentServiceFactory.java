package com.company.servicesFactory;

import com.company.services.IStudentService;
import com.company.services.StudentServiceImpl;

// Abstraction logic of implementation
public class StudentServiceFactory {
	// make constructor private
	private StudentServiceFactory() {}
	
	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService() {
		// singleton pattern code
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;			
	}
}