package fr.iocean.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iocean.model.Book;
import fr.iocean.repository.BookDAO;

@Service
public class BookService {
	
	@Autowired
	BookDAO bookDAO;
	
	@Transactional
	public void persist(Object entity) {
		bookDAO.persist(entity);
	}
	
	@Transactional
	public void delete(Object entity) {
		bookDAO.delete(entity);
	}
	
	@Transactional
	public void add(Object entity) {
		bookDAO.add(entity);
	}
	
	@Transactional
	public void update(Object entity) {
		bookDAO.update(entity);
	}
	
	@Transactional
	public List<Book> getAll() {
		return bookDAO.getAll();
	}
	
	@Transactional
	public Book get(int id) {
		return bookDAO.get(id);
	}
}
