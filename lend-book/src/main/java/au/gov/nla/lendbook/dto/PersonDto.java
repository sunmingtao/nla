package au.gov.nla.lendbook.dto;

/**
 * Person DTO 
 * @author Mingtao Sun
 */
public class PersonDto extends BaseDto{
	private String name;
	private String phone;
	private String email;
	public PersonDto() {
		super(0L);
	}
	public PersonDto(long id) {
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
