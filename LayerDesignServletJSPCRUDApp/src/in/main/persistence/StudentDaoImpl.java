package in.main.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.main.dto.Student;
import in.main.jdbcUtilPack.*;

// write persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {
	
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;

	@Override
	public String addStudent(Student student) {
		
		String sqlQuery = "insert into player(`name`, `age`, `address`)values(?,?,?)";
		try {
			connection = jdbcUtilPack.getJDBCConnection();
			if(connection != null)
			{
				prepareStatement = connection.prepareStatement(sqlQuery);
				if(prepareStatement != null)
				{
					prepareStatement.setString(1, student.getSname());
					prepareStatement.setInt(2, student.getSage());
					prepareStatement.setString(3, student.getSaddress());
					
					int rowAffeceted = prepareStatement.executeUpdate();
					if(rowAffeceted == 1)
					{
						return "success";
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	//Here Student is DTO object which imitating/ behaving like resultSet not actual resultset, we called it as bean trasportation, pojo transportation, DTO transportation
	public Student searchStudent(Integer sid) {
		String sqlQuery = "select id, name, age, address from player where id= ?";
		Student student = null;
		try {
			connection = jdbcUtilPack.getJDBCConnection();
			if(connection != null)
			{
				prepareStatement = connection.prepareStatement(sqlQuery);
				if(prepareStatement != null)
				{
					prepareStatement.setInt(1, sid);
				}
				if(prepareStatement != null)
				{
					resultSet = prepareStatement.executeQuery();
				}
				if(resultSet != null)
				{
					if(resultSet.next())
					{
						student = new Student();
						// copying resultSet data to student object
						student.setSid(resultSet.getInt(1));
						student.setSname(resultSet.getString(2));
						student.setSage(resultSet.getInt(3));						
						student.setSaddress(resultSet.getString(4));
						return student;
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}


	@Override
	public String deleteStudent(Integer sid) {
		String sqlQuery = "delete from player where id= ?";
		Student student = null;
		try {
			connection = jdbcUtilPack.getJDBCConnection();
			if(connection != null)
			{
				prepareStatement = connection.prepareStatement(sqlQuery);
				if(prepareStatement != null)
				{
					prepareStatement.setInt(1, sid);
					int rowAffected = prepareStatement.executeUpdate();
					if(rowAffected == 1)
					{
						return "success";
					}
					else {
						return "not found";
					}
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}
	
	@Override
	public String updateStudent(Student student) {
		String sqlUpdateQuery = "update player set name=?,age=?,address=? where id=?";
		try {
			connection = jdbcUtilPack.getJDBCConnection();

			if (connection != null)
				prepareStatement = connection.prepareStatement(sqlUpdateQuery);

			if (prepareStatement != null) {

				prepareStatement.setString(1, student.getSname());
				prepareStatement.setInt(2, student.getSage());
				prepareStatement.setString(3, student.getSaddress());
				prepareStatement.setInt(4, student.getSid());

				int rowAffected = prepareStatement.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}
}
