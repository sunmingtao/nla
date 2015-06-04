package au.gov.nla.lendbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class for PERSONS table 
 * @author Mingtao Sun
 */
@Entity
@Table(name="PERSONS")
public class Person extends BaseEntity{
	@Column(name="NAME")
	private String name;
	@Column(name="PHONE")
	private String phone;
	@Column(name="EMAIL")
	private String email;
	
	public Person(){
		super();
	}
	public Person(long id) {
		super(id);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
