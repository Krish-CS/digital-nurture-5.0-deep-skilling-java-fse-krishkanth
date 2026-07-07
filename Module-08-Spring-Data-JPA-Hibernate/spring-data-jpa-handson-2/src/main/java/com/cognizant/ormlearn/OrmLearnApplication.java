package com.cognizant.ormlearn;
import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.repository.*;
import com.cognizant.ormlearn.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        
        CountryRepository countryRepo = context.getBean(CountryRepository.class);
        StockRepository stockRepo = context.getBean(StockRepository.class);
        
        LOGGER.info("Starting Query Methods & Relationship Tests");
        
        // Country queries
        LOGGER.debug("Countries containing 'ou': {}", countryRepo.findByNameContainingOrderByNameAsc("ou"));
        LOGGER.debug("Countries starting with 'Z': {}", countryRepo.findByNameStartingWith("Z"));
        
        // Stock queries
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LOGGER.debug("FB Sep 2019: {}", stockRepo.findByCodeAndDateBetween("FB", sdf.parse("2019-09-01"), sdf.parse("2019-09-30")));
        LOGGER.debug("Google > 1250: {}", stockRepo.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250")));
        LOGGER.debug("Top 3 volume: {}", stockRepo.findTop3ByOrderByVolumeDesc());
        LOGGER.debug("Lowest 3 NFLX: {}", stockRepo.findTop3ByCodeOrderByCloseAsc("NFLX"));
        
        // Relationships tests
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
        testGetDepartment();
        testAddSkillToEmployee();
    }
    
    private static void testGetEmployee() {
        LOGGER.info("Start testGetEmployee");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkillList());
        LOGGER.info("End testGetEmployee");
    }
    
    private static void testAddEmployee() {
        LOGGER.info("Start testAddEmployee");
        Employee employee = new Employee();
        employee.setName("New Hired");
        employee.setSalary(45000.0);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());
        employee.setDepartment(departmentService.get(1));
        employee.setSkillList(new HashSet<>());
        employeeService.save(employee);
        LOGGER.debug("Added Employee: {}", employee);
        LOGGER.info("End testAddEmployee");
    }
    
    private static void testUpdateEmployee() {
        LOGGER.info("Start testUpdateEmployee");
        Employee employee = employeeService.get(1);
        employee.setDepartment(departmentService.get(2));
        employeeService.save(employee);
        LOGGER.debug("Updated Employee: {}", employee);
        LOGGER.info("End testUpdateEmployee");
    }
    
    private static void testGetDepartment() {
        LOGGER.info("Start testGetDepartment");
        Department department = departmentService.get(1);
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employees: {}", department.getEmployeeList());
        LOGGER.info("End testGetDepartment");
    }
    
    private static void testAddSkillToEmployee() {
        LOGGER.info("Start testAddSkillToEmployee");
        Employee employee = employeeService.get(1);
        Skill skill = skillService.get(2);
        employee.getSkillList().add(skill);
        employeeService.save(employee);
        LOGGER.debug("Employee skills after addition: {}", employee.getSkillList());
        LOGGER.info("End testAddSkillToEmployee");
    }
}