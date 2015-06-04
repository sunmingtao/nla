package au.gov.nla.lendbook.converter;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import au.gov.nla.lendbook.dto.BookDto;
import au.gov.nla.lendbook.dto.PersonDto;
import au.gov.nla.lendbook.model.Book;
import au.gov.nla.lendbook.model.Person;

public class BookConverterTest extends BaseConverterTest{

	private BookConverter bookConverter;
	private PersonConverter mockPersonConverter;
	
	@Before
	public void before(){
		bookConverter = new BookConverter();
		mockPersonConverter = createMock(PersonConverter.class);
		bookConverter.setPersonConverter(mockPersonConverter);
	}
	
	@Test
	public void testConvertFromEntityWithBorrower1() {
		expect(mockPersonConverter.convertFromEntity((Person)anyObject())).andReturn(new PersonDto());
		replay(mockPersonConverter);
		long id = 1L;
		BookDto dto = bookConverter.convertFromEntityWithBorrower(createBookEntity(id));
		assertEquals(id, dto.getId());
		assertEquals(TITLE, dto.getTitle());
		assertEquals(AUTHOR, dto.getAuthor());
		assertEquals(ISBN, dto.getIsbn());
		assertNotNull(dto.getBorrowedBy());
	}
	
	@Test
	public void testConvertFromEntityWithBorrower2() {
		long id = 1L;
		BookDto dto = bookConverter.convertFromEntityWithBorrower(createBookEntityNoBorrower(id));
		assertEquals(id, dto.getId());
		assertEquals(TITLE, dto.getTitle());
		assertEquals(AUTHOR, dto.getAuthor());
		assertEquals(ISBN, dto.getIsbn());
		assertNull(dto.getBorrowedBy());
	}

	@Test
	public void testConvertFromEntityWithoutBorrower() {
		expect(mockPersonConverter.convertFromEntity((Person)anyObject())).andReturn(new PersonDto());
		replay(mockPersonConverter);
		long id = 1L;
		BookDto dto = bookConverter.convertFromEntityWithoutBorrower(createBookEntity(1L));
		assertEquals(id, dto.getId());
		assertEquals(TITLE, dto.getTitle());
		assertEquals(AUTHOR, dto.getAuthor());
		assertEquals(ISBN, dto.getIsbn());
		assertNull(dto.getBorrowedBy());
	}
	
	private Book createBookEntity(long id) {
		Book book = new Book(id);
		book.setAuthor(AUTHOR);
		book.setTitle(TITLE);
		book.setIsbn(ISBN);
		book.setBorrowedBy(createPersonEnity(1L));
		return book;
	}
	
	private Book createBookEntityNoBorrower(long id) {
		Book book = new Book(id);
		book.setAuthor(AUTHOR);
		book.setTitle(TITLE);
		book.setIsbn(ISBN);
		book.setBorrowedBy(null);
		return book;
	}

	

}
