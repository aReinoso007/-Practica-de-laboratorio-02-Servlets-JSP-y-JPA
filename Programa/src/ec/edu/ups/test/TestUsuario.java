package ec.edu.ups.test;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Usuario;

public class TestUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioDAO user = DAOFactory.getFactory().getUsuarioDAO();
		
		Usuario u3 = new Usuario("1400919220", "Alex", "Gonzalez", "agonza@gmail.com", "123");
		//Usuario u2 = new Usuario("1400919312", "Jess", "Reino", "jess@gmail.com", "123");
		
		//user.create(u1);
		user.create(u3);
		//System.out.println("Usuario Creado");
		
	
		System.out.println(user.read("1400919302"));
		
	}

}
