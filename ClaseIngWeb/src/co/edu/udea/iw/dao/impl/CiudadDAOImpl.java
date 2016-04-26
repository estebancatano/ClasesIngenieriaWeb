/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.util.exception.MyException;

/**
 * Clase que implementa la interfaz CiudadDAO
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class CiudadDAOImpl implements CiudadDAO{

	@Override
	public void insertar(Ciudad ciudad) throws MyException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HibernateSessionFactory.getInstance().getSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
			Transaction tx = session.beginTransaction();
			session.save(ciudad);
			tx.commit();
			
		}catch(HibernateException he){
			throw new MyException();
		}finally{
			if(session != null){
				session.close();
			}
		}	
	}

	@Override
	public List<Ciudad> obtener() throws MyException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Ciudad> ciudades = null;
		try{
			session = HibernateSessionFactory.getInstance().getSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			ciudades = criteria.list();
		}catch(HibernateException he){
			throw new MyException();
		}finally{
			if(session != null){
				session.close();
			}
		}		
		return ciudades;
	}

	@Override
	public void modificar(Ciudad ciudad) throws MyException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HibernateSessionFactory.getInstance().getSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
			Transaction tx = session.beginTransaction();
			session.update(ciudad);
			tx.commit();
			
		}catch(HibernateException he){
			throw new MyException();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

	@Override
	public void eliminar(Ciudad ciudad) throws MyException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = HibernateSessionFactory.getInstance().getSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
			Transaction tx = session.beginTransaction();
			session.delete(ciudad);
			tx.commit();
			
		}catch(HibernateException he){
			throw new MyException();
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

	@Override
	public Ciudad obtener(long codigo) throws MyException {
		// TODO Auto-generated method stub
		Ciudad ciudad = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = HibernateSessionFactory.getInstance().getSession();
			// Se crear el objeto criteria y se le agrega un restriccion de igualdad
			Criteria criteria = session.createCriteria(Ciudad.class).add(
					Restrictions.eq("codigo", codigo));
			/* Se obtiene el único resultado. Si tiene más de uno, retorna error.
			   Si no tiene, retorna null */
			ciudad = (Ciudad) criteria.uniqueResult();
			/* Otras formas de realizar la consulta por la clave primaria
			get: Retorna null cuando no existe el registro
			ciudad = (Ciudad) session.get(Ciudad.class, codigo);
			load: Retorna una excepción cuando no existe el registro
			 	  Carga el objeto cuando se va a usar
			ciudad = (Ciudad) session.load(Ciudad.class, codigo); */
		}catch(HibernateException he){
			throw new MyException();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return ciudad;
	}
	
}
