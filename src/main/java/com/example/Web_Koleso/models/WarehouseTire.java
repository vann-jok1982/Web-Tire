package com.example.Web_Koleso.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "warehouse_tire", schema = "public")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseTire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    private Warehouse warehouse;
    @ManyToOne
    private Tire tire;

    private int availableNow;

    private int expectedFuture;
    private int reservedFuture;
    private int availableFuture;

    private int availableTotal;
    private int providedTotal;
    private int deficitTotal;
    private int surplusTotal;
}
