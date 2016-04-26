/**
 * 
 */
package co.edu.udea.iw.bl;

import co.edu.udea.iw.util.exception.MyException;

/**
 * Interfaz donde se define los m�todos de la l�gica del negocio para 
 * la tabla clientes de la base de datos
 * 
 * @author Esteban Cata�o Escobar
 * @version 1
 */
public interface ClienteBL {
	
	/**
	 * M�todo de l�gica del negocio para guardar un Cliente
	 * en la base de datos
	 * @param cedula Cedula del Cliente
	 * @param nombres Nombres del Cliente
	 * @param apellidos Apellidos del Cliente
	 * @param email Correo El�ctronico del Cliente
	 * @param usuarioCrea Id del usuario que crea el cliente
	 * @throws MyException Manejador de excepciones propio
	 */
	public void guardar(String cedula, String nombres, String apellidos,
			String email, String usuarioCrea) throws MyException;
}
