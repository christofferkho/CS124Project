package app;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import antlr.collections.List;
import app.component.Administrator;
import app.entity.Student;

@Profile("adminTester")
@Component
public class AdminTester {
	
	@Autowired
	Administrator admin;
	
	//@PostConstruct
	public void run(){
		
		String in = admin.login(132119,"27", "CTC");
		admin.logOut(132119, in);
		//ArrayList<Student> students = (ArrayList<Student>) admin.viewStudents();
		//System.out.println(students);
		
	}

}
