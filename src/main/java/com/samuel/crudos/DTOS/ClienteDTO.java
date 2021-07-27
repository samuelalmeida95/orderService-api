package com.samuel.crudos.DTOS;

import javax.validation.constraints.NotEmpty;

import com.samuel.crudos.model.Cliente;


public class ClienteDTO {

  private Integer id;

  @NotEmpty(message = "O campo nome é requerido")
  private String nome;

  @NotEmpty(message = "O campo cpf é requerido")
  private String cpf;

  @NotEmpty(message = "O campo telefone é requerido")
  private String telefone;

  public ClienteDTO() {
    super();
  }

  public ClienteDTO(Cliente clienteFiltrado) {
    this.id = clienteFiltrado.getId();
    this.nome = clienteFiltrado.getNome();
    this.cpf = clienteFiltrado.getCpf();
    this.telefone = clienteFiltrado.getTelefone();
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
