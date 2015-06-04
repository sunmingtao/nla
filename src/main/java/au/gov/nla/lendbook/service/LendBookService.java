package au.gov.nla.lendbook.service;

import java.util.List;

import au.gov.nla.lendbook.dto.BookDto;
import au.gov.nla.lendbook.dto.PersonDto;

/**
 * Interface that provides lending books service
 * @author Mingtao Sun
 */
public interface LendBookService {
	/**
	 * Retrieve a list of books borrowed by specified person id
	 * @param personId person's Id
	 * @return
	 */
	List<BookDto> retrieveLentBooksByPerson(long personId);
	
	/**
	 * Retrieve all persons
	 * @return
	 */
	List<PersonDto> retrieveAllPersons();

	/**
	 * Retrieve all books
	 * @return
	 */
	List<BookDto> retrieveAllBooks();
}
