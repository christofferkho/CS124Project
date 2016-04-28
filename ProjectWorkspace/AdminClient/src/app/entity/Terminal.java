package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Terminal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
	private Long id;
	
	@Column
	@NotNull(message="terminalNumber can't be null")
	private int terminalNumber;
	
	@Column
	@NotNull(message="roomName can't be null")
	private String roomName;
	
	public Terminal(){
	}
	
	public Terminal(int terminalNumber, String roomName){
		this.terminalNumber = terminalNumber;
		this.roomName = roomName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTerminalNumber() {
		return terminalNumber;
	}

	public void setTerminalNumber(int terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
