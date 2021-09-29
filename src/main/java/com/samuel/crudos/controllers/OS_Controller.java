package com.samuel.crudos.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.samuel.crudos.DTOS.OSDTO;
import com.samuel.crudos.services.OS_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/os")
public class OS_Controller {

  @Autowired
  private OS_Service service;

  @GetMapping(value = "/{idOS}")
  public ResponseEntity<OSDTO> findById(@PathVariable Integer idOS) {
    return ResponseEntity.ok().body(new OSDTO(service.findById(idOS)));
  }

  @GetMapping
  public ResponseEntity<List<OSDTO>> findAll() {

    List<OSDTO> list = service
      .findAll()
      .stream()
      .map(ordem_servico -> new OSDTO(ordem_servico))
      .collect(Collectors.toList());

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/status")
  public ResponseEntity<List<OSDTO>> findByStatus(@RequestParam Integer idStatus){

    List<OSDTO> list = service
    .findByStatus(idStatus)
    .stream()
    .map(ordemServico -> new OSDTO(ordemServico))
    .collect(Collectors.toList());

    return ResponseEntity.ok().body(list);
  }

  @PostMapping
  public ResponseEntity<OSDTO> create(@RequestBody OSDTO obj) {
    obj = new OSDTO(service.create(obj));

    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(obj.getId())
      .toUri();

    return ResponseEntity.created(uri).build();
  }

  @PutMapping
  public ResponseEntity<OSDTO> update(@RequestBody OSDTO objDTO){
    objDTO = new OSDTO(service.update(objDTO));
    return ResponseEntity.ok().body(objDTO);
  }
}
