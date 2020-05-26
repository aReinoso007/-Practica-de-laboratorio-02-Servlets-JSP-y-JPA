package ec.edu.ups.test;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Usuario;

public class TestUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioDAO user = DAOFactory.getFactory().getUsuarioDAO();
		
		Usuario u3 = new Usuario("1400919302", "Alex", "Reinoso", "ralexjessiel@gmail.com", "123");
		Usuario u2 = new Usuario("1500297716", "Sharon", "Reinoso", "sr@gmail.com", "123");
		
		//user.create(u2);
		//user.create(u3);
		//System.out.println("Usuario Creado");
		
		//Comprobar que funciona funcion login
		//System.out.println(user.buscar("ralexjessiel@gmail.com", "123"));
		
		//TelefonoDAO telf = DAOFactory.getFactory().getTelefonoDAO();
		
		System.out.println(user.findAll());
		//Usuario u1 = new Usuario();
		//u1 = user.read("1400919302");
		//System.out.println(u1);
		//Telefono t1 = new Telefono("0998952718", "CNT", "Celular", u1);
		
		//telf.create(t1);
		//System.out.println("Telef creado");
		
		//System.out.println(telf.buscarCedula("1400919302"));
		//System.out.println(telf.find());
		//System.out.println(user.read("1400919302"));
		
		
	}

}
