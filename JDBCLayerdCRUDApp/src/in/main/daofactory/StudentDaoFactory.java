package in.main.daofactory;

import in.main.persistence.*;

public class StudentDaoFactory {
	
	private StudentDaoFactory() {}
	
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudentDao()
	{
		if(studentDao == null)
		{
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}

}
