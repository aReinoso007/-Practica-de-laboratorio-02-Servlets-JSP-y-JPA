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
import ec.edu.ups.entidad.*;

/**
 * Servlet implementation class AgregarNumero
 */
@WebServlet("/AgregarNumero")
public class AgregarNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarNumero() {
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
		
		String numero="";
		String tipo = "";
		String operadora="";
		
		HttpSession sesion = request.getSession();
		
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		
		
		
		Telefono telf = new Telefono();
		Usuario user = new Usuario();
		String accion = request.getParameter("agregar");
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		
		if (accion.equals("ingresar")) {
			
			//user = request.getParameter("usr");
			numero = request.getParameter("numero");
			tipo = request.getParameter("tipo");
			operadora = request.getParameter("operadora");
			user=usuarioDao.read(request.getParameter("ced"));
			System.out.println("datos recolectados "+numero +", "+operadora+", "+tipo+","+ user);
			
			System.out.print("CEDULA:   "+request.getParameter("ced"));
			telf = new Telefono( numero, tipo, operadora, user);
			
			telefonoDao.create(telf);
			
			try {
				request.setAttribute("usuario", user);
				request.setAttribute("telefono", telefonoDao.buscarCedula( request.getParameter("ced")));				
				getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		
	}

}
