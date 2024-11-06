package com.example.demo.entities;

import com.example.demo.Estado;
import com.example.demo.TipoPrestamo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "creditos")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class CreditoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String rut; 

    @Column(name = "plazo", nullable = false)
    private int plazo;

    @Column(name = "tasaInteres", nullable = false)
    private double tasaInteres;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoPrestamo", nullable = false)
    private TipoPrestamo tipoPrestamo;

    private double valorPropiedad;

    private double cuotaMensual;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.EN_REVISION_INICIAL; 
}