package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//Identidad de negocio
@Path("Saludo")
public class HolaMundo {

	// Configurar el arch xml y unas anotaciones para que se pueda encontrar
	// como WS

	// Qúe tipo de dato va a entregar
	@Produces(MediaType.TEXT_HTML)
	// Indico el tipo de operación a realizar: PUT=crear
	// Agrego queryParam
	@GET
	public String saludar(@QueryParam("nombre") String nombreCompleto) {
		return "Buenas tardes" + nombreCompleto;
	}

	@Path("Saludo2/{nombre}/{apellidos}")
	// Qúe tipo de dato va a entregar
	@Produces(MediaType.TEXT_HTML)
	// Indico el tipo de operación a realizar: PUT=crear
	// Agrego queryParam
	@GET
	public String saludar(@PathParam("nombre") String nombreCompleto, @PathParam("apellidos") String apellidos) {
		return "Buenas tardes" + nombreCompleto+ apellidos;
	}
}
