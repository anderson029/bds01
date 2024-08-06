package com.devsuperior.bds01.dto;

import java.io.Serializable;

public class EmployeeRequestDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private Long departmentId;

  public EmployeeRequestDTO() {
  }

  public EmployeeRequestDTO(String name, String email, Long departmentId) {
    this.name = name;
    this.email = email;
    this.departmentId = departmentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }
}


