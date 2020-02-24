package com.eussi.springbootdemo;

import com.eussi.springbootdemo.web.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootDemoApplication.class)
@WebAppConfiguration
public class SpringbootDemoApplicationTests {

    private MockMvc mvc;

@Before
public void setUp() throws Exception {
    mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
}

	@Test
	public void hello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
	}

}
