package com.samuel.crudos.controllers;

import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.services.TecnicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {
    
    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value = "/{idTecnico}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer idTecnico){
        Tecnico tecnicoBuscado = tecnicoService.findById(idTecnico);
        return ResponseEntity.ok().body(tecnicoBuscado);
    }
}