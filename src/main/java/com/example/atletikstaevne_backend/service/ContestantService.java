package com.example.atletikstaevne_backend.service;

import com.example.atletikstaevne_backend.entity.Discipline;
import com.example.atletikstaevne_backend.repository.ContestantRepo;
import com.example.atletikstaevne_backend.entity.Contestant;

import com.example.atletikstaevne_backend.repository.DisciplineRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContestantService {
    final ContestantRepo contestantRepo;
    final DisciplineRepo disciplineRepo;

    public ContestantService(ContestantRepo contestantRepo, DisciplineRepo disciplineRepo){
        this.contestantRepo = contestantRepo;
        this.disciplineRepo = disciplineRepo;
    }

    public List<Contestant> getAllContestants(){
        return contestantRepo.findAll();
    }

    public Contestant getContestantById(int id){
        return contestantRepo.findById(id).orElse(null);
    }

    public Contestant addContestant(Contestant contestant){
        List<Discipline> fetchedDisciplines = new ArrayList<>();

        for (Discipline discipline : contestant.getDisciplines()) {
            Discipline fetchedDiscipline = disciplineRepo.findById(discipline.getId())
                    .orElseThrow(()->new RuntimeException("Discipline with id: " + discipline.getId() + " not found"));

            fetchedDisciplines.add(fetchedDiscipline);
        }

        contestant.setDisciplines(fetchedDisciplines);
        return contestantRepo.save(contestant);
    }

    public Contestant updateContestant(int id, Contestant contestant){
        Contestant existingContestant = contestantRepo.findById(id).orElseThrow(()->new RuntimeException("Contestant not found"));

        if(existingContestant.getId()==id){
            existingContestant.setName(contestant.getName());
            existingContestant.setAge(contestant.getAge());
            existingContestant.setClub(contestant.getClub());
            existingContestant.setSex(contestant.getSex());

            List<Discipline> updatedDisciplines = disciplineRepo.findAllById(
                    contestant.getDisciplines().stream().map(Discipline::getId).toList() //Get ID for each discipline in the list
            );

            existingContestant.setDisciplines(updatedDisciplines);

            return contestantRepo.save(existingContestant);
        } else {
            throw new RuntimeException("Error while updating contestant with id: " + id);
        }
    }

    public ResponseEntity<String> deleteContestant(int id){
        Optional<Contestant> contestantToDelete = contestantRepo.findById(id);
        if(contestantToDelete.isPresent()){
            contestantRepo.deleteById(id);
            return ResponseEntity.ok("Contestant with id: " + id + " was succesfully deleted!");
        } else {
            return ResponseEntity.status(404).body("Contestant with id: " + id + " not found");
        }
    }

}
