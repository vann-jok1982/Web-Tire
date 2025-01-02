package com.example.Web_Koleso.servises;

import com.example.Web_Koleso.models.Warehouse;
import com.example.Web_Koleso.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Transactional
    @Modifying
    @Query("DELETE FROM Warehouse ") // Используйте JPQL
    public void deleteAll(){warehouseRepository.deleteAll();}

    @Transactional
    public Warehouse save(String name) {
        Warehouse newWarehouse = new Warehouse();
        newWarehouse.setName(name);
        return warehouseRepository.save(newWarehouse);
    }
    public List<Warehouse> findAllWarehouses() {return warehouseRepository.findAll();}
}
