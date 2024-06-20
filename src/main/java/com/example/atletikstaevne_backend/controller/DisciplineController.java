package com.example.atletikstaevne_backend.controller;

import com.example.atletikstaevne_backend.entity.Discipline;
import com.example.atletikstaevne_backend.service.DisciplineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService){
        this.disciplineService = disciplineService;
    }

    //Gets all disciplines - Calls the getAllDisciplines method from the DisciplineService class
    @GetMapping
    public ResponseEntity<List<Discipline>> getAllDisciplines(){
        try{
            return new ResponseEntity<>(disciplineService.getAllDisciplines(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Gets a single discipline, by ID - Calls the getDisciplineById method from
    @GetMapping("/{id}")
    public ResponseEntity<Discipline> getDisciplineById(@PathVariable int id){
        try{
            return new ResponseEntity<>(disciplineService.getDisciplineById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Adds / Creates a new discipline - Calls the addDiscipline method from the DisciplineService class
    @PostMapping
    public ResponseEntity<Discipline> addDiscipline(@RequestBody Discipline discipline){
        try{
            return new ResponseEntity<>(disciplineService.addDiscipline(discipline), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Updates an already existing discipline - Calls the updateDiscipline method from the DisciplineService class
    @PutMapping("/{id}")
    public ResponseEntity<Discipline> updateDiscipline(@PathVariable int id, @RequestBody Discipline discipline){
        try{
            Discipline updatedDiscipline = disciplineService.updateDiscipline(id, discipline);
            return new ResponseEntity<>(updatedDiscipline, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Deletes a discipline - Calls the deleteDiscipline method from the DisciplineService class
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDiscipline(@PathVariable int id){
        try{
            disciplineService.deleteDiscipline(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
