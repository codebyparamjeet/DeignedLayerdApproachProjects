package in.main.servicefactory;

import in.main.service.IStudentService;
import in.main.service.StudentServiceImpl;

//Abstraction logic of implmentation
public class StudentServiceFactory {
	
	private StudentServiceFactory(){}
	
	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService()
	{
		//singleton pattern code
		if(studentService == null)
		{
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

}
