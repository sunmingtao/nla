package au.gov.nla.lendbook.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import au.gov.nla.lendbook.dto.PersonDto;

public class PersonConverterTest extends BaseConverterTest{

	private PersonConverter personConverter;
	
	@Before
	public void before(){
		personConverter = new PersonConverter();
	}
	
	@Test
	public void testConvertFromEntity() {
		long id = 1L;
		PersonDto dto = personConverter.convertFromEntity(createPersonEnity(id));
		assertEquals(id, dto.getId());
		assertEquals(NAME, dto.getName());
		assertEquals(PHONE, dto.getPhone());
		assertEquals(EMAIL, dto.getEmail());
	}

}
