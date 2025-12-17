package com.app.armario.datamodel.entity;

import java.util.Set;

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
@Table(name = "PRENDA")
@Getter
@Setter
public class Prenda {
    
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="REL_PRENDA_TIPO",
        joinColumns = @JoinColumn(name = "PRENDA_ID", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "TIPO_ID", nullable = false))
    private Set<Tipo> tipos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="REL_PRENDA_OUTFIT",
        joinColumns = @JoinColumn(name = "PRENDA_ID", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "OUTFIT_ID", nullable = false))
    private Set<Outfit> outfits;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="REL_PRENDA_COLOR",
        joinColumns = @JoinColumn(name = "PRENDA_ID", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "COLOR_ID", nullable = false))
    private Set<Color> colores;
}
