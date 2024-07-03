package com.hospital.service.impl;

import com.hospital.model.Department;
import com.hospital.repository.DepartmentRepository;
import com.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Override
  public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }

  @Override
  public Department createDepartment(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public Optional<Department> getDepartmentById(Long id) {
    return departmentRepository.findById(id);
  }

  @Override
  public Department updateDepartment(Long id, Department departmentDetails) throws Exception {
    Department department = departmentRepository.findById(id)
      .orElseThrow(() -> new Exception("Department not found with id: " + id));

    department.setName(departmentDetails.getName());
    department.setLocation(departmentDetails.getLocation());

    return departmentRepository.save(department);
  }

  @Override
  public void deleteDepartment(Long id) throws Exception {
    Department department = departmentRepository.findById(id)
      .orElseThrow(() -> new Exception("Department not found with id: " + id));

    departmentRepository.delete(department);
  }
}
