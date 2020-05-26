package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.jpa.*;
import ec.edu.ups.dao.*;
import ec.edu.ups.entidad.Usuario;
/**
 * Servlet implementation class BuscarPorCedula
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		HttpSession sesion = request.getSession();
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));

			// out.println("<h1>Gracias por acceder al servidor</h1>");
			// sesion.setAttribute("accesos", 1);

			if (Integer.parseInt(request.getParameter("id")) == 1) {
				// Correo
				if (request.getParameter("correo") != null) {
					
					System.out.print("Correo: " + request.getParameter("correo"));
					
					request.setAttribute("telefono", telefonoDao.buscarCorreo(request.getParameter("correo")));
					getServletContext().getRequestDispatcher("/JSPs/Busquedas.jsp").forward(request, response);

				}

			} else {

			}

			if (Integer.parseInt(request.getParameter("id")) == 2) {
				// Cedula
				if (request.getParameter("cedula") != null) {
					System.out.print("Cedula: " + request.getParameter("cedula"));
					usuario = usuarioDao.read(request.getParameter("cedula"));
					request.setAttribute("usuario", usuario);
					request.setAttribute("telefono", telefonoDao.buscarCedInv(request.getParameter("cedula")));
					getServletContext().getRequestDispatcher("/JSPs/Busquedas.jsp").forward(request, response);
				}
			} else {

			}
		
	}

}
