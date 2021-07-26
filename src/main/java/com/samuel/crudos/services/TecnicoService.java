package com.samuel.crudos.services;

import java.util.List;
import java.util.Optional;

import com.samuel.crudos.DTOS.TecnicoDTO;
import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.repositories.TecnicoRepository;
import com.samuel.crudos.services.exceptions.DataIntegratyViolationException;
import com.samuel.crudos.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

  public Tecnico create(TecnicoDTO objDTO) {
    if (findByCPF(objDTO) != null)
      throw new DataIntegratyViolationException("CPF já cadastrado na base de dados CPF: " + objDTO.getCpf());

    return tecnicoRepository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
  }

  private Tecnico findByCPF(TecnicoDTO objDTO) {
    Tecnico obj = tecnicoRepository.findByCPF(objDTO.getCpf());
    if (obj != null)
      return obj;
    return null;
  }

  public Tecnico update(Integer idTecnico, TecnicoDTO tecnicoDTO) {
    Tecnico tecnicoBuscado = findById(idTecnico);

    if(findByCPF(tecnicoDTO) != null && findByCPF(tecnicoDTO).getId() != idTecnico)
      throw new DataIntegratyViolationException("CPF já cadstrado na base de dados");
    

    tecnicoBuscado = updateData(tecnicoBuscado, tecnicoDTO);
    return tecnicoRepository.save(tecnicoBuscado);
  }

  public Tecnico updateData(Tecnico tecnicoParaAtualizar, TecnicoDTO tecnico) {
    tecnicoParaAtualizar.setNome(tecnico.getNome());
    tecnicoParaAtualizar.setCpf(tecnico.getCpf());
    tecnicoParaAtualizar.setTelefone(tecnico.getTelefone());
    return tecnicoParaAtualizar;
  }

  public void delete(Integer id) {
    findById(id);
    try {
      tecnicoRepository.deleteById(id);

    } catch (DataIntegrityViolationException e) {
      throw new DataIntegratyViolationException("Tecnico não pode ser deletado, possui OS associadas");
    }
  }
}
