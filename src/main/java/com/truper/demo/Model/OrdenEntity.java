package com.truper.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "orden")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class OrdenEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    private String estatus;
    @Column
    private String descripcion;
    @Column
    private int codigo;
}
