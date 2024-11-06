package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documentacion")
@Data
@NoArgsConstructor 
@AllArgsConstructor 
public class DocumentacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String rut;
    @Lob
    private byte[] comprobanteIngresos;
    @Lob
    private byte[] escrituraVivienda;
    @Lob
    private byte[] historialCrediticio;
    @Lob
    private byte[] certificadoAvaluo;
    @Lob
    private byte[] estadoNegocio;
    @Lob
    private byte[] planNegocio;
    @Lob
    private byte[] presupuestoRemodelacion;
    @Lob
    private byte[] certificadoAntiguedadLaboral;
    @Lob
    private byte[] informeDeudas;
    @Lob
    private byte[] fotocopiaRut;
    @Lob
    private byte[] cuentaAhorros;
}