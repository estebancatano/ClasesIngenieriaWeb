/**
 * 
 */
package co.edu.udea.iw.bl.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.util.exception.MyException;
import co.edu.udea.iw.util.validation.Validacion;

/**
 * @author asus
 *
 */
public class ClienteBLImpl implements ClienteBL {
	@Autowired
	private ClienteDAO clienteDAO;
	
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.bl.ClienteBL#guardar(java.lang.String, java.lang.String, 
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void guardar(String cedula, String nombres, String apellidos, String email, 
			String usuarioCrea)
			throws MyException {
		Cliente cliente = null;
		// Verificar que los parámetros obligatorios no sean null
		if(cedula == null){
			throw new MyException("El parámetro cédula no puede ser nulo");
		}
		if(nombres == null){
			throw new MyException("El parámetro nombres no puede ser nulo");
		}
		if(apellidos == null){
			throw new MyException("El parámetro apellidos no puede ser nulo");
		}
		if(email == null){
			throw new MyException("El parámetro email no puede ser nulo");
		}
		if(usuarioCrea == null){
			throw new MyException("El parámetro usuarioCrea no puede ser nulo");
		}
		// Verificar que el correo no esté mal formado
		if(!Validacion.esEmailCorrecto(email)){
			throw new MyException("El correo está mal formado");
		}
		// Verificar que la cedula no exista en la base de datos
		cliente = clienteDAO.obtener(cedula);
		if (cliente != null) {
			throw new MyException("Ya existe un cliente en la base de datos con la cedula dada");
		}
		// Insertar el objeto en la base de datos
		cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuarioCrea);
		cliente.setFechaCreacion(new Date());
		clienteDAO.insertar(cliente);
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.bl.ClienteBL#eliminar(java.lang.String)
	 */
	@Override
	public void eliminar(String cedula) throws MyException {
		// TODO Auto-generated method stub
		Cliente cliente = null;
		// Verificar que la cedula no sea nula
		if(cedula == null){
			throw new MyException("El parámetro cédula no puede ser nulo");
		}
		// Consultar el cliente en la base de datos
		cliente = clienteDAO.obtener(cedula);
		if(cliente != null){
			clienteDAO.eliminar(cliente);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.bl.ClienteBL#actualizar(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void actualizar(String cedula, String nombres, String apellidos, String email, String usuarioModifica)
			throws MyException {
		// TODO Auto-generated method stub
		Cliente cliente = null;
		// Verificar que los parámetros obligatorios no sean null
		if(cedula == null){
			throw new MyException("El parámetro cédula no puede ser nulo");
		}
		if(nombres == null){
			throw new MyException("El parámetro nombres no puede ser nulo");
		}
		if(apellidos == null){
			throw new MyException("El parámetro apellidos no puede ser nulo");
		}
		if(email == null){
			throw new MyException("El parámetro email no puede ser nulo");
		}
		if(usuarioModifica == null){
			throw new MyException("El parámetro usuarioModifica no puede ser nulo");
		}
		// Verificar que el correo no esté mal formado
		if(!Validacion.esEmailCorrecto(email)){
			throw new MyException("El correo está mal formado");
		}
		// Verificar que el cliente existe en la base de datos
		cliente = clienteDAO.obtener(cedula);
		if (cliente != null) {
			// Modificar los datos del DTO;
			cliente.setNombres(nombres);
			cliente.setApellidos(apellidos);
			cliente.setEmail(email);
			cliente.setUsuarioModifica(usuarioModifica);
			cliente.setFechaModificacion(new Date());
			// Se actualiza el registro en la base de datos
			clienteDAO.modificar(cliente);
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.bl.ClienteBL#obtener()
	 */
	@Override
	public List<Cliente> obtener() throws MyException {
		// TODO Auto-generated method stub
		List<Cliente> clientes = null;
		// Consultar todos los cliente en la base de datos
		clientes = clienteDAO.obtener();
		return clientes;
	}
}