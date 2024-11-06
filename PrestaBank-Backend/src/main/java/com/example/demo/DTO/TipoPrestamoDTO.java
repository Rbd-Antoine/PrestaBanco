package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class TipoPrestamoDTO {
    private String nombre;
    private int plazoMaximo;
    private int montoMaximo;
    private double tasaInteresMinima;
    private double tasaInteresMaxima;
    private boolean comprobanteIngreso;
    private boolean certificadoAvaluo;
    private boolean historialCrediticio;
    private boolean escrituraVivienda;
    private boolean estadoFinanciero;
    private boolean planNegocios;
    private boolean presupuestoRemodelacion;

}
