package com.samuel.crudos.model;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {

  @OneToMany(mappedBy = "cliente")
  private List<OS> ordensServico = new LinkedList<>();

  public Cliente() {}

  public Cliente(Integer id, String nome, String cpf, String telefone) {
    super(id, nome, cpf, telefone);
  }

  public List<OS> getOrdensServico() {
    return ordensServico;
  }

  public void setOrdensServico(List<OS> ordensServico) {
    this.ordensServico = ordensServico;
  }
}
