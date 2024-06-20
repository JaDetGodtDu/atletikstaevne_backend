package com.example.atletikstaevne_backend.service;

import com.example.atletikstaevne_backend.entity.Result;
import com.example.atletikstaevne_backend.repository.ResultRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    final ResultRepo resultRepo;

    public ResultService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public List<Result> getAllResults() {
        return resultRepo.findAll();
    }

    public Result getResultById(int id) {
        return resultRepo.findById(id).orElse(null);
    }

    public Result addResult(Result result) {
        return resultRepo.save(result);
    }

    public Result updateResult(int id, Result result) {
        Result existingResult = resultRepo.findById(id).orElseThrow(() -> new RuntimeException("Result not found"));

        if (result.getId() == id) {
            existingResult.setDate(result.getDate());
            existingResult.setResultValue(result.getResultValue());
            existingResult.setContestant(result.getContestant());
            existingResult.setDiscipline(result.getDiscipline());

            return resultRepo.save(existingResult);
        } else {
            throw new RuntimeException("Error while updating result with id: " + id);
        }
    }

    public void deleteResult(int id) {
        resultRepo.deleteById(id);
    }

    // Gets all results from a certain discipline
    public List<Result> getResultsByDiscipline(int id){
       List<Result> filteredResults = resultRepo.findAll();

         for(Result result : filteredResults){
              if(result.getDiscipline().getId() != id){
                filteredResults.remove(result);
              }
         }

         return filteredResults;
    }

    // Gets all results from a certain contestant
    public List<Result> getResultsByContestant(int id){
       List<Result> filteredResults = resultRepo.findAll();

         for(Result result : filteredResults){
              if(result.getContestant().getId() != id){
                filteredResults.remove(result);
              }
         }

         return filteredResults;
    }

}
