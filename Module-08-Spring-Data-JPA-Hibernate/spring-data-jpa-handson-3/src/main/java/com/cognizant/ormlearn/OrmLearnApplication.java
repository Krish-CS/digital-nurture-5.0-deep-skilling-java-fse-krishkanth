package com.cognizant.ormlearn;
import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    
    private static EmployeeService employeeService;
    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        
        employeeService = context.getBean(EmployeeService.class);
        attemptService = context.getBean(AttemptService.class);
        
        LOGGER.info("Starting Advanced HQL, Native, and Quiz Query tests");
        
        testGetAllPermanentEmployees();
        testGetAttemptDetail();
        testGetAverageSalary();
        testGetAllEmployeesNative();
    }
    
    @Transactional
    public static void testGetAllPermanentEmployees() {
        LOGGER.info("Start testGetAllPermanentEmployees");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        for (Employee e : employees) {
            LOGGER.debug("Employee: {}, Dept: {}, Skills: {}", e.getName(), e.getDepartment().getName(), e.getSkillList());
        }
        LOGGER.info("End testGetAllPermanentEmployees");
    }
    
    @Transactional
    public static void testGetAttemptDetail() {
        LOGGER.info("Start testGetAttemptDetail");
        QuizAttempt attempt = attemptService.getAttempt(1, 1);
        LOGGER.debug("User: {}, Date: {}", attempt.getUser().getName(), attempt.getDate());
        
        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            LOGGER.debug("{}", aq.getQuestion().getText());
            int index = 1;
            for (AttemptOption ao : aq.getAttemptOptions()) {
                LOGGER.debug("  {}) {}      {}    {}", index++, ao.getOption().getText(), ao.getOption().getScore(), ao.isSelected());
            }
        }
        LOGGER.info("End testGetAttemptDetail");
    }
    
    private static void testGetAverageSalary() {
        LOGGER.info("Start testGetAverageSalary");
        double avgSalary = employeeService.getAverageSalary(1);
        LOGGER.debug("Average salary of Department 1 (IT): {}", avgSalary);
        LOGGER.info("End testGetAverageSalary");
    }
    
    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start testGetAllEmployeesNative");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("Employees Native query results size: {}", employees.size());
        LOGGER.info("End testGetAllEmployeesNative");
    }
}