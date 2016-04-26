package co.edu.udea.iw.util.exception;

/**
 * Clase para personalizar las excepciones
 * @author Esteban Cataño Escobar
 * @version 1
 */
public class MyException extends Exception{

	
	private static final long serialVersionUID = 1L;

	
	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	

}
