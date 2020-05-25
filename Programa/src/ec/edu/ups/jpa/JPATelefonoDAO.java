package ec.edu.ups.jpa;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidad.Telefono;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, String> implements TelefonoDAO{

	public JPATelefonoDAO() {
		super(Telefono.class);
		
	}
}
