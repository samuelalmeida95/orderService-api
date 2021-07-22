package com.samuel.crudos.DTOS;

import com.samuel.crudos.model.Tecnico;

public class TecnicoDTO {

  private Integer id;
  private String nome;
  private String cpf;
  private String telefone;

  public TecnicoDTO() {
    super();
  }

  public TecnicoDTO(Tecnico tecnicoFiltrado) {
    this.id = tecnicoFiltrado.getId();
    this.nome = tecnicoFiltrado.getNome();
    this.cpf = tecnicoFiltrado.getCpf();
    this.telefone = tecnicoFiltrado.getTelefone();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}
