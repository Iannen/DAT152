/**
 * 
 */
package no.hvl.dat152.rest.ws.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.hvl.dat152.rest.ws.exceptions.BookNotFoundException;
import no.hvl.dat152.rest.ws.model.Book;
import no.hvl.dat152.rest.ws.service.BookService;
import org.springframework.web.bind.annotation.PutMapping;


/**
 * 
 */
@RestController
@RequestMapping("/elibrary/api/v1")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService){
		this.bookService=bookService;
	}
	
	@GetMapping("/books")
	public ResponseEntity<Object> getAllBooks(){
		
		List<Book> books = bookService.findAll();
		
		if(books.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(books, HttpStatus.OK);		
	}
	
	@GetMapping("/books/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable String isbn) throws BookNotFoundException {
		
		Book book = bookService.findByISBN(isbn);
		
		if(book == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(book, HttpStatus.OK);		
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		
		Book nbook = bookService.saveBook(book);
		
		return new ResponseEntity<>(nbook, HttpStatus.CREATED);
	}
	@PutMapping("/books/{isbn}")
	public ResponseEntity<Void> updateBook(@PathVariable String isbn, @RequestBody Book book) throws BookNotFoundException {
		this.bookService.updateBook(book);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/books/{isbn}")
	public ResponseEntity<Void> deleteBook(@PathVariable String isbn) throws BookNotFoundException {
		this.bookService.deleteByIsbn(isbn);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
