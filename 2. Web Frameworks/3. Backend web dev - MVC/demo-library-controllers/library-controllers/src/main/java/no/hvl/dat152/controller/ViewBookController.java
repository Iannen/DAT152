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

/**
 * Servlet implementation class ViewBookController
 * @author tdoy
 */
public class ViewBookController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		String authorid = request.getParameter("authorid");

		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.getBookByISBN(isbn);
		
		AuthorDAO authorDAO = new AuthorDAO();
		Author author = authorDAO.getAuthorByID(Integer.parseInt(authorid));
		
		request.setAttribute("book", book);
		request.setAttribute("author", author);
		
		request.getRequestDispatcher("viewbook.jsp").forward(request, response);
	}

}
