package me.bigring.springboot;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class homeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	@WithMockUser
	public void hello() throws Exception{
		mockMvc.perform(get("/hello"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("hello"));
	}

	@Test
	public void hello_without_user() throws Exception{
		mockMvc.perform(get("/hello"))
			.andDo(print())
			.andExpect(status().isUnauthorized());
	}


	@Test
	@WithMockUser
	public void my() throws Exception{
		mockMvc.perform(get("/my"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("my"));
	}
}
