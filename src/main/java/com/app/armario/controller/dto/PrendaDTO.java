package com.app.armario.controller.dto;

import java.util.Set;

import com.app.armario.datamodel.entity.Color;
import com.app.armario.datamodel.entity.Outfit;
import com.app.armario.datamodel.entity.Tipo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrendaDTO {
    
    private String nombre;

    private String estacion;

    private String imagen_url;

    private Set<Tipo> tipos;

    private Set<Outfit> outfits;

    private Set<Color> colores;
}
