package no.hvl.dat152.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat152.action.AddBookFormAction;
import no.hvl.dat152.action.AddBookAction;
import no.hvl.dat152.action.ControllerAction;
import no.hvl.dat152.action.UpdateBookAction;
import no.hvl.dat152.action.UpdateBookFormAction;
import no.hvl.dat152.action.ViewBookAction;
import no.hvl.dat152.action.ViewBooksAction;
import no.hvl.dat152.dao.AuthorDAO;
import no.hvl.dat152.dao.BookDAO;
import no.hvl.dat152.model.Author;
import no.hvl.dat152.model.Book;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * Servlet implementation class FrontController
 * @author tdoy
 */
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, ControllerAction> actions;
	
	@Override
    public final void init() throws ServletException {
		createActionsMap();
	}
	
	private void createActionsMap() {
		
		actions = new HashMap<>();
		
		actions.put("addbookform", new AddBookFormAction());
		actions.put("addbook", new AddBookAction());
		actions.put("updatebookform", new UpdateBookFormAction());
		actions.put("updatebook", new UpdateBookAction());
		actions.put("viewbook", new ViewBookAction());
		actions.put("viewbooks", new ViewBooksAction());
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String cmd = request.getPathInfo();
        System.out.println("cmd = "+cmd);
        
        if(cmd == null || cmd.length() == 1)
        	return;
        
        cmd = cmd.substring(1);
        
        final ControllerAction action = actions.get(cmd);
        action.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
