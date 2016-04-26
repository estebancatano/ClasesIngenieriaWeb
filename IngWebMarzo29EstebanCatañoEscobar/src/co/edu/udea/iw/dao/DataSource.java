package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import co.edu.udea.iw.util.exception.MyException;

/**
 * Clase que proporciona metodos para interactuar con la base de datos
 * usando el patron DAO
 * 
 * @author Esteban Cataño Escobar
 * @version 1
 */
public class DataSource {
	/**
	 *  Instancia del log imporatado en la libreria log4j
	 */
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * Método para obtener una conexión a la base de datos
	 * @return Objeto Connection con la conexión a la base de datos
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public Connection getConnection() throws MyException{
		Connection con = null;
		try{
			// Se carga el driver de MySQL
			Class.forName("com.mysql.jdbc.Driver");
			// Se obtiene la conección a la base de datos de la ruta especificada
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase",
					"root","");
		}catch(ClassNotFoundException cnfe){
			//Se envia el error al log
			log.error(cnfe);
			//Se manda el hilo con la exception creada
			throw new MyException(cnfe);
		}catch (SQLException sqle) {
			//Se envia el error al log
			log.error(sqle);
			//Se manda el hilo con la exception creada
			throw new MyException(sqle);
		}
		return con;
	}
}
