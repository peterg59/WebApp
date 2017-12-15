package fr.iocean;

import java.util.*;

public class Library {

	private static List<Book> books;
	private static Library library = new Library();

	private Library() {
		books = new ArrayList<>();
		Book book1 = new Book(1,"tit", "pat", "fjhgbserugbzreuyghzerguioyhze");
		Book book2 = new Book(2,"tot", "rgeruhg", "ergiouehuioghzeiughz");
		books.add(book1);
		books.add(book2);
	}

	public static Library getInstance() {
		return library;
	}

	public List<Book> getAll() {
		return books;
	}

	public void delete(Book book) {
		books.remove(book);
	}

	public void update(Book book) {
		int idx = books.indexOf(book);
		if (idx >= 0) {
			books.set(idx, book);
		} else {
			throw new NullPointerException("Book is not in the list");
		}
	}

	public void add(Book book) {
		books.add(book);
	}

	public Book get(int id) {
		for(Book b : books) {
			if(b.getId() == id) {
				return b;
			}
		}
		return null;
	}
}
