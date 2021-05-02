package com.example.hr.application;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

import java.util.Optional;

public interface HrApplication {
    Employee hireEmployee(Employee employee);
    Optional<Employee> fireEmployee(TcKimlikNo kimlikNo);
}
