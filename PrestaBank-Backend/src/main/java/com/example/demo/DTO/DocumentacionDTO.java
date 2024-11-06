package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor 
public class DocumentacionDTO {
    private Long id;
    private String rut;
    private String comprobanteIngresos;
    private String escrituraVivienda;
    private String historialCrediticio;
    private String certificadoAvaluo;
    private String estadoNegocio;
    private String planNegocio;
    private String presupuestoRemodelacion;
    private String certificadoAntiguedadLaboral;
    private String informeDeudas;
    private String fotocopiaRut;
    private String cuentaAhorros;
}
