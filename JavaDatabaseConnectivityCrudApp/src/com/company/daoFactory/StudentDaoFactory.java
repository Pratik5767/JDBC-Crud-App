package com.company.daoFactory;

import com.company.persistence.IStudentDao;
import com.company.persistence.StudentDaoImpl;

public class StudentDaoFactory {
	
	// no object creation
	private StudentDaoFactory() {}
	
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudentDao() {
		if (studentDao == null) {
			studentDao = new StudentDaoImpl();			
		}
		return studentDao;
	}
}