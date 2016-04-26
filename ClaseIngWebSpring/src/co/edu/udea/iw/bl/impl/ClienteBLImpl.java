/**
 * 
 */
package co.edu.udea.iw.bl.impl;

import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.util.exception.MyException;

/**
 * @author asus
 *
 */
public class ClienteBLImpl implements ClienteBL {
	private ClienteDAO clienteDAO;
	
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.bl.ClienteBL#guardar(java.lang.String, java.lang.String, 
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void guardar(String cedula, String nombres, String apellidos, String email, 
			String usuarioCrea)
			throws MyException {
		// Verificar que los par�metros obligatorios no sean null
		// Verificar que el correo no est� mal formado
		// Verificar que la cedula no exista en la base de datos
		// Insertar el objeto en la base de datos
	}
	
	// Eliminar Cliente
	// Modificar Cliente (Obtener el cliente con la cedula, luego reemplazar 
	//			los par�metros e invocar el m�todo update
	// Obtener la lista de clientes

}
