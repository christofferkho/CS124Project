package app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import app.component.Administrator;
import app.entity.Student;
import app.repositories.StudentRepository;

@Profile("studentSeeder")
@Component
public class StudentSeeder {
	
	@Autowired
	StudentRepository admin;
	
	//@PostConstruct
	public void run(){
		int idNo = 132117;
		for(int i = 0; i < 7; i++){
			Student s = new Student();
			s.setFirstName("Kitop " + i);
			s.setLastName("Kho " + i);
			s.setIdNo(idNo + i);
			s.setPhoneNumber("639177506064");
			s.setFlagged(false);
			
			admin.save(s);
		}
		
	}

}
