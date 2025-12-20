package com.app.armario.datamodel.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "OUTFIT")
@Getter
@Setter
public class Outfit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estacion", nullable = false)
    private String estacion;
    
    @Column(name = "imagen_url", nullable = true)
    private String imagen_url;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "outfits")
    private Set<Prenda> prendas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="REL_OUTFIT_ESTILO",
        joinColumns = @JoinColumn(name = "OUTFIT_ID", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "ESTILO_ID", nullable = false))
    private Set<Estilo> estilos;
}
