/**
 * 
 */
package co.edu.udea.iw.dto;

import java.util.Date;
import java.util.Set;

/**
 * Clase DTO que representa la tabla Clientes de la 
 * base de datos
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class Cliente {
	/**
	 * Cedula del cliente
	 * Es la clave primaria
	 */
	private String cedula;
	/**
	 * Nombres del cliente
	 */
	private String nombres;
	/**
	 * Apellidos del cliente
	 */
	private String apellidos;
	/**
	 * Correo eléctronico del cliente
	 */
	private String email;
	/**
	 * Usuario que crea el cliente
	 */
	private String usuarioCrea;
	/**
	 * Fecha de Creación del cliente
	 */
	private Date fechaCreacion;
	/**
	 * Usuario que modifica el cliente
	 */
	private String usuarioModifica;
	/**
	 * Fecha de modificacion del cliente
	 */
	private Date fechaModificacion;
	/**
	 * Indica si el cliente fue eliminado
	 */
	private boolean eliminado;
	/**
	 * Usuario que elimina el cliente
	 */
	private String usuarioElimina;
	/**
	 * Fecha de eliminacion del cliente
	 */
	private String fechaEliminacion;
	/**
	 * Atributo que se crea para crear una
	 * relación Maestro-Detalle
	 * Para que cargue todos las direcciones 
	 * asociadas al cliente. ¡Así esta columna no
	 * exista en la base de datos!
	 */
	private Set<Direccion> direcciones;
	
	// Getters and Setters del DTO
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(String usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	public String getUsuarioElimina() {
		return usuarioElimina;
	}
	public void setUsuarioElimina(String usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	public String getFechaEliminacion() {
		return fechaEliminacion;
	}
	public void setFechaEliminacion(String fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
	public Set<Direccion> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
}
