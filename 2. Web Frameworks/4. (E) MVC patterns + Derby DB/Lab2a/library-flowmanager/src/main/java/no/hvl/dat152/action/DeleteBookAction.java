/**
 * 
 */
package no.hvl.dat152.action;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.dao.BookDAO;
import no.hvl.dat152.model.Book;

/**
 * 
 */
public class DeleteBookAction implements ControllerAction {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String isbn = request.getParameter("isbn");
		
		BookDAO dao = new BookDAO();
		dao.deleteBook(isbn);
		
		request.setAttribute("books", dao.getAllBooks());
		
		return ControllerAction.SUCCESS;

	}

}
