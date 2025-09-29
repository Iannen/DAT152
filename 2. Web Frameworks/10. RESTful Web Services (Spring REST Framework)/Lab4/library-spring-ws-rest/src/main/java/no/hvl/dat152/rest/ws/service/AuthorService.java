/**
 * 
 */
package no.hvl.dat152.rest.ws.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import no.hvl.dat152.rest.ws.exceptions.DatabaseViolationException;
import no.hvl.dat152.rest.ws.exceptions.NoSuchResourceException;
import no.hvl.dat152.rest.ws.exceptions.PostWithIdException;
import no.hvl.dat152.rest.ws.model.Author;
import no.hvl.dat152.rest.ws.repository.AuthorRepository;

/**
 * 
 */
@Service
public class AuthorService {

	private AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository){
		this.authorRepository=authorRepository;
	}

	public Author findById(int id) throws NoSuchResourceException{
		
		return authorRepository.findById(id)
			.orElseThrow(()-> new NoSuchResourceException(id));
	}

	public List<Author> getAll() {
		return (List<Author>) authorRepository.findAll();
	}

	public Author createAuthor(Author author) throws PostWithIdException{
		if (author.getAuthorId()>0)
			throw new PostWithIdException(author.getAuthorId());
		return this.authorRepository.save(author);
	}

	public void updateAuthor(Author author) throws NoSuchResourceException {
		if (!this.authorRepository.existsById(author.getAuthorId()))
			throw new NoSuchResourceException(author.getAuthorId());
		this.authorRepository.save(author);
	}

    public void deleteAuthor(int authorId) throws NoSuchResourceException, DatabaseViolationException {
		if (!this.authorRepository.existsById(authorId))
			throw new NoSuchResourceException(authorId);
		try {
			this.authorRepository.deleteById(authorId);
		} catch (DataAccessException e){
			throw new DatabaseViolationException("Error due to foreign key constraint");
		}
    }

}
