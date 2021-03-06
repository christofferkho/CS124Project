package app.component;

import org.springframework.stereotype.Component;

import app.entity.Student;

@Component
public class CreateStudentCommand extends Command {
	
	private Student student;

	@Override
	public String undo(Exception e) {
		// TODO Auto-generated method stub
		
		e.printStackTrace();
		return "Database error " + e.getMessage();
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		try {
			studentDao.save(student);
			return "New Student: " + student.getFirstName() + " "
					+ student.getLastName() + ": " + student.getIdNo() 
					+ ", " + student.getPhoneNumber();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return undo(e);
		}
	}
	
	public void createStudent(int idNo, String firstName, String lastName, String phoneNumber){
		student = new Student(idNo, firstName, lastName, phoneNumber, false);
    }

}
