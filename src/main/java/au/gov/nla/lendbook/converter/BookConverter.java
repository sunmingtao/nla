package au.gov.nla.lendbook.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.gov.nla.lendbook.dto.BookDto;
import au.gov.nla.lendbook.model.Book;

/**
 * Converts Book entity to DTO
 * @author Mingtao Sun
 */
@Component
public class BookConverter {
	
	@Autowired
	private PersonConverter personConverter;
	
	/**
	 * Convert a Book entity to Book DTO with the person linked to the Book entity
	 * @param entity
	 * @return
	 */
	public BookDto convertFromEntityWithBorrower(Book entity){
		BookDto dto = convertFromEntityWithoutBorrower(entity);
		if (entity.getBorrowedBy() != null){
			dto.setBorrowedBy(personConverter.convertFromEntity(entity.getBorrowedBy()));	
		}
		return dto;
	}
	
	/**
	 * Convert a Book entity to Book DTO without the person linked to the Book entity
	 * @param entity
	 * @return
	 */
	public BookDto convertFromEntityWithoutBorrower(Book entity){
		BookDto dto = new BookDto(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setAuthor(entity.getAuthor());
		dto.setIsbn(entity.getIsbn());
		return dto;
	}

	/**
	 * For the sake of unit testing
	 * @param personConverter
	 */
	public void setPersonConverter(PersonConverter personConverter) {
		this.personConverter = personConverter;
	}
	
	
}
