package com.example.atletikstaevne_backend.controller;

import com.example.atletikstaevne_backend.entity.Contestant;
import com.example.atletikstaevne_backend.entity.Discipline;
import com.example.atletikstaevne_backend.service.ContestantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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

        contestant.setId(1);
        contestant.setName("John Dådyr");
        contestant.setAge(25);
        contestant.setClub("Klub A");
        contestant.setSex("M");

        Discipline discipline1 = new Discipline();
        discipline1.setId(1);
        discipline1.setName("100-meterløb");
        discipline1.setResultType("Tid");

        Discipline discipline2 = new Discipline();
        discipline2.setId(2);
        discipline2.setName("Diskoskast");
        discipline2.setResultType("Afstand");

        List<Discipline> disciplines = Arrays.asList(discipline1, discipline2);

        contestant.setDisciplines(disciplines);

        List<Contestant> allContestants = Arrays.asList(contestant);

        given(contestantService.getAllContestants()).willReturn(allContestants);

        mockMvc.perform(get("/contestant")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
    @Test
    public void getContestantById() throws Exception {
        Contestant contestant = new Contestant();

        contestant.setId(1);
        contestant.setName("John Dådyr");
        contestant.setAge(25);
        contestant.setClub("Klub A");
        contestant.setSex("M");

        Discipline discipline1 = new Discipline();
        discipline1.setId(1);
        discipline1.setName("100-meterløb");
        discipline1.setResultType("Tid");

        Discipline discipline2 = new Discipline();
        discipline2.setId(2);
        discipline2.setName("Diskoskast");
        discipline2.setResultType("Afstand");

        List<Discipline> disciplines = Arrays.asList(discipline1, discipline2);
        contestant.setDisciplines(disciplines);

        given(contestantService.getContestantById(1)).willReturn(contestant);

        mockMvc.perform(get("/contestant/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1))); // assuming your Contestant has an 'id' property
    }
    @Test
    public void addContestant() throws Exception {
        Contestant contestant = new Contestant();

        contestant.setId(1);
        contestant.setName("John Dådyr");
        contestant.setAge(25);
        contestant.setClub("Klub A");
        contestant.setSex("M");

        Discipline discipline1 = new Discipline();
        discipline1.setId(1);
        discipline1.setName("100-meterløb");
        discipline1.setResultType("Tid");

        Discipline discipline2 = new Discipline();
        discipline2.setId(2);
        discipline2.setName("Diskoskast");
        discipline2.setResultType("Afstand");

        List<Discipline> disciplines = Arrays.asList(discipline1, discipline2);
        contestant.setDisciplines(disciplines);

        given(contestantService.addContestant(any(Contestant.class))).willReturn(contestant);

        mockMvc.perform(post("/contestant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(contestant)))
                .andExpect(status().isCreated());
    }
    @Test
    public void updateContestant() throws Exception {
        Contestant contestant = new Contestant();

        contestant.setId(1);
        contestant.setName("John Dådyr");
        contestant.setAge(25);
        contestant.setClub("Klub A");
        contestant.setSex("M");

        Discipline discipline1 = new Discipline();
        discipline1.setId(1);
        discipline1.setName("100-meterløb");
        discipline1.setResultType("Tid");

        Discipline discipline2 = new Discipline();
        discipline2.setId(2);
        discipline2.setName("Diskoskast");
        discipline2.setResultType("Afstand");

        List<Discipline> disciplines = Arrays.asList(discipline1, discipline2);
        contestant.setDisciplines(disciplines);

        given(contestantService.updateContestant(eq(1), any(Contestant.class))).willReturn(contestant);

        mockMvc.perform(put("/contestant/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(contestant)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteContestant() throws Exception {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Contestant deleted successfully", HttpStatus.OK);
        when(contestantService.deleteContestant(1)).thenReturn(responseEntity);

        mockMvc.perform(delete("/contestant/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
