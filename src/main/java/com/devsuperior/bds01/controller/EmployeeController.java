package com.devsuperior.bds01.controller;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.dto.EmployeeRequestDTO;
import com.devsuperior.bds01.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

//  @GetMapping
//  public ResponseEntity<List<EmployeeDTO>> findAll(){
//
//   List<EmployeeDTO> listEmployeeDTO = employeeService.findAllList();
//
//   return ResponseEntity.status(HttpStatus.OK).body(listEmployeeDTO);
//
//  }

  @GetMapping
  public ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable) {
    PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
    Page<EmployeeDTO> result = employeeService.findAllPaged(pageRequest);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @PostMapping
  public  ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeRequestDTO employeeRequestDTO){
   EmployeeDTO responseDTO = employeeService.insert(employeeRequestDTO);

   return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }

}
