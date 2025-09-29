/**
 * 
 */
package no.hvl.dat152.rest.ws.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import no.hvl.dat152.rest.ws.exceptions.DatabaseViolationException;
import no.hvl.dat152.rest.ws.exceptions.NoSuchResourceException;
import no.hvl.dat152.rest.ws.exceptions.PostWithIdException;
import no.hvl.dat152.rest.ws.model.Author;
import no.hvl.dat152.rest.ws.service.AuthorService;

import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




/**
 * 
 */
@RestController
@RequestMapping("/elibrary/api/v1/authors")
public class AuthorController {

	private final AuthorService authorService;

	public AuthorController(AuthorService authorService){
		this.authorService=authorService;
	}

	@PostMapping()
	public ResponseEntity<Author> postAuthor(@RequestBody Author author) throws PostWithIdException{
		return new ResponseEntity<>(
			this.authorService.createAuthor(author),
			HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<Object> getAuthors() {
		return new ResponseEntity<>(
			this.authorService.getAll(),
			HttpStatus.OK);
	}

	@GetMapping("{authorId}")
	public ResponseEntity<Author> getMethodName(@PathVariable int authorId) throws NoSuchResourceException {
		return new ResponseEntity<>(
			this.authorService.findById(authorId),
			HttpStatus.OK
		);
	}

	@PutMapping("{authorId}")
	public ResponseEntity<Void> updateAuthor(@PathVariable int authorId, @RequestBody Author author) throws NoSuchResourceException{
		this.authorService.updateAuthor(author);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("{authorId}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable int authorId) throws NoSuchResourceException, DatabaseViolationException{
		this.authorService.deleteAuthor(authorId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
