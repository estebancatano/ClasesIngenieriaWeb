package co.edu.udea.iw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.service.ClienteService;

/**
 * Servlet que permite obtener la lista de cliente de la base de datos
 * @author Esteban Cataño Escobar
 * @version 1
 */
@WebServlet("/ListaClienteServlet" )
public class ListaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * Bean que va a ser inyectado por spring para manejar
	 * la lógica del negocio relaciona a la tabla Clientes 
	 */
	private ClienteService clienteService = null;
    /**
     * Constructor del Servlet
     * @see HttpServlet#HttpServlet()
     */
    public ListaClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Método Get que retorna la lista de cliente en una tabla html
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Cliente> lista = null;
		PrintWriter out = response.getWriter();
		out.print("<table border=" + 1 + ">"
				+ "<tr>"
				+ "<th>Cédula</th>"
				+ "<th>Nombre Completo</th>"
				+ "<th>Correo</th>"
				+ "</tr>");
		try {
			lista = clienteService.obtener();
			for(Cliente cliente : lista){
				out.print("<tr>");
				out.print("<td>" + cliente.getCedula() + "</td>");
				out.print("<td>" + cliente.getNombres() + "</td>");
				out.print("<td>" + cliente.getCorreoElectronico() + "</td>");
				out.print("</tr>");
			}
			out.print("\n</table>");
		} catch (IWDaoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			out.print("\n\n" + e.getMessage());
		}
		out.close();
	}

	/**
	 * Método que se invoca cuando se destruye el servlet
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	/** 
	 * Método que se inicia cuando se ejecuta el servlet por primera vez
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// Se invoca el método init del padre, y se le pasa la configuración
		super.init(config);
		// Se obtiene la fragmento de la memoria donde está ubicado el contexto de spring
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		// Se obtiene el bean llamado clienteService en el archivo de configuración de spring
		clienteService = (ClienteService) ac.getBean("clienteService");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
