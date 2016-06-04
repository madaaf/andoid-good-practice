package com.octo.android.goodpracticies.network.event;

import com.octo.android.goodpracticies.model.Employee;

import java.util.List;

/**
 * Created by madaaflak on 15/01/2016.
 */
public class MyEmployeesEvent {

    private List<Employee> employees;

    public MyEmployeesEvent(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
