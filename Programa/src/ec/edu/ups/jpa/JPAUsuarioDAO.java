package ec.edu.ups.jpa;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.*;


public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{
	
	//private Class<T> persistentClass;

	
	
	
	public JPAUsuarioDAO() {
		super(Usuario.class);
		
	}
	
	
	
	
}
