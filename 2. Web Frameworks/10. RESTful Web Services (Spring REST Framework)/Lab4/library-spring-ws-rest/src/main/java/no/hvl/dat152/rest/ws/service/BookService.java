/**
 * 
 */
package no.hvl.dat152.rest.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat152.rest.ws.exceptions.BookNotFoundException;
import no.hvl.dat152.rest.ws.model.Book;
import no.hvl.dat152.rest.ws.repository.BookRepository;

/**
 * 
 */
@Service
public class BookService {

	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository){
		this.bookRepository=bookRepository;
	}

	public Book saveBook(Book book) {
		
		return bookRepository.save(book);
		
	}
	
	public List<Book> findAll(){
		
		return (List<Book>) bookRepository.findAll();
		
	}
	
	public Book findByISBN(String isbn) throws BookNotFoundException {
		
		Book book = null;
		try {
			book = bookRepository.findBookByISBN(isbn);
		}catch(Exception e) {
			throw new BookNotFoundException("Book with isbn = "+isbn+" not found!");
		}
		
		if (book == null)
			throw new BookNotFoundException("Book with isbn = "+isbn+" not found!");
		else
			return book;
	}

    public void updateBook(Book newBook) throws BookNotFoundException{
        Book book = this.bookRepository.findBookByISBN(newBook.getIsbn());
		if (book==null)
			throw new BookNotFoundException("Book with isbn = "+newBook.getIsbn()+" not found!");
		this.bookRepository.save(newBook);
    }

    public void deleteByIsbn(String isbn) throws BookNotFoundException{
		Book book = this.bookRepository.findBookByISBN(isbn);
		if (book==null)
			throw new BookNotFoundException("Book with isbn = "+isbn+" not found!");
		this.bookRepository.delete(book);
    }

}
