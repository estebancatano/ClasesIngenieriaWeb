/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.util.exception.MyException;

/**
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:SpringConfiguration.xml"})
public class CiudadDAOImplTest {
	@Autowired
	CiudadDAO ciudadDAO;
	
	/**
	 * Test method for {@link co.edu.udea.iw.dao.impl.CiudadDAOImpl#obtener()}.
	 */
	@Test
	public void testObtener() {
		//CiudadDAO ciudadDAO = null;
		List<Ciudad> ciudades = null;
		try{
			//ciudadDAO = new CiudadDAOImpl();
			ciudades = ciudadDAO.obtener();
			assertTrue(ciudades.size() > 0);
		} catch (MyException e){
			e.printStackTrace();
			//System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
}
