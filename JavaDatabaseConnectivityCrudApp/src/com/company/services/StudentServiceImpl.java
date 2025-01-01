package com.company.services;

import com.company.daoFactory.StudentDaoFactory;
import com.company.dto.Student;
import com.company.persistence.IStudentDao;

// Service Layer
public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao; 
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getStudentDao();
		if (stdDao != null) 
			return stdDao.insertStudent(sname, sage, saddress);
		else
			return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(sid, sname, sage, saddress);
	}

	@Override
	public String deleteStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(sid);
	}
}