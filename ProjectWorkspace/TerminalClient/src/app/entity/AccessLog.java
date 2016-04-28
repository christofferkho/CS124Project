package app.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AccessLog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
	private Long id;
	
	@Column(name = "timeIn")
	@NotNull(message="timeIn can't be null")
	private Timestamp timeIn;
	
	@Column(name = "timeOut")
	private Timestamp timeOut;
	
	@ManyToOne
	@NotNull(message="student can't be null")
	private Student student;
	
	@ManyToOne
	@NotNull(message="terminal can't be null")
	private Terminal terminal;
	
	public AccessLog(){}
	
	public AccessLog(Timestamp timeIn, Student student, Terminal terminal){
		this.timeIn = timeIn;
		this.student = student;
		this.terminal = terminal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Timestamp timeIn) {
		this.timeIn = timeIn;
	}

	public Timestamp getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Timestamp timeOut) {
		this.timeOut = timeOut;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}


}
