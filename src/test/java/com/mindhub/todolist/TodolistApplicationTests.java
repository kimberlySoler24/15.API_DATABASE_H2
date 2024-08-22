package com.mindhub.todolist;

import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.UserRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test") //activar perfil de prueba específico
@AutoConfigureMockMvc
class TodolistApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testUserRegistrationFlow() throws Exception{
		File fileRegister = ResourceUtils.getFile("classpath:registerUser.json");
		String registerUser = new String(Files.readAllBytes(fileRegister.toPath()));
		//Realizar una solicitud POST
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(registerUser))
				.andExpect(status().isOk());
		//verificación de guardado de usuario en base de datos
		UserEntity saveUserTest = userRepository.findByEmail("test@gmail.com").orElse(null);
		assertNotNull(saveUserTest);
		assertEquals("test", saveUserTest.getUsername());
		//intentar registrar el mismo usuario de nuevo
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(registerUser))
				.andExpect(status().isBadRequest());
		//probar el inicio de sesión del usuario registrado
		File fileLogin = ResourceUtils.getFile("classpath:loginUser.json");
		String loginUser = new String(Files.readAllBytes(fileLogin.toPath()));
		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login")
						.contentType(MediaType.APPLICATION_JSON)
						.content(loginUser))
				.andExpect(status().isOk());
	}
}
