package com.example.atletikstaevne_backend.repository;

import com.example.atletikstaevne_backend.entity.Contestant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestantRepo extends JpaRepository<Contestant, Integer> {
}
