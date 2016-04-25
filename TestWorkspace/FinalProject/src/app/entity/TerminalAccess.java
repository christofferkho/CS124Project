package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TerminalAccess {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
    private Long id;

	@ManyToOne
	@NotNull(message="student can't be null")
	private Student student;
	
	@Column
	@NotNull(message="timelog can't be null")
	private String timeLog;
	
	@Column
	@NotNull(message="timeOut can't be null")
	private String timeOut;
	
	@Column
	@NotNull(message="terminal can't be null")
	private String terminal;
	
	@Column
	@NotNull(message="location can't be null")
	private String location;
	
	public TerminalAccess(){
	}
	
	public TerminalAccess(Student student, String timeLog, String timeOut, String terminal, String location){
		this.student = student;
		this.timeLog = timeLog;
		this.timeOut = timeOut;
		this.terminal = terminal;
		this.location = location;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTimeLog() {
		return timeLog;
	}

	public void setTimeLog(String timeLog) {
		this.timeLog = timeLog;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
