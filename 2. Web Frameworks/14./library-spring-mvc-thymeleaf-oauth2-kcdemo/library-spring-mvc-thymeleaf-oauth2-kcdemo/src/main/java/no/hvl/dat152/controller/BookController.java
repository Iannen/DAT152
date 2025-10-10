/**
 * 
 */
package no.hvl.dat152.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import no.hvl.dat152.model.Book;
import no.hvl.dat152.service.BookService;

/**
 * @author tdoy
 */
@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	
	@GetMapping("/viewbooks")
	public String findAll(Model model) {
		
		// send a GET request to the REST WS at http://localhost:8090/elibrary/api/v1/books
		String endpoint = "http://localhost:8090/elibrary/api/v1/books";
		List<Book> books = (List<Book>) bookService.findAll(endpoint);
		model.addAttribute("books", books);
		
		return "viewbooks";
	}

}
