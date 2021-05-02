package com.example.hr.infrastructure;

import com.example.hr.events.EmployeeEvent;
import com.example.hr.events.EmployeeHiredEvent;

public interface EventPublisher {

    void publish(EmployeeEvent event);
}
