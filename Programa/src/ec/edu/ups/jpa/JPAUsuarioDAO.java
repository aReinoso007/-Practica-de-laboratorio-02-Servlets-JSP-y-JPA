package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Persistence;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.*;


public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{
	
	public JPAUsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
		this.em = Persistence.createEntityManagerFactory("jpa2").createEntityManager();
	}


	/*
	 * @Override public Usuario buscar(String email, String contrasena) {
	 * 
	 * System.out.println("Email: ------------- "+email.toString()); int i=0;
	 * Usuario usuarioObject = null; ResultSet rs =
	 * conexionUno.query("SELECT * FROM Usuario WHERE  correo=" + "'" + email + "'"
	 * + "AND contrasena=" + "'" + contrasena + "'" ); try { if (rs != null &&
	 * rs.next()) { i=1; usuarioObject = new Usuario (rs.getString("cedula"),
	 * rs.getString("nombre"), rs.getString("apellido"),rs.getString("correo"),
	 * rs.getString("contrasena")); } } catch (SQLException e) {
	 * System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage()); }
	 * 
	 * 
	 * 
	 * return usuarioObject;
	 * 
	 * return null; }
	 */

	/*
	 * @Override public Usuario read(String id) { // TODO Auto-generated method stub
	 * 
	 * Usuario usuarioObject = null;
	 * 
	 * ResultSet rs = conexionUno.query("SELECT * FROM Usuario WHERE cedula=" + id);
	 * try { if (rs != null && rs.next()) { usuarioObject = new Usuario
	 * (rs.getString("cedula"), rs.getString("nombre"),
	 * rs.getString("apellido"),rs.getString("correo"), rs.getString("contrasena"));
	 * } } catch (SQLException e) {
	 * System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage()); }
	 * 
	 * 
	 * return usuarioObject; }
	 */

	@Override
	public void update(Usuario entity) {
		// TODO Auto-generated method stub
		/*
		 * conexionUno.update("UPDATE Usuario SET cedula = '" + entity.getCedula()+
		 * "', nombre  = '" + entity.getNombres() +
		 * "'apellido ='"+entity.getApellidos()+ "'correo  ='"+entity.getCorreo()+
		 * "'contrasena ='"+entity.getPassword()+ "' WHERE cedula = " +
		 * entity.getCedula());
		 */
	}

	@Override
	public void delete(Usuario entity) {
		/*
		 * // TODO Auto-generated method stub
		 * conexionUno.update("DELETE FROM Usuario WHERE cedula = " +
		 * entity.getCedula());
		 */
	}

	@Override
	public List<Usuario> find() {
		// TODO Auto-generated method stub
		List<Usuario> list = new ArrayList<Usuario>();
		/*
		 * ResultSet rs = conexionUno.query("SELECT * FROM Usuario"); try { while
		 * (rs.next()) { list.add(new Usuario(rs.getString("cedula"),
		 * rs.getString("nombre"), rs.getString("apellido"),rs.getString("correo"),
		 * rs.getString("contrasena"))); }
		 * 
		 * } catch (SQLException e) {
		 * System.out.println(">>>WARNING (JDBCUsuarioDAO:find): " + e.getMessage()); }
		 * for(Usuario str : list) { System.out.println(str.getCedula() +','+
		 * str.getNombres() +','+str.getApellidos()+','+str.getCorreo()); }
		 */
		return list;
	}
	
	
	
}
