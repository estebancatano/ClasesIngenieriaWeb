/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.MyException;

/**
 * @author asus
 *
 */
public class UsuarioDAOImplTest {

	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.UsuarioDAOImpl#obtener(java.lang.String)}.
	 */
	@Test
	public void testObtener() {
		UsuarioDAO usuarioDAO = null;
		Usuario usuario = null;
		try{
			usuarioDAO = new UsuarioDAOImpl();
			usuario = usuarioDAO.obtener("elver");
			assertTrue(usuario != null);
			System.out.println("Nombre: " + usuario.getNombres());
			System.out.println("Nombre rol: " + usuario.getRol().getNombre());
		} catch (MyException e){
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

}
