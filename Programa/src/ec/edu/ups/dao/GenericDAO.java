package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidad.Telefono;
import ec.edu.ups.entidad.Usuario;

public interface GenericDAO<T, ID> {
	
	public void create(T entity);
	
	public T read(ID id);
	
	public void update(T entity);
	public void delete(T entity);
	public List<T> find();
	public void deleteByID(ID id);
	
	Usuario buscar(String email, String pwd);
	
	public List<Telefono> buscarCedula(String cedula);
	public List<Telefono> buscarCedInv(String cedula);
	public List<Telefono> buscarCorreo(String correo); 
	
	List<T> findAll();
	
	
}
