package com.samuel.crudos.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.samuel.crudos.DTOS.ClienteDTO;
import com.samuel.crudos.model.Cliente;
import com.samuel.crudos.services.ClienteService;

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
@RequestMapping(value = "/clientes")
public class ClienteController {

  @Autowired
  private ClienteService service;

  @GetMapping(value = "/{idCliente}")
  public ResponseEntity<ClienteDTO> findById(@PathVariable Integer idCliente) {
    ClienteDTO objDTO = new ClienteDTO(service.findById(idCliente));
    return ResponseEntity.ok().body(objDTO);
  }

  @GetMapping
  public ResponseEntity<List<ClienteDTO>> findAll() {

    List<ClienteDTO> listDTO = service
      .findAll()
      .stream()
      .map(Cliente -> new ClienteDTO(Cliente))
      .collect(Collectors.toList());

    return ResponseEntity.ok().body(listDTO);
  }

  @PostMapping
  public ResponseEntity<ClienteDTO> create(
    @Valid 
    @RequestBody ClienteDTO Cliente) {
    Cliente novoCliente = service.create(Cliente);

    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(novoCliente.getId())
      .toUri();

    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "atualizar/{idCliente}")
  public ResponseEntity<ClienteDTO> update(
    @PathVariable Integer idCliente,
    @Valid
    @RequestBody ClienteDTO ClienteDTO) {

    ClienteDTO ClienteAtualizado = new ClienteDTO(
      service.update(idCliente, ClienteDTO));

    return ResponseEntity.ok().body(ClienteAtualizado);
  }

  @DeleteMapping(value = "/{idCliente}")
  public ResponseEntity<String> delete(@PathVariable Integer idCliente) {
    service.delete(idCliente);
    return new ResponseEntity<>("Cliente deletado.", HttpStatus.ACCEPTED);
  }
}
