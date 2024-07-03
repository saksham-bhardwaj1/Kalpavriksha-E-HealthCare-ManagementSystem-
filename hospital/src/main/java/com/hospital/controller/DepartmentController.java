package com.hospital.controller;

import com.hospital.model.Department;
import com.hospital.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @GetMapping
  public List<Department> getAllDepartments() {
    return departmentService.getAllDepartments();
  }

  @PostMapping
  public Department createDepartment(@RequestBody Department department) {
    return departmentService.createDepartment(department);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
    Optional<Department> department = departmentService.getDepartmentById(id);
    return department.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) throws Exception {
    Department updatedDepartment = departmentService.updateDepartment(id, departmentDetails);
    return ResponseEntity.ok(updatedDepartment);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) throws Exception {
    departmentService.deleteDepartment(id);
    return ResponseEntity.noContent().build();
  }
}
