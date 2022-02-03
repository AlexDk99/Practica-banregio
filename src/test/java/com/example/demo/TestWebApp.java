package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestWebApp extends DemoApplicationTests{
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testCategorias() throws Exception {
		mockMvc.perform(get("/test/categorias")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void testProductos() throws Exception {
		mockMvc.perform(get("/test/productos")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void testPostCategorias() throws Exception {
		mockMvc.perform(post("/test/categorias")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	public void testPostPrroductos() throws Exception{
		mockMvc.perform(post("/test/productos")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	public void testPutProductos() throws Exception{
		mockMvc.perform(put("/test/productos")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	public void testPutCategorias() throws Exception{
		mockMvc.perform(put("/test/categorias")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	public void testPatchCategorias() throws Exception{
		mockMvc.perform(patch("/test/categorias")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	public void testDeleteCategorias() throws Exception{
		mockMvc.perform(delete("/test/categorias")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
}
