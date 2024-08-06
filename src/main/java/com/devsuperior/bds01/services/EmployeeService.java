package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.dto.EmployeeRequestDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<EmployeeDTO> findAllList(){
    List<Employee> listEmployee = employeeRepository.findAll(Sort.by("name"));
//    List<EmployeeDTO> employeeDTO = listEmployee.stream().map(employee -> new EmployeeDTO(employee)).collect(Collectors.toList());
    List<EmployeeDTO> emprloyeeDTO = listEmployee.stream().map(EmployeeDTO::new).collect(Collectors.toList());
    return emprloyeeDTO;
  }

  @Transactional(readOnly = true)
  public Page<EmployeeDTO> findAllPaged(Pageable pageRequest){
    Page<Employee> pageEmployee = employeeRepository.findAll(pageRequest);
    return pageEmployee.map(EmployeeDTO::new);
  }

  @Transactional
  public EmployeeDTO insert(EmployeeRequestDTO employeeRequestDTO){

    Employee employee = new Employee();
    employee.setId(null);
    employee.setName(employeeRequestDTO.getName());
    employee.setEmail(employeeRequestDTO.getEmail());
    employee.setDepartment(new Department(employeeRequestDTO.getDepartmentId(), null));

    Employee result = employeeRepository.save(employee);

    return new EmployeeDTO(result);
  }

}
