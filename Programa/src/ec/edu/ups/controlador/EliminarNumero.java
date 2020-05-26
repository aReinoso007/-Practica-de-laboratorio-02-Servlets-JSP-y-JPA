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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		UsuarioDAO usuDAO = DAOFactory.getFactory().getUsuarioDAO();
		TelefonoDAO telDAO = DAOFactory.getFactory().getTelefonoDAO();
		Telefono telefono = new Telefono();
		Usuario usuario = new Usuario();
		
		
		String id= request.getParameter("idUser");
		//telfID = request.getParameter("id");
		
		System.out.println("el id del telefono: "+request.getParameter("id"));
		
		
		telefono = telDAO.read(request.getParameter("id"));
		System.out.println("Telefono recuperado "+telefono);
		System.out.println("telefono para eliminar "+telefono);
		System.out.println("cedula del usuario en delete:" +id);
		

		telDAO.delete(telefono);
		
		
		try {
			
			usuario = usuDAO.read(id);
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("telefono", telDAO.buscarCedula(usuario.getCedula()));
			//System.out.println("lista de telefonos");
			//System.out.println(telDAO.find());
			
			getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);
			
		}catch(Exception e) {
			System.out.println("Error al eliminar " + e.getMessage());
		}
		//getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
