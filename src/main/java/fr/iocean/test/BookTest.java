package fr.iocean.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import fr.iocean.model.Book;
import fr.iocean.service.BookService;

@Sql("classpath:test-book-data.sql")
public class BookTest extends IntegrationTest {

	@Autowired
	BookService bookService;

	@Test
	// @WithMockUser(authorities = "TEST")
	public void testCreate() throws Exception {
		Book u = new Book();
		u.setId(3);
		u.setTitle("test");
		u.setAuthor("test");
		u.setNbrPages(125);

		this.mockMvc.perform(post("/bookscontroller").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
				.content(jsonHelper.serialize(u))).andExpect(status().isOk());
		this.mockMvc.perform(get("/bookscontroller")).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$", hasSize(3))).andExpect(status().isOk());

	}

	@Test
	// @WithMockUser
	public void testCreatePreconditionFail() throws Exception {
		Book b = new Book();
		b.setId(4);
		b.setAuthor("");
		b.setTitle("");
		b.setNbrPages(150);

		this.mockMvc
				.perform(post("/bookscontroller").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
						.content(jsonHelper.serialize(b)))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isBadRequest());
	}

	@Test
	// @WithMockUser
	public void testUpdate() throws Exception {
		Book book = bookService.get(1);
		Assert.assertEquals("Le lion", book.getTitle());

		book.setTitle("Pierre");
		this.mockMvc
				.perform(put("/bookscontroller/{id}", 1).contentType(MediaType.APPLICATION_JSON)
						.characterEncoding("UTF-8").content(jsonHelper.serialize(book))).andExpect(status().isOk());

		this.mockMvc.perform(get("/bookscontroller/{id}", 1)).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.title").value("Pierre")).andExpect(status().isOk());
	}

	@Test
	// @WithMockUser(authorities = "TEST")
	public void testGetBook() throws Exception {
		this.mockMvc.perform(get("/bookscontroller/{id}", 1)).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.title").value("Le lion"))
				.andExpect(status().isOk());
	}

	@Test
	// @WithMockUser(authorities = "TEST")
	public void testGetNotFoundUser() throws Exception {
		this.mockMvc.perform(get("/bookscontroller/{id}", 55)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isNotFound());
	}

	@Test
	// @WithMockUser(authorities = "TEST")
	public void testGetAllBooks() throws Exception {
		this.mockMvc.perform(get("/bookscontroller")).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$", hasSize(2))).andExpect(status().isOk());
	}
}
