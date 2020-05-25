package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.inject.Provider;

@Service
public class AppService {
    @Autowired
    private Provider<EmployeeDetails> employeeDetailsProvider;

    public void findEmployeeSalary() {
        EmployeeDetails employeeDetails = employeeDetailsProvider.get();
        Employee employee = employeeDetails.getEmployee();
        employeeDetails.setLastYearSalary(getEmployeeSalary(employee));
    }

    private int getEmployeeSalary(Employee employee) {
        //todo: call backend instead
        int salary = 100 * RandomUtil.getInt(30, 100);
        return salary;
    }
}