package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartamentResponseDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentService {

  @Autowired
  private DepartamentRepository departamentRepository;

  public List<DepartamentResponseDTO> findAll(){
     List<Department> listDepartament= departamentRepository.findAll(Sort.by("name"));
     return listDepartament.stream().map(department -> new DepartamentResponseDTO(department)).collect(Collectors.toList());
  }
}
