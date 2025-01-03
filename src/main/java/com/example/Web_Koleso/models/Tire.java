package com.example.Web_Koleso.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Table(name = "tire", schema = "public")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "warehouseTire")
public class Tire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")


    private long id;
    @NotEmpty(message = "Артикул не может быть пустым")
    private long article;
    private String name;

    @OneToMany(mappedBy = "tire",orphanRemoval = true)
    private Set<WarehouseTire> warehouseTire;
}
