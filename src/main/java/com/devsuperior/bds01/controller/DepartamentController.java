package com.devsuperior.bds01.controller;

import com.devsuperior.bds01.dto.DepartamentResponseDTO;
import com.devsuperior.bds01.services.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartamentController {

  @Autowired
  private DepartamentService departamentService;

  @GetMapping
  public List<DepartamentResponseDTO> findAll(){
     List<DepartamentResponseDTO> listDepartament= departamentService.findAll();
     return ResponseEntity.status(HttpStatus.OK).body(listDepartament).getBody();
  }
}
