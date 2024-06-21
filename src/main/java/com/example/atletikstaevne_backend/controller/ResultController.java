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

    @GetMapping
    public ResponseEntity<List<Result>> getAllResults(){
        try{
            return new ResponseEntity<>(resultService.getAllResults(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable int id){
        try{
            return new ResponseEntity<>(resultService.getResultById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Result> addResult(@RequestBody Result result){
        try{
            return new ResponseEntity<>(resultService.addResult(result), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateResult(@PathVariable int id, @RequestBody Result result){
        try{
            return new ResponseEntity<>(resultService.updateResult(id, result), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteResult(@PathVariable int id){
        try{
            resultService.deleteResult(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/discipline/{id}")
    public ResponseEntity<List<Result>> getResultsByDiscipline(@PathVariable int id){
        try{
            return new ResponseEntity<>(resultService.getResultsByDiscipline(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contestant/{id}")
    public ResponseEntity<List<Result>> getResultsByContestant(@PathVariable int id){
        try{
            return new ResponseEntity<>(resultService.getResultsByContestant(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
