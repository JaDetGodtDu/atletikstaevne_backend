package com.example.atletikstaevne_backend.service;

import  org.apache.commons.lang3.tuple.Pair ;
import com.example.atletikstaevne_backend.entity.Discipline;
import com.example.atletikstaevne_backend.entity.Result;
import com.example.atletikstaevne_backend.entity.Contestant;
import com.example.atletikstaevne_backend.repository.ContestantRepo;
import com.example.atletikstaevne_backend.repository.DisciplineRepo;
import com.example.atletikstaevne_backend.repository.ResultRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    final ResultRepo resultRepo;
    final ContestantRepo contestantRepo;
    final DisciplineRepo disciplineRepo;

    public ResultService(ResultRepo resultRepo, ContestantRepo contestantRepo, DisciplineRepo disciplineRepo) {
        this.resultRepo = resultRepo;
        this.contestantRepo = contestantRepo;
        this.disciplineRepo = disciplineRepo;
    }

    public List<Result> getAllResults() {
        return resultRepo.findAll();
    }

    public Result getResultById(int id) {
        return resultRepo.findById(id).orElse(null);
    }

    public Result addResult(Result result) {
        Pair<Contestant, Discipline> pair = checkContestantAndDiscipline(result);
        Contestant contestant = pair.getLeft();
        Discipline discipline = pair.getRight();

        result.setContestant(contestant);
        result.setDiscipline(discipline);

        return resultRepo.save(result);
    }

    private Pair<Contestant, Discipline> checkContestantAndDiscipline(Result result) {
        Contestant contestant = contestantRepo.findById(result.getContestant().getId())
                .orElseThrow(() -> new IllegalArgumentException("Contestant not found"));
        Discipline discipline = disciplineRepo.findById(result.getDiscipline().getId())
                .orElseThrow(() -> new IllegalArgumentException("Discipline not found"));

        if (contestant.getDisciplines() == null || !contestant.getDisciplines().contains(discipline)) {
            throw new IllegalArgumentException("Contestant does not participate in this discipline");
        }

        return Pair.of(contestant, discipline);
    }

    public Result updateResult(int id, Result result) {
        Result existingResult = resultRepo.findById(id).orElseThrow(() -> new RuntimeException("Result not found"));

        if (existingResult.getId() == id) {
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
