package ec.edu.ups.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import javax.persistence.Query;

import ec.edu.ups.dao.GenericDAO;
import ec.edu.ups.entidad.Usuario;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	
	private Class<T> persistentClass;
	protected EntityManager em;
	
	
	
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}

	@Override
	public void create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
			
		}catch(Exception e) {
			System.out.println(">>> ERROR: JPAGENERICDAO: create " + e);
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
	}

	@Override
	public T read(ID id) {
		return em.find(persistentClass, id);
	}

	@Override
	public void update(T entity) {
		
		em.getTransaction().begin();
		try {
			em.merge(entity);
		}catch(Exception e) {
			System.out.println(">>> ERROR:JPAGENERICDAO:update "+e);
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
	}

	@Override
	public void delete(T entity) {
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(">>> ERROR:JPAGENERICDAO:delete "+e);
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
	}
	
	@Override
	public void deleteByID(ID id) {
		T entity = this.read(id);
		if(entity != null) {
			this.delete(entity);
		}
	}

	@SuppressWarnings({"rawtypes","unchecked"})
	@Override
	public List<T> find() {
		em.getTransaction().begin();
		List<T> lista = null;
		try {
			javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(persistentClass));
			lista = em.createQuery(cq).getResultList();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Usuario buscar(String email, String pwd) {
		
		Query nativeQuery = em.createNativeQuery("SELECT * FROM Usuario where correo =? AND pwd=?", Usuario.class);
		nativeQuery.setParameter(1, email);
		nativeQuery.setParameter(2, pwd);
		
		return (Usuario) nativeQuery.getSingleResult();
	}

	@Override
	public String cedula(String cdi) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
