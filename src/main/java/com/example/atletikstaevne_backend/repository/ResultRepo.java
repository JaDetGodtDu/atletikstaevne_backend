package com.example.atletikstaevne_backend.repository;

import com.example.atletikstaevne_backend.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepo extends JpaRepository<Result, Integer> {
}
