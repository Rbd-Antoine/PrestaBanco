package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class CostoDTO {
    private Double cuotaMensual;
    private Double comisionAdmin;
    private Double seguroDesgravamen;
    private Double seguroIncendio = 20000.00;
    private Double costoMensual;
    private Double costoTotal;
}
