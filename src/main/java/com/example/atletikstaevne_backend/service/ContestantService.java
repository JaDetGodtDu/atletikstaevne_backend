package com.example.atletikstaevne_backend.service;

import com.example.atletikstaevne_backend.repository.ContestantRepo;
import com.example.atletikstaevne_backend.entity.Contestant;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContestantService {
    final ContestantRepo contestantRepo;

    public ContestantService(ContestantRepo contestantRepo){
        this.contestantRepo = contestantRepo;
    }

    //Gets all contestants
    public List<Contestant> getAllContestants(){
        return contestantRepo.findAll();
    }

    //Gets a single contestant, by ID
    public Contestant getContestantById(int id){
        return contestantRepo.findById(id).orElse(null);
    }

    //Adds / Creates a new contestant
    public Contestant addContestant(Contestant contestant){
        return contestantRepo.save(contestant);
    }

    //Updates an already existing contestant
    public Contestant updateContestant(int id, Contestant contestant){
        Contestant existingContestant = contestantRepo.findById(id).orElseThrow(()->new RuntimeException("Contestant not found"));

        if(contestant.getId()==id){
            existingContestant.setName(contestant.getName());
            existingContestant.setAge(contestant.getAge());
            existingContestant.setClub(contestant.getClub());
            existingContestant.setSex(contestant.getSex());

            return contestantRepo.save(existingContestant);
        } else {
            throw new RuntimeException("Error while updating contestant with id: " + id);
        }
    }

    //Deletes a contestant
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
