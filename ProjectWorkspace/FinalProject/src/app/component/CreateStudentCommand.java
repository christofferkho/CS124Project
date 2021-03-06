package app.component;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.Student;
import app.repositories.StudentRepository;

@Component
public class CreateStudentCommand extends Command {
	
	private Student student;

	@Override
	public String undo(Exception e) {
		// TODO Auto-generated method stub
		
		e.printStackTrace();
		studentDao.delete(student);
		return "Database error " + e.getMessage();
	}

	@Override
	public String execute(HashMap map) {
		// TODO Auto-generated method stub
		student = createStudent(map);
		
		try {
			student = studentDao.save(student);
			String ret = Integer.toString(student.getIdNo());
			student = null;
			return ret;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Database error " + e.getMessage();
		}
	}
	
	private Student createStudent(HashMap map){
		String idNo = (String) map.get(IDNO);
		String firstName = (String) map.get(FIRSTNAME);
		String lastName = (String) map.get(LASTNAME);
		int id = Integer.parseInt(idNo);
		return new Student(id, firstName, lastName);
    }

}
