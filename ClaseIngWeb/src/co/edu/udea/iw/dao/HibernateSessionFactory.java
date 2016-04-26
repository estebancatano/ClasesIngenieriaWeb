package co.edu.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.iw.util.exception.MyException;

/**
 * Clase que representa el DataSource para implementar el patrón DAO
 * 
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class HibernateSessionFactory {
	private static HibernateSessionFactory hibernateSessionFactory;
	/**
	 * Atributo que contiene las sesiones de Hibernate
	 */
	private SessionFactory sessionFactory = null;
	/**
	 * Atributo para configurar el archivo de configuración de Hibernate
	 */
	private Configuration configuration = null;
	
	/**
	 * Método constructor protegido para evitar que se creen múltiples instancias de
	 * la clase {@link HibernateSessionFactory}, usando el patrón singleton 
	 */
	protected HibernateSessionFactory(){
		configuration = new Configuration();
	}
	
	/**
	 * Método para obtener una instancia del objeto {@link HibernateSessionFactory},
	 * implementando el patrón singlenton
	 * @return 
	 */
	public static HibernateSessionFactory getInstance(){
		if(hibernateSessionFactory == null){
			hibernateSessionFactory = new HibernateSessionFactory();
		}
		return hibernateSessionFactory;
	}
		
	/**
	 * Método para devolver sessiones activas a la base de datos
	 * @return Sesión Activa a la base de datos
	 * @throws MyException Manejador de excepciones personalizado
	 */
	public Session getSession() throws MyException{
		try{
			if (sessionFactory == null) {
				configuration.configure("co/edu/udea/iw/dao/cfg/hibernate.cfg.xml");
				sessionFactory = configuration.buildSessionFactory();
			}
		} catch(HibernateException he){
			throw new MyException(he);
		}
		return sessionFactory.openSession();
	}

	/** Método para evitar que se clonen el objeto de la clase
	 * que implementa el patrón singleton
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException();
	}
	
	
}
