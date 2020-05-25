package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.inject.Provider;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private Provider<EmployeeDetails> employeeDetailsProvider;
    @Autowired
    AppService appService;

    @RequestMapping("/{id}")
    public String handler(@PathVariable("id") String employeeId) {
        employeeDetailsProvider.get().setEmployee(getEmployeeById(employeeId));
        appService.findEmployeeSalary();
        return "employee-page";
    }

    private Employee getEmployeeById(String employeeId) {
        //todo: call to backend instead
        Employee employee = new Employee(employeeId, RandomUtil.getFullName(),
                RandomUtil.getAnyOf("Admin", "IT", "Sales"));
        return employee;
    }
}