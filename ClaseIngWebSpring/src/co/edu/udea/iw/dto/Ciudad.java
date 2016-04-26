/**
 * 
 */
package co.edu.udea.iw.dto;

/**
 * Clase DTO que representa la tabla Ciudades de la 
 * base de datos
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class Ciudad {
	/**
	 * Codigo de la ciudad.
	 * Es la clave primaria
	 */
	private Long codigo;
	/**
	 * Nombre de la ciudad
	 * No puede ser nulo
	 */
	private String nombre;
	/**
	 * Codigo del área donde se encuentra ubicada la ciudad
	 * Puede ser nulo
	 */
	private String codigoArea;
	
	//Getters and Setter del DTO Ciudad
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
}
