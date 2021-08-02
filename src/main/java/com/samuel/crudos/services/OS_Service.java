package com.samuel.crudos.services;

import com.samuel.crudos.DTOS.OSDTO;
import com.samuel.crudos.enuns.Prioridade;
import com.samuel.crudos.enuns.Status;
import com.samuel.crudos.model.Cliente;
import com.samuel.crudos.model.OS;
import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.repositories.OSRepository;
import com.samuel.crudos.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OS_Service {

  @Autowired
  private OSRepository osRepository;

  @Autowired
  private TecnicoService tecnicoService;

  @Autowired
  private ClienteService clienteService;

  public OS findById(Integer idOS) {
    Optional<OS> obj = osRepository.findById(idOS);

    return obj.orElseThrow(
        () -> new ObjectNotFoundException("Objeto não encontrado! ID: " + idOS + "Tipo: " + OS.class.getName()));
  }

  public List<OS> findAll() {
    return osRepository.findAll();
  }

  public OS create(OSDTO obj) {
    return fromDTO(obj);
  }

  private OS fromDTO(OSDTO obj) {
    OS ordem_servico = new OS();
    ordem_servico.setId(obj.getId());
    ordem_servico.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
    ordem_servico.setStatus(Status.toEnum(obj.getStatus()));
    ordem_servico.setObservacoes(obj.getObservacoes());

    Tecnico tec = tecnicoService.findById(obj.getTecnico());
    Cliente cli = clienteService.findById(obj.getCliente());

    ordem_servico.setTecnico(tec);
    ordem_servico.setCliente(cli);

    return osRepository.save(ordem_servico);
  }
}
