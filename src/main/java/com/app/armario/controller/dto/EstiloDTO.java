package com.app.armario.controller.dto;

import java.util.Set;

import com.app.armario.datamodel.entity.Outfit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstiloDTO {
    
    private String nombre;

    private Set<Outfit> outfit;
}
