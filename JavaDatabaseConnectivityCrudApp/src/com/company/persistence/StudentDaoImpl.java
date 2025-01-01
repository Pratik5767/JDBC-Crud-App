package com.company.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.dto.Student;
import com.utils.JdbcUtil;

// Persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;

	@Override
	public String insertStudent(String sname, Integer sage, String saddress) {
		String sqlInsertQuery = "INSERT INTO students (`name`,`age`,`address`)VALUES(?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlInsertQuery);
			}

			if (prepareStatement != null) {
				prepareStatement.setString(1, sname);
				prepareStatement.setInt(2, sage);
				prepareStatement.setString(3, saddress);
			}

			int rowCount = prepareStatement.executeUpdate();

			if (rowCount == 1) {
				return "success";
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		String sqlSelectQuery = "SELECT `id`, `name`, `age`, `address` FROM students WHERE id = ?";
		Student std = null;
		
		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				prepareStatement = connection.prepareStatement(sqlSelectQuery);

			if (prepareStatement != null)
				prepareStatement.setInt(1, sid);

			if (prepareStatement != null)
				resultSet = prepareStatement.executeQuery();

			if (resultSet != null) {
				if (resultSet.next()) {
					std = new Student();

					// copy resultSet data to student object
					std.setSid(resultSet.getInt(1));
					std.setSname(resultSet.getString(2));
					std.setSid(resultSet.getInt(3));
					std.setSaddress(resultSet.getString(3));
					return std;
				} 
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		String sqlDeleteQuery = "DELETE FROM students WHERE id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlDeleteQuery);
			}
			
			if (prepareStatement != null) {
				prepareStatement.setInt(1, sid);
			}
			
			int rowCount = prepareStatement.executeUpdate();
			if (rowCount == 1) {
				return "success";
			} else {
				return "not found";
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}
}