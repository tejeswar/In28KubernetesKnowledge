package com.logicbig.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import java.io.Serializable;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class EmployeeDetails implements Serializable {
    private Employee employee;
    private int lastYearSalary;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getLastYearSalary() {
        return lastYearSalary;
    }

    public void setLastYearSalary(int lastYearSalary) {
        this.lastYearSalary = lastYearSalary;
    }
}