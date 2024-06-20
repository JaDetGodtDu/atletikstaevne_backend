package com.example.atletikstaevne_backend.repository;

import com.example.atletikstaevne_backend.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepo extends JpaRepository<Discipline, Integer> {
}
