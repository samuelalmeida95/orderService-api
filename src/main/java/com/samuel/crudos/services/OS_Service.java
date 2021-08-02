package com.samuel.crudos.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.samuel.crudos.DTOS.OSDTO;
import com.samuel.crudos.enuns.Prioridade;
import com.samuel.crudos.enuns.Status;
import com.samuel.crudos.model.Cliente;
import com.samuel.crudos.model.OS;
import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.repositories.OSRepository;
import com.samuel.crudos.services.exceptions.ObjectNotFoundException;

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

  public OS findById(Integer idOrdemServico) {
    Optional<OS> obj = osRepository.findById(idOrdemServico);

    return obj.orElseThrow(
        () -> new ObjectNotFoundException("Objeto não encontrado! ID: " + idOrdemServico + "Tipo: " + OS.class.getName()));
  }

  public List<OS> findAll() {
    return osRepository.findAll();
  }

  public OS create(OSDTO novaOrdemServico) {
    return fromDTO(novaOrdemServico);
  }

  public OS update(OSDTO alterarOrdemServico){
    findById(alterarOrdemServico.getId());
    return fromDTO(alterarOrdemServico);
  }

  private OS fromDTO(OSDTO ordemServico) {
    OS novaOrdemServico = new OS();
    novaOrdemServico.setId(ordemServico.getId());
    novaOrdemServico.setPrioridade(Prioridade.toEnum(ordemServico.getPrioridade()));
    novaOrdemServico.setStatus(Status.toEnum(ordemServico.getStatus()));
    novaOrdemServico.setObservacoes(ordemServico.getObservacoes());

    Tecnico tec = tecnicoService.findById(ordemServico.getTecnico());
    Cliente cli = clienteService.findById(ordemServico.getCliente());

    novaOrdemServico.setTecnico(tec);
    novaOrdemServico.setCliente(cli);

    if(novaOrdemServico.getStatus().getCod().equals(2))
      novaOrdemServico.setDataFechamento(LocalDateTime.now());

    return osRepository.save(novaOrdemServico);
  }
}
