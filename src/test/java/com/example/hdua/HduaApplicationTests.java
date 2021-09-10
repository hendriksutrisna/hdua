package com.example.hdua;

import com.example.hdua.models.Student;
import com.example.hdua.repositories.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/data.sql")
public class HduaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveTest() throws Exception {
		Student student = new Student();
		student.setName("George");
		student.setAddress("Lavender Street");

		this.mockMvc
				.perform(post("/student")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(student))
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("George"))
				.andExpect(jsonPath("$.address").value("Lavender Street"))
				.andExpect(jsonPath("$.id").isNotEmpty())
				.andReturn();
	}

	@Test
	public void findByNameTest() throws Exception {
//		Student student = new Student();
//		student.setName("Bambang");
//		student.setAddress("Jakarta");

//		studentRepository.save(student);

		this.mockMvc
				.perform(get("/student")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.param("name", "Bambang")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Bambang"))
				.andExpect(jsonPath("$.address").value("Jakarta"))
				.andReturn();
	}

	@Test
	public void deleteTest() throws Exception {
		Student student = new Student();
		student.setName("George");
		student.setAddress("Lavender Street");

		studentRepository.save(student);

		String tempId = studentRepository.findAll().get(0).getId();

		this.mockMvc
				.perform(delete("/student")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.param("id", tempId)
				)
				.andExpect(status().isOk())
				.andReturn();
	}
}
