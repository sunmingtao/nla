package au.gov.nla.lendbook.dto;

/**
 * Base DTO that has common properties
 * @author zsunm
 */
public class BaseDto {
	private final long id;

	public BaseDto(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
