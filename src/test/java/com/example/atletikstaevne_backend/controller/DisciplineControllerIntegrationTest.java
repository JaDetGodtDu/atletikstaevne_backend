package com.example.atletikstaevne_backend.controller;

import com.example.atletikstaevne_backend.entity.Contestant;
import com.example.atletikstaevne_backend.entity.Discipline;
import com.example.atletikstaevne_backend.service.ContestantService;
import com.example.atletikstaevne_backend.service.DisciplineService;
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

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:mysql://localhost:3306/testdb",
        "spring.datasource.username=root",
        "spring.datasource.password=Anga0001kea",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class DisciplineControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DisciplineService disciplineService;

    @Test
    public void getAllDisciplines() throws Exception {
        Discipline discipline1 = new Discipline();
        discipline1.setId(1);
        discipline1.setName("100m Sprint");
        discipline1.setResultType("Time");

        Discipline discipline2 = new Discipline();
        discipline2.setId(2);
        discipline2.setName("Long Jump");
        discipline2.setResultType("Distance");

        given(disciplineService.getAllDisciplines()).willReturn(Arrays.asList(discipline1, discipline2));

        mockMvc.perform(get("/discipline")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("100m Sprint"))
                .andExpect(jsonPath("$[0].resultType").value("Time"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Long Jump"))
                .andExpect(jsonPath("$[1].resultType").value("Distance"));

    }
}
