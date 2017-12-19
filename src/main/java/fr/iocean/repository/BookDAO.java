package fr.iocean.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.iocean.model.Book;

@Repository
public class BookDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	protected Session getSession() {
		return em.unwrap(Session.class);
	}
	
	@Transactional
	public void persist(Object entity) {
		em.persist(entity);
	}
	
	@Transactional
	public void delete(Object entity) {
		try {
			em.remove(em.contains(entity) ? entity : em.merge(entity));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional
	public void add(Object entity) {
		try {
			em.persist(entity);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional
	public void update(Object entity) {
		em.merge(entity);
	}
	
	@Transactional
	public List<Book> getAll() {
		return em.createQuery("select b from Book b",Book.class).getResultList();
	}
	
	@Transactional
	public Book get(int id) {
		return em.find(Book.class, id);
	}
}
