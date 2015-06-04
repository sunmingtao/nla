package au.gov.nla.lendbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.gov.nla.lendbook.converter.BookConverter;
import au.gov.nla.lendbook.converter.PersonConverter;
import au.gov.nla.lendbook.dto.BookDto;
import au.gov.nla.lendbook.dto.PersonDto;
import au.gov.nla.lendbook.model.Book;
import au.gov.nla.lendbook.model.Person;
import au.gov.nla.lendbook.service.LendBookService;

@Service
@Transactional
public class LendBookServiceImpl implements LendBookService {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private BookConverter bookConverter;
	@Autowired
	private PersonConverter personConverter;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BookDto> retrieveLentBooksByPerson(long personId) {
		Query q = entityManager.createQuery("select b from Book b where b.borrowedBy.id = :personId");
		q.setParameter("personId", personId);
		List<BookDto> list = new ArrayList<BookDto>();
		for (Book book : (List<Book>)q.getResultList()){
			list.add(bookConverter.convertFromEntityWithoutBorrower(book));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonDto> retrieveAllPersons() {
		Query q = entityManager.createQuery("select p from Person p");
		List<PersonDto> list = new ArrayList<PersonDto>();
		for (Person person : (List<Person>)q.getResultList()){
			list.add(personConverter.convertFromEntity(person));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookDto> retrieveAllBooks() {
		Query q = entityManager.createQuery("select b from Book b left join b.borrowedBy p");
		List<BookDto> list = new ArrayList<BookDto>();
		for (Book book : (List<Book>)q.getResultList()){
			list.add(bookConverter.convertFromEntityWithBorrower(book));
		}
		return list;
	}
}
