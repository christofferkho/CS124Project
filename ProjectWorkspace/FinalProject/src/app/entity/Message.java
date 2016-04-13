package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
    private Long id;
	
	@ManyToOne
	@NotNull(message="fee can't be null")
	private Student student;
	
	@Column
	@NotNull(message="dateSent can't be null")
	private String dateSent;
	
	@Column
	@NotNull(message="amount can't be null")
	private double amount;
	
	@Column
	@NotNull(message="amount can't be null")
	private boolean sent;

	public Message(){
	}
	
	public Message(Student student, String dateSent, double amount, boolean sent){
		this.student = student;
		this.dateSent = dateSent;
		this.amount = amount;
		this.sent = sent;
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

	public String getDateSent() {
		return dateSent;
	}

	public void setDateSent(String dateSent) {
		this.dateSent = dateSent;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}


}
