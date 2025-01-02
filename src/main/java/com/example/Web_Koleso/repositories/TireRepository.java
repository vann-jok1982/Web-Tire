package com.example.Web_Koleso.repositories;

import com.example.Web_Koleso.models.Tire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TireRepository extends JpaRepository<Tire, Long> {
    @Transactional(readOnly = true)
    Optional<Tire> findByArticle(Long article);
}
