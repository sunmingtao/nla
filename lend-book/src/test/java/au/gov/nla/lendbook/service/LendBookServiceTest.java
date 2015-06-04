package au.gov.nla.lendbook.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import au.gov.nla.lendbook.dto.BookDto;
import au.gov.nla.lendbook.dto.PersonDto;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/context/application-context.xml"})
@TransactionConfiguration(defaultRollback = true)
public class LendBookServiceTest {
	
	@Autowired
	private LendBookService service;
	
	@Test
	public void retrieveAllPersons(){
		List<PersonDto> list = service.retrieveAllPersons();
		assertTrue(list.size() > 0);
		PersonDto person = list.get(0);
		assertTrue(person.getId() > 0);
		assertNotNull(person.getEmail());
		assertNotNull(person.getName());
		assertNotNull(person.getPhone());
	}
	
	@Test
	public void retrieveAllBooks(){
		List<BookDto> list = service.retrieveAllBooks();
		assertTrue(list.size() > 0);
		BookDto book = list.get(0);
		assertTrue(book.getId() > 0);
		assertNotNull(book.getAuthor());
		assertNotNull(book.getTitle());
		assertNotNull(book.getIsbn());
		assertNotNull(book.getBorrowedBy());
	}
	
	@Test
	public void retrieveLentBooksByPerson(){
		List<BookDto> list = service.retrieveLentBooksByPerson(3L);
		assertTrue(list.size() > 0);
		BookDto book = list.get(0);
		assertTrue(book.getId() > 0);
		assertNotNull(book.getAuthor());
		assertNotNull(book.getTitle());
		assertNotNull(book.getIsbn());
	}
}
