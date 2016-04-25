package app.component;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import app.repositories.StudentRepository;

public abstract class Command {
	
	@Autowired
	protected StudentRepository studentDao;
	
	public abstract String undo(Exception e);
	public abstract String execute();
}
