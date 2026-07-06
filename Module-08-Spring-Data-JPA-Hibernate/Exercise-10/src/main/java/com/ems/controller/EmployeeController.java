package com.ems.controller;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.repository.DepartmentRepository;
import com.ems.repository.EmployeeRepository;
import com.ems.service.BatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final BatchService batchService;

    public EmployeeController(EmployeeRepository employeeRepository,
                              DepartmentRepository departmentRepository,
                              BatchService batchService) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.batchService = batchService;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentRepository.save(department));
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        if (employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
            employee.setDepartment(dept);
        }
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @PostMapping("/employees/batch/{count}")
    public ResponseEntity<Map<String, Object>> batchInsert(@PathVariable int count) {
        List<Employee> employees = batchService.batchInsertEmployees(count);
        return ResponseEntity.ok(Map.of(
            "message", "Batch insert completed",
            "count", employees.size()
        ));
    }

    @PutMapping("/employees/batch/update")
    public ResponseEntity<Map<String, Object>> batchUpdate(
            @RequestParam(defaultValue = "Employee") String pattern,
            @RequestParam(defaultValue = "@updated.com") String suffix) {
        int updated = batchService.batchUpdateSalaries(pattern, suffix);
        return ResponseEntity.ok(Map.of(
            "message", "Batch update completed",
            "updated", updated
        ));
    }
}
