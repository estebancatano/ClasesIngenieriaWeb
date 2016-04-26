/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.util.exception.MyException;

/**
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class CiudadDAOImplTest {
	
	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.CiudadDAOImpl#obtener()}.
	 */
	@Test
	public void testObtener() {
		CiudadDAO ciudadDAO = null;
		List<Ciudad> ciudades = null;
		try{
			ciudadDAO = new CiudadDAOImpl();
			ciudades = ciudadDAO.obtener();
			assertTrue(ciudades.size() > 0);
		} catch (MyException e){
			fail(e.getMessage());
		}
	}
}
