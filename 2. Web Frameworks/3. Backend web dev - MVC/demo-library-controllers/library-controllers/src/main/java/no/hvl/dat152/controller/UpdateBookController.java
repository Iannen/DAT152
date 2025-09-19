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

/**
 * Servlet implementation class UpdateBookController
 */
public class UpdateBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");	
		
		BookDAO bookDAO = new BookDAO();		
		Book book = bookDAO.getBookByISBN(isbn);
		request.setAttribute("book", book);
		
		// collect authors
		AuthorDAO dao = new AuthorDAO();
		List<Author> authors = dao.getAllAuthors();
		request.setAttribute("authors", authors);
		
		request.getRequestDispatcher("updatebook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String authorid = request.getParameter("authorid");

		int author = Integer.parseInt(authorid);
		
		// save in DB
		BookDAO dao = new BookDAO();
		boolean success = dao.updateBook(isbn, title, author);
		if(success)
			response.sendRedirect("viewbook?isbn="+isbn+"&authorid="+authorid);
		else
			response.sendError(401, "Update Not Successful...");
	}

}
