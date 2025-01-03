package com.example.Web_Koleso.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

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
    @NotBlank(message = "Заголовок не должен быть пустым")
    private long article;
    @NotBlank(message = "Заголовок не должен быть пустым")
    private String name;

    @OneToMany(mappedBy = "tire",orphanRemoval = true)
    private Set<WarehouseTire> warehouseTire;
}
