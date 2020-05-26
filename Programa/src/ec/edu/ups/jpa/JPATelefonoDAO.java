package ec.edu.ups.jpa;

import java.util.List;

import javax.persistence.Persistence;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidad.Telefono;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, String> implements TelefonoDAO{

	public JPATelefonoDAO() {
		super(Telefono.class);	
		this.em = Persistence.createEntityManagerFactory("Practica2").createEntityManager();
	}


	
	
}
