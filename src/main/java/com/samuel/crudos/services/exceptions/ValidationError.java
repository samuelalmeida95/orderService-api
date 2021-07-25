package com.samuel.crudos.services.exceptions;

import com.samuel.crudos.controllers.exceptions.StandardError;
import java.util.LinkedList;
import java.util.List;

public class ValidationError extends StandardError {

  private static final long serialVersionUID = 1L;

  private List<FieldMessage> erros = new LinkedList<>();

  public ValidationError() {}

  public ValidationError(long timestamp, Integer status, String error) {
    super(timestamp, status, error);
  }

  public List<FieldMessage> getErros() {
    return erros;
  }

  public void addErro(String fieldName, String message) {
    this.erros.add(new FieldMessage(fieldName, message));
  }
}
