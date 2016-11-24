package com.example.eureka.client;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.eureka.client.controller.DemoController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaClientApplicationTests {

	private MockMvc mvc;

	@Before
	public void before() {
		this.mvc = MockMvcBuilders.standaloneSetup(new DemoController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		RequestBuilder requestBuilder = get("/hello/test");
		mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string("Hello! test"));
	}

}
