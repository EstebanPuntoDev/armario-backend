package com.app.armario.controller.dto;

import java.util.Set;

import com.app.armario.datamodel.entity.Prenda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDTO {
    
    private String nombre;

    private Set<Prenda> prendas;
}
