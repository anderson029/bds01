package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;

import java.io.Serializable;

public class DepartamentResponseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;


  public DepartamentResponseDTO() {
  }

  public DepartamentResponseDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public DepartamentResponseDTO(Department department) {
    this.id = department.getId();
    this.name = department.getName();
  }


  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
