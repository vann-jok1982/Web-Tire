package com.example.Web_Koleso.repositories;

import com.example.Web_Koleso.models.WarehouseTire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface WarehouseTireRepository extends JpaRepository<WarehouseTire, Long> {
}
