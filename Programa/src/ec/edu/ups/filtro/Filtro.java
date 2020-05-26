package ec.edu.ups.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter(urlPatterns = { "/Filtro" }, servletNames = { "Buscar", "controladorSesiones", "LoginServlet", "AgregarNumero" })
public class Filtro implements Filter {

	/**
	 * Default constructor.
	 */
	public Filtro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long inicio = System.currentTimeMillis();
		// chain.doFilter(request, response);
		System.out.print("INFO: Tiempo de Proceso(  " + (System.currentTimeMillis() - inicio) + "  ms)");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession sesion = req.getSession();

		System.out.print("Accesos " + String.valueOf(sesion.getAttribute("accesos")));
		System.out.print(" IdSesion " + String.valueOf(sesion.getId()));
		if (String.valueOf(sesion.getAttribute("accesos")).equals(String.valueOf(sesion.getId()))) {

			System.out.print("Iguales");
			chain.doFilter(request, response);
		} else {
			System.out.print("No Iguales");
			res.sendRedirect("Login");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
