package com.samuel.crudos.DTOS;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.samuel.crudos.model.OS;

public class OSDTO {

  private Integer id;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime dataAbertura;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime dataFechamento;
  
  private Integer prioridade;
  private Integer status;
  private String observacoes;
  private Integer tecnico;
  private Integer cliente;

  public OSDTO() {}

  public OSDTO(OS obj) {
    this.id = obj.getId();
    this.dataAbertura = obj.getDataAbertura();
    this.dataFechamento = obj.getDataFechamento();
    this.prioridade = obj.getPrioridade().getCod();
    this.status = obj.getStatus().getCod();
    this.observacoes = obj.getObservacoes();
    this.tecnico = obj.getTecnico().getId();
    this.cliente = obj.getCliente().getId();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDateTime getDataAbertura() {
    return dataAbertura;
  }

  public void setDataAbertura(LocalDateTime dataAbertura) {
    this.dataAbertura = dataAbertura;
  }

  public LocalDateTime getDataFechamento() {
    return dataFechamento;
  }

  public void setDataFechamento(LocalDateTime dataFechamento) {
    this.dataFechamento = dataFechamento;
  }

  public Integer getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(Integer prioridade) {
    this.prioridade = prioridade;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }

  public Integer getTecnico() {
    return tecnico;
  }

  public void setTecnico(Integer tecnico) {
    this.tecnico = tecnico;
  }

  public Integer getCliente() {
    return cliente;
  }

  public void setCliente(Integer cliente) {
    this.cliente = cliente;
  }
}
