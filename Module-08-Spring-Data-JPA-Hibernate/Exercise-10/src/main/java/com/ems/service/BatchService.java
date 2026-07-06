package com.ems.service;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.repository.DepartmentRepository;
import com.ems.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private static final int BATCH_SIZE = 20;

    public BatchService(EmployeeRepository employeeRepository,
                        DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public List<Employee> batchInsertEmployees(int count) {
        Department dept = departmentRepository.findByName("Engineering")
                .orElseGet(() -> departmentRepository.save(new Department("Engineering")));

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Employee emp = new Employee("Employee-" + i, "emp" + i + "@company.com");
            emp.setDepartment(dept);
            entityManager.persist(emp);

            if (i > 0 && i % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();

        return employeeRepository.findByDepartmentId(dept.getId());
    }

    @Transactional
    public int batchUpdateSalaries(String namePattern, String newEmailSuffix) {
        List<Employee> employees = employeeRepository.findAll();
        int updated = 0;
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            if (emp.getName().contains(namePattern)) {
                emp.setEmail(emp.getName().toLowerCase() + newEmailSuffix);
                updated++;
            }
            if (i > 0 && i % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        return updated;
    }
}
