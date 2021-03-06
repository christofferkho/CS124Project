package app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Promo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
	private Long id;
	
	@Column
	@NotNull(message="url can't be null")
	private String url;
	
	public Promo(){
	}
	
	public Promo(String url){
		this.url = url;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
