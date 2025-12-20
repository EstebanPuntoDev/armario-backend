package com.app.armario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.armario.controller.dto.ColorDTO;
import com.app.armario.datamodel.entity.Prenda;
import com.app.armario.datamodel.repository.PrendaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PrendaService {

    private final PrendaRepository prendaRepository;

    public List<Prenda> getAllPrendas() {
        return prendaRepository.findAll();
    }

    public Prenda getPrendaById(Long id) {
        Optional<Prenda> optPrenda = prendaRepository.findById(id);
        if(optPrenda.isPresent()){
            return optPrenda.get();
        }else{
            // TODO: Excepción no existe prenda con tal id
            return null;
        }
    }

    public List<Prenda> getPrendaByColor(String color) {
        return prendaRepository.findByColoresNombreLike(color);
    }

    public List<Prenda> getPrendaByColorTipo(String color, String tipo) {
        
        String colorFinal = (color!=null && !color.isEmpty()) ? color : null;
        String tipoFinal = (tipo!=null && !tipo.isEmpty()) ? tipo : null;

        return prendaRepository.buscarPorCriterios(colorFinal, tipoFinal);
    }
    
}
