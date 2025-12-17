package com.app.armario.controller.dto;

import java.util.Set;

import com.app.armario.datamodel.entity.Estilo;
import com.app.armario.datamodel.entity.Prenda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutfitDTO {
    
    private String nombre;

    private String estacion;
    
    private String imagen_url;

    private Set<Prenda> prendas;

    private Set<Estilo> estilos;
}
