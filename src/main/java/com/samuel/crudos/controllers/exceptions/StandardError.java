package com.samuel.crudos.controllers.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

  private static final long serialVersionUID = 1L;
  private long timestamp;
  private Integer status;
  private String error;

  public StandardError() {
      super();
  }

  public StandardError(long timestamp, Integer status, String error) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
