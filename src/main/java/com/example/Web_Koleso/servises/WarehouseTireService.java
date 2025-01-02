package com.example.Web_Koleso.servises;

import com.example.Web_Koleso.models.WarehouseTire;
import com.example.Web_Koleso.repositories.WarehouseTireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class WarehouseTireService {
    @Autowired
    private WarehouseTireRepository warehouseTireRepository;

    @Transactional
    @Modifying
    @Query("DELETE FROM WarehouseTire ") // Используйте JPQL
    public void deleteAll(){warehouseTireRepository.deleteAll();}

    @Transactional
    public void save(WarehouseTire warehouseTire) {warehouseTireRepository.save(warehouseTire);}
}
