//package fr.iocean.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.http.MediaType;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import fr.iocean.model.Book;
//
//import org.springframework.ui.Model;
//
//@RestController
//public class LibraryController {
//
//	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
//	public Book getBook(@PathVariable("id") int idBook) {
//		Library lib = Library.getInstance();
//		Book book = lib.get(idBook);
//		return book;
//	}
//
//	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Book> getAll() {
//		Library lib = Library.getInstance();
//		return lib.getAll();
//	}
//
//	@RequestMapping(value = "/books", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public int createBook(@RequestBody @Valid Book book) {
//
//		Library lib = Library.getInstance();
//		lib.add(book);
//
//		return book.getId();
//	}
//
//	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public int updateBook(@PathVariable("id") int idBook) {
//		Library lib = Library.getInstance();
//		Book book = lib.get(idBook);
//		book.setTitle("Pierre");
//		lib.update(book);
//		return book.getId();
//	}
//
//	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void deleteBook(@PathVariable("id") int idBook) {
//		Library lib = Library.getInstance();
//		Book book = lib.get(idBook);
//		lib.delete(book);
//	}
//
//}
