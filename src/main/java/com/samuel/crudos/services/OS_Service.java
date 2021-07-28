package com.samuel.crudos.services;

import com.samuel.crudos.model.OS;
import com.samuel.crudos.repositories.OSRepository;
import com.samuel.crudos.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OS_Service {

  @Autowired
  private OSRepository osRepository;

  public OS findById(Integer idOS) {
    Optional<OS> obj = osRepository.findById(idOS);
    return obj.orElseThrow(() ->
        new ObjectNotFoundException(
          "Objeto não encontrado! ID: " + idOS + "Tipo: " + OS.class.getName()));
  }
}
