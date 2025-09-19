package no.hvl.dat152.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.dao.BookDAO;
import no.hvl.dat152.model.Book;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ViewBooksController
 * @author tdoy
 */
public class ViewBooksController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDAO bookDAO = new BookDAO();
		
		List<Book> books = bookDAO.getAllBooks();
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("viewbooks.jsp").forward(request, response);
	}

}
