package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class OverdueFee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
    private Long id;
	
	@ManyToOne
	@NotNull(message="student can't be null")
	private Student student;
	
	@Column
	@NotNull(message="amountDue can't be null")
	private double amountDue;
	
	@Column
	@NotNull(message="dateIssued can't be null")
	private String dateIssued;
	
	@Column
	@NotNull(message="type can't be null")
	private String type;
	
	public OverdueFee(){
	}
	
	public OverdueFee(Student student, double amountDue, String dateIssued, String type){
		this.student = student;
		this.amountDue = amountDue;
		this.dateIssued = dateIssued;
		this.type = type;
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

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	public String getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
