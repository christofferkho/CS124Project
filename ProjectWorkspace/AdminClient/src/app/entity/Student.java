package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	
	@Id
	@Column(unique=true)
	@NotNull(message="idNo can't be null")
	private int idNo;
	
	@Column
	@NotNull(message="firstName can't be null")
	private String firstName;
	
	@Column
	@NotNull(message="lastName can't be null")
	private String lastName;
	
	public Student(){
	}
	
	public Student(int idNo, String firstName, String lastName){
		this.idNo = idNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
