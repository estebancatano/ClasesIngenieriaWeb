package co.edu.udea.iw.dto;

/**
 * Clase para representar un objeto tipo DTO relacionado con la
 * tabla ciudades de la base de datos
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class Ciudad {
	/**
	 * Codigo de la ciudad
	 */
	private long codigo; 
	/**
	 * Nombre de la ciudad
	 */
	private String nombre;
	/**
	 * Codigo de area de la ciudad
	 */
	private String codigoArea;
	
	// Se crean los métodos getters y setters para los atributos definidos
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
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
