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

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sun.glass.ui.Application;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.service.ClienteService;

/**
 * Servlet implementation class ConsultarCliente, Envía a la vista del usuario
 * el resultado de la consulta de los clientes en una tabla con la información
 * de cedula, nombre y correo.
 * 
 * @author Vanesa Guzmán
 * @version 1.0
 * 
 */
@WebServlet("/ConsultarCliente")
public class ConsultarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteService clienteService = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultarCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Cliente> lista = null;
		PrintWriter out = response.getWriter();

		out.print("<table border=\"1\" >");
		out.print("<tr>");
		out.print("<th>" + "Cedula" + "</th>");
		out.print("<th>" + "Nombre Completo" + "</th>");
		out.print("<th>" + "Correo" + "</th>");
		out.print("</tr>");
		try {
			lista = clienteService.obtener();
			for (Cliente cliente : lista) {
				out.print("<tr>");
				out.print("<td>" + cliente.getCedula() + "</td>");
				out.print("<td>" + cliente.getNombres() + " " + cliente.getApellidos() + "</td>");
				out.print("<td>" + cliente.getCorreoElectronico() + "</td>");
				out.print("</tr>");

			}
			out.print("</table>");

		} catch (IWDaoException e) {

			e.printStackTrace();
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Fraccion de memoria, para que la tenga disponible, de esa fraccion
		// traer un bean llamado clienteService
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		clienteService = (ClienteService) ac.getBean("clienteService");
	}

}
