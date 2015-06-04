package au.gov.nla.lendbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import au.gov.nla.lendbook.dto.BookDto;
import au.gov.nla.lendbook.service.LendBookService;

/**
 * Controller that handles incoming requests 
 * @author Mingtao Sun
 */
@Controller
public class HomeController {
	
	protected static final String PERSONS_VIEW = "persons";
	protected static final String BOOKS_VIEW = "books";
	
	@Autowired
	private LendBookService service;
	
	/**
	 * Handle request to show all books
	 * @param model
	 * @return view id of books
	 */
	@RequestMapping(value = {"/allbooks", "/"}, method = RequestMethod.GET)
	public String showAllBooks(Model model){
		model.addAttribute(BOOKS_VIEW, service.retrieveAllBooks());
		return BOOKS_VIEW;
	}
	
	/**
	 * Handle request to show all persons
	 * @param model
	 * @return view id of persons
	 */
	@RequestMapping(value = "/allpersons", method = RequestMethod.GET)
	public String showAllPersons(Model model){
		model.addAttribute(PERSONS_VIEW, service.retrieveAllPersons());
		return PERSONS_VIEW;
	}
	
	/**
	 * Return a list of books borrowed by the specified person Id
	 * @param personId person's id
	 * @return A json string representing a list of books
	 */
	@RequestMapping(value="/loadbooks/{personId}", method=RequestMethod.GET) 
    public @ResponseBody List<BookDto> loadBooks(@PathVariable("personId") long personId) {
		return service.retrieveLentBooksByPerson(personId);
    }

	/**
	 * Just for the sake unit testing
	 * @param service
	 */
	protected void setService(LendBookService service) {
		this.service = service;
	}
	
	
}

