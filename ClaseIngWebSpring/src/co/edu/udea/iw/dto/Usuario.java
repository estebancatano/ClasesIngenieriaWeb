package co.edu.udea.iw.dto;

/**
 * Clase DTO que representa la tabla Clientes de la 
 * base de datos
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class Usuario {
	
	/**
	 * Nombre con el que el usuario inicia sesión
	 * Es la clave primaria
	 */
	private String login;
	
	/**
	 * Nombres del usuario
	 */
	private String nombres;
	
	/**
	 * Apellidos del usuario
	 */
	private String apellidos;
	
	/**
	 * Contraseña con la que el usuario inicia sesión
	 */
	private String contrasena;
	
	/**
	 * Rol del usuario
	 * Presenta integridad relacional a la tabla Roles
	 */
	private Rol rol;
	
	// Getters and Setters del DTO
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
