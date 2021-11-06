package com.samuel.crudos.services;

import com.samuel.crudos.DTOS.OSDTO;
import com.samuel.crudos.enuns.Prioridade;
import com.samuel.crudos.enuns.Status;
import com.samuel.crudos.model.Cliente;
import com.samuel.crudos.model.OS;
import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.repositories.OSRepository;
import com.samuel.crudos.services.exceptions.ObjectNotFoundException;
import java.time.LocalDateTime;
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

  public OS create(OSDTO OSParaCriar) {
    return fromDTO(OSParaCriar);
  }

  public OS update(OSDTO OSParaAlterar) {
    findById(OSParaAlterar.getId());
    return fromDTO(OSParaAlterar);
  }

  private OS fromDTO(OSDTO os) {
    OS novaOS = new OS();
    novaOS.setId(os.getId());
    novaOS.setPrioridade(os.getPrioridade());
    novaOS.setStatus(os.getStatus());
    novaOS.setObservacoes(os.getObservacoes());

    Tecnico tec = tecnicoService.findById(os.getTecnico());
    Cliente cli = clienteService.findById(os.getCliente());

    novaOS.setTecnico(tec);
    novaOS.setCliente(cli);

    if (novaOS.getStatus().getCod().equals(2)) novaOS.setDataFechamento(
      LocalDateTime.now()
    );

    return osRepository.save(novaOS);
  }

  public List<OS> findByStatus(Integer idStatus) {

    if(idStatus > 2)
      throw new ObjectNotFoundException("O Status: " + idStatus + " é inexistente");

    return osRepository.findByStatus(idStatus);
  }
}
