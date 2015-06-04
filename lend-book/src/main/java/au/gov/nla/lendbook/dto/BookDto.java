package au.gov.nla.lendbook.dto;


/**
 * Book DTO
 * @author Mingtao Sun
 */
public class BookDto extends BaseDto{
	private String title;
	private String author;
	private String isbn;
	private PersonDto borrowedBy;
	public BookDto() {
		super(0L);
	}
	public BookDto(long id) {
		super(id);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public PersonDto getBorrowedBy() {
		return borrowedBy;
	}
	public void setBorrowedBy(PersonDto borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
}
