package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.MyException;

/**
 * Interfaz donde se define los métodos CRUD relacionados con la tabla usuarios
 * de la base de datos
 * 
 * @author Esteban Cataño Escobar
 * @version 1
 */
public interface UsuarioDAO {
	
	/**
	 *  Metodo para obtener un usuario de la base de datos
	 * @param login Nombre con el que el usuario inicia sesión
	 * @return Objeto Usuario con la información del usuario consultado
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public Usuario obtener(String login) throws MyException;
}
