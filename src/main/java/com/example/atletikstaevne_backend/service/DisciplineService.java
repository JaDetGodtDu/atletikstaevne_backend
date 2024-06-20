package com.example.atletikstaevne_backend.service;

import com.example.atletikstaevne_backend.entity.Discipline;
import com.example.atletikstaevne_backend.repository.DisciplineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {
    final DisciplineRepo disciplineRepo;

    public DisciplineService(DisciplineRepo disciplineRepo) {
        this.disciplineRepo = disciplineRepo;
    }

    public List<Discipline> getAllDisciplines() {
        return disciplineRepo.findAll();
    }

    public Discipline getDisciplineById(int id) {
        return disciplineRepo.findById(id).orElse(null);
    }

    public Discipline addDiscipline(Discipline discipline) {
        return disciplineRepo.save(discipline);
    }

    public Discipline updateDiscipline(int id, Discipline discipline) {
        Discipline existingDiscipline = disciplineRepo.findById(id).orElseThrow(() -> new RuntimeException("Discipline not found"));

        if (discipline.getId() == id) {
            existingDiscipline.setName(discipline.getName());
            existingDiscipline.setResultType(discipline.getResultType());

            return disciplineRepo.save(existingDiscipline);
        } else {
            throw new RuntimeException("Error while updating discipline with id: " + id);
        }
    }

    public void deleteDiscipline(int id) {
        disciplineRepo.deleteById(id);
    }

    //Utility method to get resultType from a discipline
    public String getResultType(int id) {
        Discipline discipline = disciplineRepo.findById(id).orElseThrow(() -> new RuntimeException("Discipline not found"));
        return discipline.getResultType();
    }
}
