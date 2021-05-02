package com.example.hr.repository;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

import java.util.Optional;

public interface EmployeeRepository {

    boolean existsByIdentity(TcKimlikNo identity);

    Employee persist(Employee employee);

    Optional<Employee> removeByIdentity(TcKimlikNo kimlikNo);
}
