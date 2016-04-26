package co.edu.udea.iw.dto;

/**
 * Clase DTO que representa la tabla Roles de la 
 * base de datos
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class Rol {
	/**
	 * Codigo que identifica el rol
	 * Es la clave primaria
	 */
	private String codigo;
	/**
	 * Nombre del rol
	 */
	private String nombre;
	
	// Getters and Setters del DTO
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
