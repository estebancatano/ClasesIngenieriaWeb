package co.edu.udea.iw.dto;

/**
 * Clase DTO que representa la tabla Direcciones 
 * de la base de datos
 * @author Esteban Cata�o Escobar
 * @version 1
 *
 */
public class Direccion {
	/**
	 * Clave primaria compuesta de la tabla Direcci�n
	 */
	private DireccionId id;
	/**
	 * ciudad a la que pertenece la direcci�n
	 */
	private Ciudad ciudad;
	/**
	 * Direcci�n en la ciudad
	 */
	private String direccion;
	/**
	 * Telefono de la ciudad
	 */
	private long telefono;
	/**
	 * Indica si la direcci�n es marcado
	 * como preferida
	 */
	private boolean preferida;
	// Getters and Setters
	public DireccionId getId() {
		return id;
	}
	public void setId(DireccionId id) {
		this.id = id;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public boolean isPreferida() {
		return preferida;
	}
	public void setPreferida(boolean preferida) {
		this.preferida = preferida;
	}
}
