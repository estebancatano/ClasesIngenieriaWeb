package co.edu.udea.iw.ws;

import co.edu.udea.iw.service.ClienteService;
import javassist.tools.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.ClienteDTOWS;
import co.edu.udea.iw.exception.IWDaoException;

//se agregan mínimo dos notaciones para se webservice
@Component
@Path("Cliente")
public class ClienteWS {

	// Cliente service, nadie lo inicializó -> se inyecta con @Autowired
	// Para ello se debe anotar la clase con @component y en el arch de conf de
	// Spring y se agrega la sig línea
	@Autowired
	ClienteService clienteService;

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<ClienteDTOWS> obtener() throws RemoteException {
		List<ClienteDTOWS> lista = new ArrayList<ClienteDTOWS>();
		//List<Cliente> lista2 = new ArrayList<Cliente>();
		try {
		//lista2 =clienteService.obtener();
			for (Cliente cliente : clienteService.obtener()) {
				ClienteDTOWS clienteDTOWS = new ClienteDTOWS();
				clienteDTOWS.setCedula(cliente.getCedula());
				clienteDTOWS.setNombres(cliente.getNombres());
				clienteDTOWS.setApellidos(cliente.getApellidos());
				clienteDTOWS.setEmail(cliente.getCorreoElectronico());
				lista.add(clienteDTOWS);
			}
		} catch (IWDaoException e) {
			throw new RemoteException(e);
		}
		return lista;
	}
}
