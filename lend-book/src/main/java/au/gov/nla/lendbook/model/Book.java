package au.gov.nla.lendbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class for BOOKS table 
 * @author Mingtao Sun
 */
@Entity
@Table(name="BOOKS")
public class Book extends BaseEntity{
	
	@Column(name="TITLE")
	private String title;
	@Column(name="AUTHOR")
	private String author;
	@Column(name="ISBN")
	private String isbn;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BORROWER_ID")
	private Person borrowedBy;

	public Book(){
		super();
	}
	
	public Book(long id) {
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
	public Person getBorrowedBy() {
		return borrowedBy;
	}
	public void setBorrowedBy(Person borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
}
