package ec.edu.ups.jpa;

import java.util.List;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidad.Telefono;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, String> implements TelefonoDAO{

	public JPATelefonoDAO() {
		super(Telefono.class);	
	}

	@Override
	public List<Telefono> buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
