package fr.iocean.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.iocean.model.Book;
import fr.iocean.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/bookscontroller/{id}", method = RequestMethod.GET)
	public Book getBook(@PathVariable("id") int idBook) {
		Book book = bookService.get(idBook);
		return book;
	}
	
	@RequestMapping(value = "/bookscontroller", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAll() {
		return bookService.getAll();
	}
	
	@RequestMapping(value = "/bookscontroller", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createBook(@RequestBody Book book) {
		bookService.add(book);
	}

	@RequestMapping(value = "/bookscontroller/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int updateBook(@PathVariable("id") int idBook) {
		Book book = bookService.get(idBook);
		book.setTitle("Pierre");
		bookService.update(book);
		return book.getId();
	}

	@RequestMapping(value = "/bookscontroller/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteBook(@PathVariable("id") int idBook) {
		Book book = bookService.get(idBook);
		bookService.delete(book);
	}
}
