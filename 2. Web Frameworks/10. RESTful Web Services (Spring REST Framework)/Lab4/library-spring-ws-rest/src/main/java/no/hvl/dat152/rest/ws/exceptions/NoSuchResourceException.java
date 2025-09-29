/**
 * 
 */
package no.hvl.dat152.rest.ws.exceptions;

/**
 * 
 */
public class NoSuchResourceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoSuchResourceException(String id) {
		super("No such resource (id: "+id+" supplied)");
	}

	public NoSuchResourceException(int id) {
		this(id+"");
	}
	
}
