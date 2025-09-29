/**
 * 
 */
package no.hvl.dat152.rest.ws.exceptions;

/**
 * 
 */
public class DatabaseViolationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DatabaseViolationException(String errorMsg) {
		super(errorMsg);
	}
}
