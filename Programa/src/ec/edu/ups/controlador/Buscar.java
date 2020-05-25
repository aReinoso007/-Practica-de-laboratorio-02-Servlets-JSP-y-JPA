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
 * Servlet implementation class Buscar
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
		// TODO Auto-generated method stub
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
		HttpSession sesion = request.getSession();
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		String url="";
		if(Integer.parseInt("id")==1) {
			if(request.getParameter("correo") != null) {
				System.out.println("Correo: "+request.getParameter("correo"));
				
				request.setAttribute("telefono", telefonoDAO.buscarCorreo(request.getParameter("correo")));
				getServletContext().getRequestDispatcher("/JSPs/Busquedas.jsp").forward(request, response);
			}
		}else {
			
		}
		
		if(Integer.parseInt(request.getParameter("id"))==2) {
			if (request.getParameter("cedula") != null) {
				System.out.print("Cedula: " + request.getParameter("cedula"));
				request.setAttribute("telefono", telefonoDAO.buscarCedula(request.getParameter("cedula")));
				getServletContext().getRequestDispatcher("/JSPs/Busquedas.jsp").forward(request, response);
			}
		}
	}

}
