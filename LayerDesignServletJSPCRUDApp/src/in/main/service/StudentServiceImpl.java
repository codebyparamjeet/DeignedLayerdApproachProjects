package in.main.service;

import in.main.daofactory.StudentDaoFactory;
import in.main.dto.Student;
import in.main.persistence.IStudentDao;


public class StudentServiceImpl implements IStudentService {
	private IStudentDao studentDao;
	@Override
	public String addStudent(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(student);
	}

	@Override
	public Student searchStudent(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(sid);
	}

}
