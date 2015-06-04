package au.gov.nla.lendbook.converter;

import au.gov.nla.lendbook.model.Person;

/**
 * @author Mingtao Sun
 */
public abstract class BaseConverterTest {
	
	protected static final String EMAIL = "john@gmail.com";
	protected static final String PHONE = "0288889999";
	protected static final String NAME = "John";
	protected static final String ISBN = "5678";
	protected static final String TITLE = "Tom and Jerry";
	protected static final String AUTHOR = "Disney";
	
	protected Person createPersonEnity(long id) {
		Person person = new Person(id);
		person.setName(NAME);
		person.setPhone(PHONE);
		person.setEmail(EMAIL);
		return person;
	}
}
