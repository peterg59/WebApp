package fr.iocean.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import fr.iocean.validator.Isbn;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	private Integer id;
	
	@Column(name = "nb_pages")
	private Integer nbrPages;
	
	@Column(name = "publication_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@NotBlank
	private String title, author;

	public Book() {
	}

	public Book(int id, String title, String author, int nbrPages) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.nbrPages = nbrPages;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Integer getNbrPages() {
		return nbrPages;
	}
	
	public void setNbrPages(Integer nbrPages) {
		this.nbrPages = nbrPages;
	}
	
	@Override
	public String toString() {
		return "{id: " + getId()+ ", title:" + getTitle() + ", author:" + getAuthor() + " }";
	}

}
