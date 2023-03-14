package in.main.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 

import in.main.dto.Student;
import in.main.service.IStudentService;
import in.main.servicefactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) {
		
//		insertOperation();
		//selectOperation();
//		deleteRecord();
		try {
			updateRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private static void updateRecord() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter The id player you want to update :: ");
		String sid = br.readLine();
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(Integer.parseInt(sid));
		Student newStudent = new Student();
		
		if(student != null)
		{
			System.out.println("Student ID's is :: " + student.getSid());
			newStudent.setSid(student.getSid());
			
			System.out.print("Student Old Name is :: " + student.getSname() + "Set NewName :: ");
			String newName = br.readLine();
			if(newName.equals("") || newName == "")
			{
				newStudent.setSname(student.getSname());
			}else
			{
				newStudent.setSname(newName);
			}
			System.out.print("Student Old Age is :: " + student.getSage());
			String newAge = br.readLine();
			if(newAge.equals("") || newAge == "")
			{
				newStudent.setSage(student.getSage());
			}else
			{
				newStudent.setSage(Integer.parseInt(newAge));
			}
			
			System.out.print("Student old Address :: " + student.getSaddress());
			String newAddress = br.readLine();
			
			if(newAddress.equals("") || newAddress == "")
			{
				newStudent.setSaddress(student.getSaddress());
			}else
			{
				newStudent.setSaddress(newAddress);
			}
			
			System.out.println("new Object data is :: " + newStudent);
			System.out.println();

			String status = studentService.updateStudent(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully");
			} else {
				System.out.println("record updation failed");
			}

		} else {
			System.out.println("Student record not available for the given id  " + sid + " for updation...");
		}
	}


	private static void deleteRecord() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your id :: ");
		int sid = scanner.nextInt();
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = studentService.deleteStudent(sid);
		if(msg.equalsIgnoreCase("success"))
		{
			System.out.println("Record deleted Successfully");
		}
		else if(msg.equalsIgnoreCase("not found")) {
			System.out.println("Record not available for given ID :: " + sid);
		}
		else {
			System.out.println("record deletion failed...");
		}
	}

	private static void selectOperation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your id :: ");
		int sid = scanner.nextInt();
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(sid);
		if(student != null)
		{
			System.out.println(student);
			System.out.println("SID\tSNAME\tSAGE\tSADDR");
			System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSage() + "\t" + student.getSaddress());
			
		}else
		{
			System.out.println("Record not come out from given id :: " + sid);
		}
		scanner.close();
	}

	private static void insertOperation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name :: ");
		String sname = scanner.next();
		System.out.print("Enter your age :: ");
		int sage = scanner.nextInt();
		System.out.print("Enter your address :: ");
		String saddress = scanner.next();
		String msg = studentService.addStudent(sname, sage, saddress);
		if(msg.equalsIgnoreCase("success"))
		{
			System.out.println("Record Inserted Successfully");
		}
		else {
			System.out.println("Record failed to insert");
		}
		
	}

}
