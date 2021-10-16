package com.samuel.crudos.services;

import com.samuel.crudos.DTOS.TecnicoDTO;
import com.samuel.crudos.model.Pessoa;
import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.repositories.PessoaRepository;
import com.samuel.crudos.repositories.TecnicoRepository;
import com.samuel.crudos.services.exceptions.DataIntegratyViolationException;
import com.samuel.crudos.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

  @Autowired
  public TecnicoRepository tecnicoRepository;

  @Autowired
  public PessoaRepository pessoaRepository;

  public Tecnico findById(Integer idTecnico) {
    Optional<Tecnico> tecnicoBuscado = tecnicoRepository.findById(idTecnico);
    return tecnicoBuscado.orElseThrow(() -> new ObjectNotFoundException(
        "Técnico não encontrado id: " + idTecnico + ", Tipo: " + Tecnico.class.getName()));
  }

  public List<Tecnico> findAll() {
    return tecnicoRepository.findAll();
  }

  public Tecnico create(TecnicoDTO tecnicoParaCriar) {
    if (
      findByCPF(tecnicoParaCriar) != null
    ) throw new DataIntegratyViolationException(
      "CPF já cadastrado na base de dados CPF: " + tecnicoParaCriar.getCpf()
    );

    return tecnicoRepository.save(
      new Tecnico(
        null,
        tecnicoParaCriar.getNome(),
        tecnicoParaCriar.getCpf(),
        tecnicoParaCriar.getTelefone()
      )
    );
  }

  public Tecnico update(Integer idTecnico, @Valid TecnicoDTO tecnicoAlterado) {
    Tecnico tecnicoBuscado = findById(idTecnico);

    if (
      findByCPF(tecnicoAlterado) != null &&
      findByCPF(tecnicoAlterado).getId() != idTecnico
    ) {
      throw new DataIntegratyViolationException(
        "CPF já cadstrado na base de dados"
      );
    }

    tecnicoBuscado = updateData(tecnicoBuscado, tecnicoAlterado);
    return tecnicoRepository.save(tecnicoBuscado);
  }

  public Tecnico updateData(
    Tecnico tecnicoParaAtualizar,
    TecnicoDTO tecnicoAlterado
  ) {
    tecnicoParaAtualizar.setNome(tecnicoAlterado.getNome());
    tecnicoParaAtualizar.setCpf(tecnicoAlterado.getCpf());
    tecnicoParaAtualizar.setTelefone(tecnicoAlterado.getTelefone());
    return tecnicoParaAtualizar;
  }

  private Pessoa findByCPF(TecnicoDTO tecnico) {
    Pessoa obj = pessoaRepository.findByCPF(tecnico.getCpf());
    if (obj != null) return obj;
    return null;
  }

  public void delete(Integer idTecnico) {
    findById(idTecnico);
    try {
      tecnicoRepository.deleteById(idTecnico);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegratyViolationException(
        "Tecnico não pode ser deletado, possui OS associadas"
      );
    }
  }
}
