/**
 * 
 */
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.util.exception.MyException;

/**
 * Interfaz donde se define los métodos CRUD relacionados con la tabla clientes
 * de la base de datos
 * 
 * @author Esteban Cataño Escobar
 * @version 1
 */
public interface ClienteDAO {

	/**
	 * Metodo para insertar un cliente en la base datos
	 * @param cliente Objeto Cliente con la información del cliente a insertar
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public void insertar(Cliente cliente)throws MyException;
	
	/**
	 * Metodo para obtener todos los clientes en la base datos
	 * @return Lista con todas los clientes almacenados en la base de datos
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public List<Cliente> obtener()throws MyException;
	
	/**
	 *  Metodo para modificar un cliente de la base de datos
	 * @param cliente Objeto Cliente con la información del cliente a modificar
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public void modificar(Cliente cliente) throws MyException;
	
	/**
	 *  Metodo para eliminar un cliente de la base de datos
	 * @param cliente Objeto Cliente con la información del cliente a eliminar
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public void eliminar(Cliente cliente) throws MyException;
	
	/**
	 *  Metodo para obtener un solo cliente de la base de datos
	 * @param cedula Cedula del cliente que se desea consultar
	 * @return Objeto Cliente con la información del cliente consultado
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public Cliente obtener(String cedula) throws MyException;
	
	/**
	 *  Metodo para obtener una lista de clientes de la base de datos
	 * @param nombreColumna Nombre de la columna en la base de datos
	 * @param valorColumna Dato con  el que se quiere buscar en la columna especificada
	 * @return Lista de Cliente con la información del cliente consultado
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public List<Cliente> obtener(String nombreColumna, String valorColumna) throws MyException;
}