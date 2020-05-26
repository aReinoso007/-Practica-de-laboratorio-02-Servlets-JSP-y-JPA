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
 * Servlet implementation class ControladorSesiones
 */
@WebServlet( name = "controladorSesiones", urlPatterns= { "/controladorSesiones" })
public class ControladorSesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorSesiones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession sesion = request.getSession();
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));

		
		
		System.out.print("Id sesion IndexController: "+sesion.getAttribute("accesos"));
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();


			if (Integer.parseInt(request.getParameter("id")) == 1) {
				usuario=usuarioDao.read(request.getParameter("c"));
	             System.out.println("Cedula usar: "+request.getParameter("c"));

	             System.out.println("Apellido user: "+usuario.getApellido());
				request.setAttribute("idc", request.getParameter("c"));
				request.setAttribute("usuario", usuario);
				getServletContext().getRequestDispatcher("/JSPs/CrearUsuario.jsp").forward(request, response);

			} else if (Integer.parseInt(request.getParameter("id")) == 2) {

			
				usuario=usuarioDao.read(request.getParameter("idU"));
				
				request.setAttribute("telefono", telefonoDao.buscarCedula(usuario.getCedula()));
				request.setAttribute("usuario", usuario);
				getServletContext().getRequestDispatcher("/JSPs/indexUsuario.jsp").forward(request, response);

			}

		

		if (Integer.parseInt(request.getParameter("id")) == 3) {
			System.out.print("Esta ingresando....");

			request.setAttribute("telefono", telefonoDao.findAll());
			getServletContext().getRequestDispatcher("/JSPs/ModoInvitado.jsp").forward(request, response);

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
