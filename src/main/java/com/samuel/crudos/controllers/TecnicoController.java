package com.samuel.crudos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.samuel.crudos.DTOS.TecnicoDTO;
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
  private TecnicoService service;

  @GetMapping(value = "/{idTecnico}")
  public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer idTecnico) {
    TecnicoDTO objDTO = new TecnicoDTO(service.findById(idTecnico));
    return ResponseEntity.ok().body(objDTO);
  }

  @GetMapping
  public ResponseEntity<List<TecnicoDTO>> findAll() {
    List<TecnicoDTO> listDTO = service
      .findAll()
      .stream()
      .map(tecnico -> new TecnicoDTO(tecnico))
      .collect(Collectors.toList());
      return ResponseEntity.ok().body(listDTO);
  }
}
