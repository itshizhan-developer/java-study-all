package com.itshizhan.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itshizhan.beans.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

	MockMvc mockMvc;
	@Autowired
	WebApplicationContext wc;

	@Before
	public void setMockMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}

	@Test
	public void sayHello() throws Exception {
		MvcResult mvcResult = mockMvc.perform(
						MockMvcRequestBuilders
										.get("/hello")
										.contentType(MediaType.APPLICATION_FORM_URLENCODED)
										.param("name","itshizhan"))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andDo(MockMvcResultHandlers.print())
						.andReturn();

		System.out.println(mvcResult.getResponse().getContentAsString());
	}



	@Test
	public void addBook() throws Exception {
		ObjectMapper om = new ObjectMapper();
		Book book = new Book();
		book.setAuthor("罗贯中");
		book.setName("三国演义");
		book.setId(1);

		String s = om.writeValueAsString(book);
		System.out.println(s);
		MvcResult mvcResult = mockMvc.perform(
						MockMvcRequestBuilders
										.post("/book")
										.contentType(MediaType.APPLICATION_JSON)
										.content(s))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andDo(MockMvcResultHandlers.print())
						.andReturn();

		System.out.println(mvcResult);

	}
}