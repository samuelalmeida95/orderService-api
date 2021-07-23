package com.samuel.crudos.services;

import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.repositories.TecnicoRepository;
import com.samuel.crudos.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

  @Autowired
  public TecnicoRepository tecnicoRepository;

  public Tecnico findById(Integer idTecnico) {
    Optional<Tecnico> tecnicoBuscado = tecnicoRepository.findById(idTecnico);
    return tecnicoBuscado.orElseThrow(() -> new ObjectNotFoundException(
        "Técnico não encontrado id: " + idTecnico + ", Tipo: " + Tecnico.class.getName()));
  }

  public List<Tecnico> findAll() {
    return tecnicoRepository.findAll();
  }
}
