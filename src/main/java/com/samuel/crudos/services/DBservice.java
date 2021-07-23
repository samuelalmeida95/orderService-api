package com.samuel.crudos.services;

import com.samuel.crudos.enuns.Prioridade;
import com.samuel.crudos.enuns.Status;
import com.samuel.crudos.model.Cliente;
import com.samuel.crudos.model.OS;
import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.repositories.ClienteRepository;
import com.samuel.crudos.repositories.OSRepository;
import com.samuel.crudos.repositories.TecnicoRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBservice {

  @Autowired
  private TecnicoRepository tecnicoRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private OSRepository osRepository;

  public void instanciaDB() {
    Tecnico t1 = new Tecnico(null, "Samuel Melo", "144.785.300-84", "(83) 99617-2418");

    Tecnico t2 = new Tecnico(null, "Matias Melo", "144.785.300-84", "(83) 99617-2418");

    Tecnico t3 = new Tecnico(null, "Lilian Melo", "144.785.300-84", "(83) 99617-2418");

    Cliente c1 = new Cliente(null, "Mussun", "598.508.200-80", "(88) 98888-7777");

    OS os1 = new OS(null, Prioridade.ALTA, Status.ANDAMENTO, "Acesso ao JIRA", t1, c1);

    OS os2 = new OS(null, Prioridade.BAIXA, Status.ABERTO, "Tarefa com impedimento", t3, c1);

    OS os3 = new OS(null, Prioridade.MEDIA, Status.ENCERRADO, "Migrar IDE para VsCode", t2, c1);

    t1.getOrdensServico().add(os1);
    t2.getOrdensServico().add(os2);
    t3.getOrdensServico().add(os3);
    c1.getOrdensServico().add(os1);

    tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3));
    clienteRepository.saveAll(Arrays.asList(c1));
    osRepository.saveAll(Arrays.asList(os1, os2, os3));
  }
}
