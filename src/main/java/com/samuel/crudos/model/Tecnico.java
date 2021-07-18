package com.samuel.crudos.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Tecnico extends Pessoa {

  @OneToMany(mappedBy = "tecnico")
  private List<OS> ordensServico = new LinkedList<>();

  public Tecnico() {}

  public Tecnico(Integer id, String nome, String cpf, String telefone) {
    super(id, nome, cpf, telefone);
  }

  public List<OS> getOrdensServico() {
    return ordensServico;
  }

  public void setOrdensServico(List<OS> ordensServico) {
    this.ordensServico = ordensServico;
  }
}
