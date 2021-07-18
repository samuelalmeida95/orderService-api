package com.samuel.crudos.model;

import com.samuel.crudos.enuns.Prioridade;
import com.samuel.crudos.enuns.Status;
import java.time.LocalDateTime;

public class OS {

  private Integer id;
  private LocalDateTime dataAbertura;
  private LocalDateTime dataFechamento;
  private Integer prioridade;
  private Integer status;
  private String observacoes;
  private Tecnico tecnico;
  private Cliente cliente;

  public OS() {
    this.setDataAbertura(LocalDateTime.now());
    this.setPrioridade(Prioridade.BAIXA);
    this.setStatus(Status.ABERTO);
  }

  public OS(
    Integer id,
    Prioridade prioridade,
    Status status,
    String observacoes,
    Tecnico tecnico,
    Cliente cliente
  ) {
    this.id = id;
    this.setDataAbertura(LocalDateTime.now());
    this.prioridade = (prioridade == null) ? 0 : prioridade.getCod();
    this.status = (prioridade == null) ? 0 : status.getCod();
    this.observacoes = observacoes;
    this.tecnico = tecnico;
    this.cliente = cliente;
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

  public Prioridade getPrioridade() {
    return Prioridade.toEnum(this.prioridade);
  }

  public void setPrioridade(Prioridade prioridade) {
    this.prioridade = prioridade.getCod();
  }

  public Status getStatus() {
    return Status.toEnum(this.status);
  }

  public void setStatus(Status status) {
    this.status = status.getCod();
  }

  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }

  public Tecnico getTecnico() {
    return tecnico;
  }

  public void setTecnico(Tecnico tecnico) {
    this.tecnico = tecnico;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    OS other = (OS) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }
}
