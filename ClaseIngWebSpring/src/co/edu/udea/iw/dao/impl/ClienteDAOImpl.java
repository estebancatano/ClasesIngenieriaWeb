package co.edu.udea.iw.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.util.exception.MyException;

/**
 * Clase que implementa la interfaz ClienteDAO
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class ClienteDAOImpl implements ClienteDAO {
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertar(Cliente cliente) throws MyException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
			Transaction tx = session.beginTransaction();
			session.save(cliente);
			tx.commit();
			
		}catch(HibernateException he){
			throw new MyException();
		}	
	}

	@Override
	public List<Cliente> obtener() throws MyException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Cliente> clientes = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Cliente.class);
			clientes = criteria.list();
		}catch(HibernateException he){
			throw new MyException();
		}		
		return clientes;	
	}

	@Override
	public void modificar(Cliente cliente) throws MyException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
			Transaction tx = session.beginTransaction();
			session.update(cliente);
			tx.commit();
			
		}catch(HibernateException he){
			throw new MyException();
		}
	}

	@Override
	public void eliminar(Cliente cliente) throws MyException {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			// Se utiliza el objeto Transaction para evitar que no lo guarde en la
			// cache, sino que lo inserte inmediatamente en la base de datos
			Transaction tx = session.beginTransaction();
			session.delete(cliente);
			tx.commit();
			
		}catch(HibernateException he){
			throw new MyException();
		}
	}

	@Override
	public Cliente obtener(String cedula) throws MyException {
		// TODO Auto-generated method stub
		Cliente cliente = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = sessionFactory.getCurrentSession();
			// Se crea el objeto criteria y se le agrega un restriccion de igualdad
			Criteria criteria = session.createCriteria(Cliente.class).add(
					Restrictions.eq("cedula", cedula));
			/* Se obtiene el único resultado. Si tiene más de uno, retorna error.
			   Si no tiene, retorna null */
			cliente = (Cliente) criteria.uniqueResult();
		}catch(HibernateException he){
			throw new MyException();
		}
		return cliente;
	}

	@Override
	public List<Cliente> obtener(String nombreColumna, String valorColumna) throws MyException {
		// TODO Auto-generated method stub
		List<Cliente> clientes = null;
		Session session = null;
		try{
			// Se obtiene la sessión a la base de datos
			session = sessionFactory.getCurrentSession();
			// Se crea el objeto criteria y se le agrega un restriccion de igualdad
			Criteria criteria = session.createCriteria(Cliente.class).add(
					Restrictions.eq(nombreColumna, valorColumna));
			/* Se obtienen los resultados de la consulta */
			clientes = criteria.list();
		}catch(HibernateException he){
			throw new MyException();
		}
		return clientes;
	}
}
