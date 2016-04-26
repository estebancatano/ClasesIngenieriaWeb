package co.edu.udea.iw.main;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.impl.CiudadDAOImpl;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.util.exception.MyException;

/**
 * Clase en la cual se prueba la implementación del patrón DAO
 * @author Esteban Cataño Escobar
 * @version 1
 */
public class Main {
	
	/**
	 * Método por el cual se inicia la ejecución de la aplicación
	 * @param args Arreglo con los parametros especificados al invocar la aplicacion
	 */
	public static void main(String[] args){
		List<Ciudad> lista = null;
		Ciudad ciud = null;
		CiudadDAO dao = new CiudadDAOImpl();
		try{
			System.out.println("Se consulta todas las ciudades en la base de datos");
			// Se llama el método para obtener todas las ciudades
			lista = dao.obtener();
			// Se recorre la lista y se muestra su nombre
			for(Ciudad ciudad:lista){
				System.out.println("Nombre: "+ ciudad.getNombre());
			}
			// Se crea una nueva ciudad para las demas pruebas
			ciud = new Ciudad();
			ciud.setCodigo(99);
			ciud.setNombre("Ciudad Falsa");
			ciud.setCodigoArea("123");
			System.out.println("Se inserta la ciudad " + ciud.getNombre() + " con codigo "
					+ ciud.getCodigo());
			// Se inserta la ciudad
			dao.insertar(ciud);
			System.out.println("Se consulta la ciudad con codigo " + ciud.getCodigo());
			// Se llama el método para obtener una ciudad por codigo
			ciud = dao.obtener(ciud.getCodigo());
			System.out.println("Resultado: Codigo " + ciud.getCodigo() + " Nombre " + ciud.getNombre() );
			System.out.println("Se cambia el codigo de area " + ciud.getCodigoArea() +
					" por 10");
			ciud.setCodigoArea("10");
			// Se invoca el método 	que permite modificar una ciudad
			dao.modificar(ciud);
			System.out.println("Se elimina la ciudad con codigo " + ciud.getCodigo());
			// Se llama el método para eliminar ciudad
			dao.eliminar(ciud);
			System.out.println("Fin de la prueba");
		}catch(MyException e){
			System.out.println(e.getMessage());
		}
	}
}
