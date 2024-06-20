package com.example.atletikstaevne_backend.controller;


import com.example.atletikstaevne_backend.entity.Result;
import com.example.atletikstaevne_backend.service.ResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService){
        this.resultService = resultService;
    }

    //Gets all results - Calls the getAllResults method from the ResultService class
    @GetMapping
    public ResponseEntity<List<Result>> getAllResults(){
        try{
            return new ResponseEntity<>(resultService.getAllResults(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Gets a single result, by ID - Calls the getResultById method from the ResultService class
    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable int id){
        try{
            return new ResponseEntity<>(resultService.getResultById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Adds / Creates a new result - Calls the addResult method from the ResultService class
    @PostMapping
    public ResponseEntity<Result> addResult(@RequestBody Result result){
        try{
            return new ResponseEntity<>(resultService.addResult(result), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Updates an already existing result - Calls the updateResult method from the ResultService class
    @PutMapping("/{id}")
    public ResponseEntity updateResult(@PathVariable int id, @RequestBody Result result){
        try{
            return new ResponseEntity<>(resultService.updateResult(id, result), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Deletes a result - Calls the deleteResult method from the ResultService class
    @DeleteMapping("/{id}")
    public ResponseEntity deleteResult(@PathVariable int id){
        try{
            resultService.deleteResult(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Gets all results from a certain discipline - Calls the getResultsByDiscipline method from the ResultService class
    @GetMapping("/discipline/{id}")
    public ResponseEntity<List<Result>> getResultsByDiscipline(@PathVariable int id){
        try{
            return new ResponseEntity<>(resultService.getResultsByDiscipline(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Gets all results from a certain contestant - Calls the getResultsByContestant method from the ResultService class
    @GetMapping("/contestant/{id}")
    public ResponseEntity<List<Result>> getResultsByContestant(@PathVariable int id){
        try{
            return new ResponseEntity<>(resultService.getResultsByContestant(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
