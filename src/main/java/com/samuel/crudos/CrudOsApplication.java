package com.samuel.crudos;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudOsApplication implements CommandLineRunner {

  @Autowired
  private TecnicoRepository tecnicoRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private OSRepository osRepository;

  public static void main(String[] args) {
    SpringApplication.run(CrudOsApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    Tecnico t1 = new Tecnico(
      null,
      "Samuel Melo",
      "144.785.300-84",
      "(83) 99617-2418"
    );

    Cliente c1 = new Cliente(
      null,
      "Mussun",
      "598.508.200-80",
      "(88) 98888-7777"
    );

    OS os1 = new OS(
      null,
      Prioridade.ALTA,
      Status.ANDAMENTO,
      "Teste DB",
      t1,
      c1
    );

    t1.getOrdensServico().add(os1);
    c1.getOrdensServico().add(os1);

    tecnicoRepository.saveAll(Arrays.asList(t1));
    clienteRepository.saveAll(Arrays.asList(c1));
    osRepository.saveAll(Arrays.asList(os1));
  }
}
