package com.example.atletikstaevne_backend.controller;


import com.example.atletikstaevne_backend.entity.Contestant;
import com.example.atletikstaevne_backend.service.ContestantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contestant")
public class ContestantController {
    private final ContestantService contestantService;

    public ContestantController(ContestantService contestantService){
        this.contestantService = contestantService;
    }

    //Gets all contestants - Calls the getAllContestants method from the ContestantService class
    @GetMapping
    public ResponseEntity<List<Contestant>> getAllContestants(){
        try{
            return new ResponseEntity<>(contestantService.getAllContestants(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Gets a single contestant, by ID - Calls the getContestantById method from the ContestantService class
    @GetMapping("/{id}")
    public ResponseEntity<Contestant> getContestantById(@PathVariable int id){
        try{
            return new ResponseEntity<>(contestantService.getContestantById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Adds / Creates a new contestant - Calls the addContestant method from the ContestantService class
    @PostMapping
    public ResponseEntity<Contestant> addContestant(@RequestBody Contestant contestant){
        try{
            return new ResponseEntity<>(contestantService.addContestant(contestant), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Updates an already existing contestant - Calls the updateContestant method from the ContestantService class
    // NOTE: Might need to look at ResponseEntity return type
    @PutMapping("/{id}")
    public ResponseEntity updateContestant(@PathVariable int id, @RequestBody Contestant contestant){
        try{
            return new ResponseEntity<>(contestantService.updateContestant(id, contestant), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Deletes a contestant - Calls the deleteContestant method from the ContestantService class
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContestant(@PathVariable int id){
        try{
            return contestantService.deleteContestant(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
