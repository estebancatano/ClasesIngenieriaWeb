/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.util.exception.MyException;

/**
 * Clase que implementa la interfaz UsuarioDAO
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {

	/* 
	 * @see co.edu.udea.iw.dao.UsuarioDAO#obtener(java.lang.String)
	 */
	@Override
	public Usuario obtener(String login) throws MyException {
		// TODO Auto-generated method stub
		Usuario usuario = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = HibernateSessionFactory.getInstance().getSession();
			// Se crea el objeto criteria y se le agrega un restriccion de igualdad
			Criteria criteria = session.createCriteria(Usuario.class).add(
			Restrictions.eq("login", login));
			/* Se obtiene el único resultado. Si tiene más de uno, retorna error.
		    Si no tiene, retorna null */
			usuario = (Usuario) criteria.uniqueResult();
		}catch(HibernateException he){
			throw new MyException(he);
		} finally {
			// Si la sessión es diferente de null se cierra
			if(session != null){
				session.close();
			}
		}
		return usuario;
	}

}
