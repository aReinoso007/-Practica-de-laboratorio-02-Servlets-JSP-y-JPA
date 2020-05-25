package ec.edu.ups.test;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidad.Telefono;

public class TestTelefono {

	public static void main(String[] args) {
		
		TelefonoDAO telf = DAOFactory.getFactory().getTelefonoDAO();
		UsuarioDAO user = DAOFactory.getFactory().getUsuarioDAO();
		
		//Telefono t1 = new Telefono(1,"0998952718", "CNT", "Celular","1400919302");

	}

}
