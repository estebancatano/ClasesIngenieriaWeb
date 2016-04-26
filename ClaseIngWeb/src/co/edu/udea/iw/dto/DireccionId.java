package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Clase DTO que representa la clave primaria 
 * de la tabla Direcciones de la base de datos
 * @author Esteban Cataño Escobar
 * @version 1
 *
 */
public class DireccionId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Codigo de la dirección
	 */
	private Long codigo;
	/**
	 * Cliente al que pertenece la dirección
	 * Tiene clave foranea a la tabla Cliente
	 */
	private Cliente cliente;
	//Getters and Setter del DTO
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
