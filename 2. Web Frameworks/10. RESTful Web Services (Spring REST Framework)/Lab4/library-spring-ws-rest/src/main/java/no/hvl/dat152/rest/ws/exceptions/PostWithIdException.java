/**
 * 
 */
package no.hvl.dat152.rest.ws.exceptions;

/**
 * 
 */
public class PostWithIdException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PostWithIdException(String id) {
		super("Cannot use POST with any id (id: "+id+" supplied)");
	}
	public PostWithIdException(int id) {
		this(id+"");
	}
}
