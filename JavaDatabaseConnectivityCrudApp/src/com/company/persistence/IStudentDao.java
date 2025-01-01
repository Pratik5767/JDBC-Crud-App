package com.company.persistence;

import com.company.dto.Student;

public interface IStudentDao {
	// Operations to be implemented
	public String insertStudent(String sname, Integer sage, String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);
	
	public String deleteStudent(Integer sid);
}