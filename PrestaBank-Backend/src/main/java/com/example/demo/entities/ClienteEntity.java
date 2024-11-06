package com.example.demo.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data //genera automaticamente los getters y setters
@NoArgsConstructor //genera un constructor sin argumentos para la clase
@AllArgsConstructor //constructor con todos los argumentos de la clase, por si se los pasas
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String rut;
    private String nombre;
    private String apellidos;
    private int edad;
    private Double ingresos;
    private Boolean esMoroso;
    private Boolean esIndependiente;
    private Boolean esEstable;
    private Integer antiguedadLaboral;
    private Double deudaTotal;
    private String capacidadAhorro; 
    private Double saldo; 
    private Double mayorRetiro12; 
    private Boolean saldoPositivo; 
    private Integer tiempoCuentaAhorros;
    private Double mayorRetiro6;
    private Boolean depositoRegular; 
    private Double totalDepositos; 

}