package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		System.out.print("Iniciar Sesion \n");

		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		String correo = "";
		String contrasena = "";
		String url = null;
		int i = 0;

		String accion = request.getParameter("resp");
		Usuario user = new Usuario();

		// out.println("<h1>Gracias por acceder al servidor</h1>");

		if (accion.equals("Login")) {
			correo = request.getParameter("user");
			contrasena = request.getParameter("password");
			user = usuarioDao.buscar(correo, contrasena);
		//	System.out.print(user.getApellido()+user.getCorreo());
		}

		try {
			if (user != null) {
				TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
				// System.out.println(telefonoDao.find().telf_id +','+ str.id_user
				// +','+str.numero+','+str.tipo+','+str.operadora);
				
				  
				  request.setAttribute("telefono", telefonoDao.buscarCedula(user.getCedula()));
				  request.setAttribute("usuario", user);
				 
				getServletContext().getRequestDispatcher("/JSPs/indexUsuario.jsp").forward(request, response);
			
			} else {
				// url="/Public/login.jsp";
				getServletContext().getRequestDispatcher("/JSPs/login.jsp").forward(request, response);
			}

			}catch (Exception e) {
				// TODO: handle exception
			}
		
		
	}

}
