package com.example.atletikstaevne_backend.controller;

import com.example.atletikstaevne_backend.entity.Contestant;
import com.example.atletikstaevne_backend.service.ContestantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:mysql://localhost:3306/testdb",
        "spring.datasource.username=root",
        "spring.datasource.password=Anga0001kea",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class ContestantControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContestantService contestantService;

    @Test
    public void getAllContestants() throws Exception {
        Contestant contestant = new Contestant();
        // set properties for the contestant

        List<Contestant> allContestants = Arrays.asList(contestant);

        given(contestantService.getAllContestants()).willReturn(allContestants);

        mockMvc.perform(get("/contestant")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    // Write similar tests for other endpoints
}
