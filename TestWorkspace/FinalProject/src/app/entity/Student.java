package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	
	@Id
	@Column
	@NotNull(message="idNo can't be null")
	private int idNo;
	
	@Column
	@NotNull(message="firstName can't be null")
	private String firstName;
	
	@Column
	@NotNull(message="lastName can't be null")
	private String lastName;
	
	@Column
	@NotNull(message="phoneNumber can't be null")
	private String phoneNumber;
	
	@Column
	@NotNull(message="flagged can't be null")
	private boolean flagged;
	
	public Student(){
	}
	
	public Student(int idNo, String firstName, String lastName, String phoneNumber, boolean flagged){
		this.idNo = idNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.flagged = flagged;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}
	
}
