package com.octo.android.goodpracticies.manager;

import com.octo.android.goodpracticies.model.Employee;
import com.octo.android.goodpracticies.network.event.MyEmployeesEvent;
import com.octo.android.goodpracticies.network.service.IEmployeeService;
import android.util.Log;
import com.squareup.otto.Bus;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by madaaflak on 12/01/2016.
 */


@Singleton
public class EmployeeManager {

    IEmployeeService service;
    Bus bus;

    @Inject
    public EmployeeManager(IEmployeeService service, Bus bus) {
        this.service = service;
        this.bus = bus;
    }

    public void getEmployees() {
        service.getEmployees(new Callback<List<Employee>>() {
            @Override
            public void success(List<Employee> employees, Response response) {
                Log.d("sucess", employees.toString());
                bus.post(new MyEmployeesEvent(employees));
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("error", error.getUrl());
            }
        });


        service.getEmployee("ok", new Callback<Employee>() {
            @Override
            public void success(Employee employee, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

//    public void getEmployees(final EmployeeCallback callback) {
//        service.getEmployees(new Callback<List<Employee>>() {
//            @Override
//            public void success(List<Employee> employees, Response response) {
//                Log.d("sucess", employees.toString());
//                callback.onSuccess(employees);
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Log.d("error", error.getUrl());
//            }
//        });
//    }

    public interface EmployeeCallback {
        void onSuccess(List<Employee> employees);
    }
}
