package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.MyException;

/**
 * Interfaz donde se define los m�todos CRUD relacionados con la tabla usuarios
 * de la base de datos
 * 
 * @author Esteban Cata�o Escobar
 * @version 1
 */
public interface UsuarioDAO {
	
	/**
	 *  Metodo para obtener un usuario de la base de datos
	 * @param login Nombre con el que el usuario inicia sesi�n
	 * @return Objeto Usuario con la informaci�n del usuario consultado
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public Usuario obtener(String login) throws MyException;
}
