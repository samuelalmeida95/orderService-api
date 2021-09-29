package com.samuel.crudos.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.samuel.crudos.DTOS.TecnicoDTO;
import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.services.TecnicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin("*")
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

  @PostMapping
  public ResponseEntity<TecnicoDTO> create(
    @Valid @RequestBody TecnicoDTO tecnico) {
    Tecnico novoTecnico = service.create(tecnico);

    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")  
      .buildAndExpand(novoTecnico.getId())
      .toUri();
      
    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "atualizar/{idTecnico}")
  public ResponseEntity<TecnicoDTO> update(
    @PathVariable Integer idTecnico,
    @Valid 
    @RequestBody TecnicoDTO tecnicoDTO) {
    TecnicoDTO tecnicoAtualizado = new TecnicoDTO(service.update(idTecnico, tecnicoDTO));
    return ResponseEntity.ok().body(tecnicoAtualizado);
  }

  @DeleteMapping(value = "/{idTecnico}")
  public ResponseEntity<String> delete(@PathVariable Integer idTecnico){
    service.delete(idTecnico);
    return new ResponseEntity<>("Técnico deletado.",HttpStatus.ACCEPTED);
  }
}
