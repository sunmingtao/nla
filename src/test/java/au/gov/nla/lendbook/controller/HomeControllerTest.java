package au.gov.nla.lendbook.controller;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import au.gov.nla.lendbook.dto.BookDto;
import au.gov.nla.lendbook.dto.PersonDto;
import au.gov.nla.lendbook.service.LendBookService;

/**
 * @author Mingtao Sun
 */
public class HomeControllerTest {

	private HomeController controller;
	private LendBookService service;
	private Model model;
	
	@Before
	public void before(){
		controller = new HomeController();
		service = createMock(LendBookService.class);
		model = createMock(Model.class);
		controller.setService(service);
	}
	
	@Test
	public void testShowAllBooks() {
		expect(model.addAttribute((String)anyObject(), anyObject())).andReturn(model);
		expect(service.retrieveAllBooks()).andReturn(new ArrayList<BookDto>());
		replay(model);
		replay(service);
		assertEquals(HomeController.BOOKS_VIEW, controller.showAllBooks(model));
	}

	@Test
	public void testShowAllPersons() {
		expect(model.addAttribute((String)anyObject(), anyObject())).andReturn(model);
		expect(service.retrieveAllPersons()).andReturn(new ArrayList<PersonDto>());
		replay(model);
		replay(service);
		assertEquals(HomeController.PERSONS_VIEW, controller.showAllPersons(model));
	}

}
