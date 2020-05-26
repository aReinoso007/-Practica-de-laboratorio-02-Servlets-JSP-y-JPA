package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Telefono;
import ec.edu.ups.entidad.Usuario;


/**
 * Servlet implementation class EliminarNumero
 */
@WebServlet("/EliminarNumero")
public class EliminarNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarNumero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		Telefono telf= new Telefono();
		Usuario usuario = new Usuario();
		
		String id =request.getParameter("idUser");
		
		//telf=telefonoDao.read(Integer.parseInt(request.getParameter("id")));
		
		telefonoDao.delete(telf);
		
		try {
			usuario=usuarioDao.read(id);
			request.setAttribute("usuario", usuario);
			request.setAttribute("telefono", telefonoDao.buscarCedula(id));				
			getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("Error al eliminar " + e.getMessage());
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
