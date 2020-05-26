package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Usuario;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearUsuario() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cedula = "";
		String nombre = "";
		String apellido = "";
		String correo = "";
		String pwd = "";

		Usuario user = new Usuario();

		String accion = request.getParameter("resp");
		UsuarioDAO users = DAOFactory.getFactory().getUsuarioDAO();

		if (accion.equals("Registrarse")) {

			cedula = request.getParameter("cdi");
			nombre = request.getParameter("nombre");
			apellido = request.getParameter("apellido");
			correo = request.getParameter("email");
			pwd = request.getParameter("password");

			user = new Usuario(cedula, nombre, apellido, correo, pwd);
			System.out.println("Usuario a ser creado: " + user);

			users.create(user);
			System.out.println("Usuario cread");

		}

		getServletContext().getRequestDispatcher("/JSPs/ExitoCreacion.jsp").forward(request, response);
	}

}
