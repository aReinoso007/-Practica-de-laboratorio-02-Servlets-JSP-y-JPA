package ec.edu.ups.dao;

import java.util.List;

//import java.util.List;

import ec.edu.ups.entidad.Telefono;

public interface TelefonoDAO  extends GenericDAO<Telefono, String> {

	//List<Contacto> buscarCorreo(String correo);
	List<Telefono> buscarCedula(String cedula);
	public List<Telefono> buscarCedInv(String cedula);
	//List<Contacto> obtenerContacto();

	//List<Contacto> buscarCedInv(String cedula);
	//void eliminar2(String tel_id);
		
}
