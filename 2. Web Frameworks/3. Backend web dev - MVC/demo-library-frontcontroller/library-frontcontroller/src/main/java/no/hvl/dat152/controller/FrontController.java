package no.hvl.dat152.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.database.AuthorDAO;
import no.hvl.dat152.database.BookDAO;
import no.hvl.dat152.model.Author;
import no.hvl.dat152.model.Book;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


/**
 * Servlet implementation class FrontController
 * @author tdoy
 */
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        final String cmd = request.getPathInfo();
        System.out.println("cmd = "+cmd);
        
        if (cmd.equals("/addbook")) {
            addBookForm(request, response);
        } else if (cmd.equals("/updatebook")) {
            updateBookForm(request, response);
        } else if (cmd.equals("/viewbook")) {
            viewBook(request, response);
        } else if (cmd.equals("/viewbooks")) {
            viewBooks(request, response);
        } else if(cmd.equals("/addbooksave")) {
        	addBook(request, response);
        } else if(cmd.equals("/updatebooksave")) {
        	updateBook(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void addBookForm(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		// auto create isbn (this is just a toy example)
		String isbn = UUID.randomUUID().toString();
		request.setAttribute("isbn", isbn);		
		
		// collect authors
		AuthorDAO dao = new AuthorDAO();
		List<Author> authors = dao.getAllAuthors();
		request.setAttribute("authors", authors);
		
		request.getRequestDispatcher("../addbook.jsp").forward(request, response);
	}
	
	private void addBook(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
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
	
	private void updateBookForm(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		String isbn = request.getParameter("isbn");	
		
		BookDAO bookDAO = new BookDAO();		
		Book book = bookDAO.getBookByISBN(isbn);
		request.setAttribute("book", book);
		
		// collect authors
		AuthorDAO dao = new AuthorDAO();
		List<Author> authors = dao.getAllAuthors();
		request.setAttribute("authors", authors);
		
		request.getRequestDispatcher("../updatebook.jsp").forward(request, response);
	}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
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
	
	private void viewBook(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		String isbn = request.getParameter("isbn");
		String authorid = request.getParameter("authorid");

		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.getBookByISBN(isbn);
		
		AuthorDAO authorDAO = new AuthorDAO();
		Author author = authorDAO.getAuthorByID(Integer.parseInt(authorid));
		
		request.setAttribute("book", book);
		request.setAttribute("author", author);
		
		request.getRequestDispatcher("../viewbook.jsp").forward(request, response);
	}
	
	private void viewBooks(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		BookDAO bookDAO = new BookDAO();
		
		List<Book> books = bookDAO.getAllBooks();
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("../viewbooks.jsp").forward(request, response);
	}

}
