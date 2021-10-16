package com.samuel.crudos.DTOS;

import javax.validation.constraints.NotEmpty;

import com.samuel.crudos.model.Tecnico;
import org.hibernate.validator.constraints.br.CPF;

public class TecnicoDTO {

  private Integer id;

  @NotEmpty(message = "O campo nome é requerido")
  private String nome;

  @CPF
  @NotEmpty(message = "O campo cpf é requerido")
  private String cpf;
  
  @NotEmpty(message = "O campo telefone é requerido")
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
