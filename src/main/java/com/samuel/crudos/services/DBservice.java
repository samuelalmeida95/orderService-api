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
    Tecnico t1 = new Tecnico(null, "Samuel Melo", "002.671.010-23", "(83) 99617-2418");

    Tecnico t2 = new Tecnico(null, "Matias Melo", "772.578.850-60", "(83) 99617-2418");

    Tecnico t3 = new Tecnico(null, "Lilian Melo", "295.210.920-68", "(83) 99617-2418");

    Tecnico t4 = new Tecnico(null, "Roger", "751.433.200-62", "(83) 99617-2418");

    Tecnico t5 = new Tecnico(null, "Leleco", "737.028.760-22", "(83) 99617-2418");

    Tecnico t6 = new Tecnico(null, "William", "244.595.560-22", "(83) 99617-2418");

    Tecnico t7 = new Tecnico(null, "Ronald", "169.078.050-90", "(83) 99617-2418");

    Tecnico t8 = new Tecnico(null, "Harry", "374.457.230-72", "(83) 99617-2418");

    Tecnico t9 = new Tecnico(null, "Lundgren", "475.583.910-67", "(83) 99617-2418");

    Tecnico t10 = new Tecnico(null, "Paulo", "910.469.570-40", "(83) 99617-2418");

    Tecnico t11 = new Tecnico(null, "Lucas", "144.885.460-13", "(83) 99617-2418");

    Tecnico t12 = new Tecnico(null, "Karol", "683.185.520-24", "(83) 99617-2418");

    Tecnico t13 = new Tecnico(null, "Luiza", "954.934.660-90", "(83) 99617-2418");

    Tecnico t14 = new Tecnico(null, "Cardoso", "544.369.330-16", "(83) 99617-2418");

    Tecnico t15 = new Tecnico(null, "David Gordon", "295.210.920-68", "(83) 99617-2418");

    Cliente c1 = new Cliente(null, "Mussun", "598.508.200-80", "(88) 98888-7777");

    Cliente c2 = new Cliente(null, "Peter", "430.352.510-37", "(88) 98888-7777");

    Cliente c3 = new Cliente(null, "Mussun", "553.830.470-18", "(88) 98888-7777");

    OS os1 = new OS(null, Prioridade.ALTA, Status.ANDAMENTO, "Acesso ao JIRA", t1, c1);

    OS os2 = new OS(null, Prioridade.BAIXA, Status.ABERTO, "Tarefa com impedimento", t3, c2);

    OS os3 = new OS(null, Prioridade.MEDIA, Status.ENCERRADO, "Migrar IDE para VsCode", t2, c3);

    t1.getOrdensServico().add(os1);
    t2.getOrdensServico().add(os2);
    t3.getOrdensServico().add(os3);
    c1.getOrdensServico().add(os1);

    tecnicoRepository.saveAll(
      Arrays.asList(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15
      )
    );

    clienteRepository.saveAll(
      Arrays.asList(
        c1, 
        c2, 
        c3
      )
    );

    osRepository.saveAll(
      Arrays.asList(
        os1, 
        os2, 
        os3
      )
    );
  }
}
