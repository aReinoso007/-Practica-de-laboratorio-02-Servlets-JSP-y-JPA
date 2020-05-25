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
@WebServlet(name = "LoginServlet", urlPatterns= {"/LoginServlet"})
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		String correo ="";
		String contrasena = "";
		String url = null;
		
		String accion  = request.getParameter("resp");
		Usuario user = new Usuario();
		HttpSession sesion = request.getSession(true);
		
		if(accion.equals("Login")) {
			correo = request.getParameter("user");
			contrasena = request.getParameter("password");
			user = usuarioDAO.buscar(correo, contrasena);
			System.out.println("retorno de usuario: "+ usuarioDAO.buscar(correo, contrasena));
			url="/JSPs/IndexUsuario.jsp";
			try {
				if(user != null) {
					TelefonoDAO telfDAO = DAOFactory.getFactory().getTelefonoDAO();
					
					request.setAttribute("telefono", telfDAO.buscarCedula(user.getId()));
					request.setAttribute("usuario", user);
					getServletContext().getRequestDispatcher(url).forward(request, response);
				}
			}catch(Exception e) {
				System.out.println(">>>Error:LoginServlet:DOPOST "+e.getMessage());
			}
		}else {
			getServletContext().getRequestDispatcher("/JSPs/Login.jsp").forward(request, response);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
