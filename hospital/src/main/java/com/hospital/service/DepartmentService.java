package com.hospital.service;

import com.hospital.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
  List<Department> getAllDepartments();
  Department createDepartment(Department department);
  Optional<Department> getDepartmentById(Long id);
  Department updateDepartment(Long id, Department departmentDetails) throws Exception;
  void deleteDepartment(Long id) throws Exception;
}
