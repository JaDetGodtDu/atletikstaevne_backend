package com.example.atletikstaevne_backend.controller;

import com.example.atletikstaevne_backend.entity.Contestant;
import com.example.atletikstaevne_backend.entity.Discipline;
import com.example.atletikstaevne_backend.service.DisciplineService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        discipline1.setName("100-meterløb");
        discipline1.setResultType("Tid");

        Discipline discipline2 = new Discipline();
        discipline2.setId(2);
        discipline2.setName("Diskoskast");
        discipline2.setResultType("Afstand");

        given(disciplineService.getAllDisciplines()).willReturn(Arrays.asList(discipline1, discipline2));

        mockMvc.perform(get("/discipline")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("100-meterløb"))
                .andExpect(jsonPath("$[0].resultType").value("Tid"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Diskoskast"))
                .andExpect(jsonPath("$[1].resultType").value("Afstand"));

    }

    @Test
    public void getDisciplineById() throws Exception {
        Discipline discipline = new Discipline();
        discipline.setId(1);
        discipline.setName("100-meterløb");
        discipline.setResultType("Tid");

        given(disciplineService.getDisciplineById(1)).willReturn(discipline);

        mockMvc.perform(get("/discipline/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("100-meterløb"))
                .andExpect(jsonPath("$.resultType").value("Tid"));
    }

    @Test
    public void addDiscipline() throws Exception {
        Discipline discipline = new Discipline();

        discipline.setId(1);
        discipline.setName("100-meterløb");
        discipline.setResultType("Tid");

        given(disciplineService.addDiscipline(any(Discipline.class))).willReturn(discipline);

        mockMvc.perform(post("/discipline")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(discipline)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("100-meterløb"))
                .andExpect(jsonPath("$.resultType").value("Tid"));
    }

    @Test
    public void addDisciplineToContestant() throws Exception {
        Discipline discipline = new Discipline();

        discipline.setId(1);
        discipline.setName("100-meterløb");
        discipline.setResultType("Tid");

        Contestant contestant = new Contestant();

        contestant.setId(1);
        contestant.setName("John Dådyr");
        contestant.setAge(25);
        contestant.setClub("Klub A");
        contestant.setSex("M");
    }
    @Test
    public void updateDiscipline() throws Exception {
        Discipline discipline = new Discipline();

        discipline.setId(1);
        discipline.setName("100-meterløb");
        discipline.setResultType("Tid");

        given(disciplineService.updateDiscipline(eq(1), any(Discipline.class))).willReturn(discipline);

        mockMvc.perform(put("/discipline/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(discipline)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("100-meterløb"))
                .andExpect(jsonPath("$.resultType").value("Tid"));
    }
    @Test
    public void deleteDiscipline() throws Exception {
        doNothing().when(disciplineService).deleteDiscipline(1);

        mockMvc.perform(delete("/discipline/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
