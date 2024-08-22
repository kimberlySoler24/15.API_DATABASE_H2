package com.mindhub.todolist;

import com.mindhub.todolist.configuration.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test") //activar perfil de prueba específico
@AutoConfigureMockMvc
public class UserGetControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private WebApplicationContext context;

    private String jwtToken;

    @Test
    public void testGetUser() throws Exception{
        jwtToken = jwtUtils.generateClaims("test@gmail.com");
        System.out.println(jwtToken);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/getUser/1")
                        .header("Authorization", "Bearer " + jwtToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("prueba"));
    }

    @Test
    public void testGetUserEndpointWithoutAuth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/getUser/15"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testGetUserEndpointWithInvalidJWT() throws Exception {
        String invalidToken = "invalidtoken123";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/admin/getUser/15")
                        .header("Authorization", "Bearer " + invalidToken))
                .andExpect(status().isForbidden());
    }
}
