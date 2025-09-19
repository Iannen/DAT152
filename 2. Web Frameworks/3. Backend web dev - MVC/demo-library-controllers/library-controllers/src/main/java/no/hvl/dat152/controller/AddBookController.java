package no.hvl.dat152.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.dao.AuthorDAO;
import no.hvl.dat152.dao.BookDAO;
import no.hvl.dat152.model.Author;
import no.hvl.dat152.model.Book;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Servlet implementation class AddBookController
 * @author tdoy
 */
public class AddBookController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// auto create isbn (this is just a toy example)
		String isbn = UUID.randomUUID().toString();
		request.setAttribute("isbn", isbn);		
		
		// collect authors
		AuthorDAO dao = new AuthorDAO();
		List<Author> authors = dao.getAllAuthors();
		request.setAttribute("authors", authors);
		
		request.getRequestDispatcher("addbook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String authorid = request.getParameter("authorid");

		int author = Integer.parseInt(authorid);
		
		Book book = new Book(isbn, title, author);
		
		// save in DB
		BookDAO dao = new BookDAO();
		dao.addBook(book);
		
		response.sendRedirect("viewbooks");
	
	}

}
