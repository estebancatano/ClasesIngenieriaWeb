package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.util.exception.MyException;

/**
 * Interfaz donde se define los métodos CRUD relacionados con la tabla ciudades
 * de la base de datos
 * 
 * @author Esteban Cataño Escobar
 * @version 1
 */
public interface CiudadDAO {

	/**
	 * Metodo para insertar una ciudad en la base datos
	 * @param ciudad Objeto Ciudad con la información de la ciudad a insertar
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public void insertar(Ciudad ciudad)throws MyException;
	
	/**
	 * Metodo para obtener todas las ciudades en la base datos
	 * @return Lista con todas las ciudades almacenadas en la base de datos
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public List<Ciudad> obtener()throws MyException;
	
	/**
	 *  Metodo para modificar una ciudad de la base de datos
	 * @param ciudad Objeto Ciudad con la información de la ciudad a modificar
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public void modificar(Ciudad ciudad) throws MyException;
	
	/**
	 *  Metodo para eliminar una ciudad de la base de datos
	 * @param ciudad Objeto Ciudad con la información de la ciudad a eliminar
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public void eliminar(Ciudad ciudad) throws MyException;
	
	/**
	 *  Metodo para obtener una sola ciudad
	 * @param codigo Codigo de la ciudad que se desea consultar
	 * @return Objeto Ciudad con la información de la ciudad consultada
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public Ciudad obtener(long codigo) throws MyException;
}
