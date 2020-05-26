package ec.edu.ups.test;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Telefono;
import ec.edu.ups.entidad.Usuario;

public class TestTelefono {

	public static void main(String[] args) {
		
		TelefonoDAO telf = DAOFactory.getFactory().getTelefonoDAO();
		UsuarioDAO user = DAOFactory.getFactory().getUsuarioDAO();
		/*
		user.find();
		Usuario u1 = new Usuario();
		u1 = user.read("1500287716");
		System.out.println(u1);
		Telefono t1 = new Telefono("0983316186", "CNT", "Celular", u1);
		
		telf.create(t1);
		System.out.println("Telef creado");
		*/
		//System.out.println(telf.buscarCedula("1500287716"));
		System.out.println(telf.findAll());

	}

}
