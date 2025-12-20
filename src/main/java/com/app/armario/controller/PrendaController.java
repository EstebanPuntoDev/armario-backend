package com.app.armario.controller;

import org.springframework.web.bind.annotation.RestController;

import com.app.armario.controller.dto.ColorDTO;
import com.app.armario.datamodel.entity.Prenda;
import com.app.armario.service.PrendaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("prenda")
@RequiredArgsConstructor
public class PrendaController {
    
    private final PrendaService prendaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Prenda>> getAllPrendas() {
        return ResponseEntity.ok().body(prendaService.getAllPrendas());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Prenda> getPrendaById(@PathVariable Long id) {
        return ResponseEntity.ok().body(prendaService.getPrendaById(id));
    }
    
    @GetMapping("/get")
    public ResponseEntity<List<Prenda>> getPrendaByColor(@RequestParam(required = false) String color, @RequestParam(required = false) String tipo) {
        return ResponseEntity.ok().body(prendaService.getPrendaByColorTipo(color, tipo));
    }
    
}
