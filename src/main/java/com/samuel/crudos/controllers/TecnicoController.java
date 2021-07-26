package com.samuel.crudos.controllers;

import com.samuel.crudos.DTOS.TecnicoDTO;
import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.services.TecnicoService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
  public ResponseEntity<Tecnico> update(
    @PathVariable Integer idTecnico,
    @RequestBody Tecnico tecnico) {
    Tecnico tecnicoParaAtualizar = service.update(idTecnico, tecnico);
    return ResponseEntity.ok().body(tecnicoParaAtualizar);
  }
}
