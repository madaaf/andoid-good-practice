package com.octo.android.goodpracticies.network.service;

import com.octo.android.goodpracticies.model.Employee;

import java.util.List;

import javax.inject.Singleton;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by madaaflak on 15/01/2016.
 */
@Singleton
public interface IEmployeeService {

    @GET("/employees")
    void getEmployees(Callback<List<Employee>> employeesCallback);

    @GET("/employee/{id}")
    void getEmployee(@Path("id") String id, Callback<Employee> employeeCallback);
}
