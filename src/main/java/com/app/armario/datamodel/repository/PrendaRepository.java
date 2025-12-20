package com.app.armario.datamodel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.armario.datamodel.entity.Prenda;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {

    public List<Prenda> findByColoresNombreLike(String color);

    @Query("SELECT p FROM Prenda p " +
        " LEFT JOIN FETCH p.colores c" +
        " LEFT JOIN FETCH p.tipos t" + 
        " WHERE (:color IS NULL OR c.nombre = :color) AND " + 
        " (:tipo IS NULL OR t.nombre = :tipo)"
    )
    public List<Prenda> buscarPorCriterios(String color, String tipo);
    
}
