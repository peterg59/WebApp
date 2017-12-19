package fr.iocean.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import fr.iocean.App;
import fr.iocean.JsonHelper;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = App.class)
@TestPropertySource("classpath:application-test.properties")
@Transactional
public abstract class IntegrationTest {
	
	@Autowired
	protected WebApplicationContext wac;

	@Autowired
	protected JsonHelper jsonHelper;

	protected MockMvc mockMvc;

	@Before
	public void initMockMcv() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(wac)
			//	.apply(SecurityMockMvcConfigurers.springSecurity())
				.build();
	}
}
