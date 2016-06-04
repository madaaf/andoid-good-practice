package com.octo.android.goodpracticies.actitvityWithoutLibraries;

import android.app.Activity;
import com.octo.android.goodpracticies.BuildConfig;
import com.octo.android.goodpracticies.R;
import com.octo.android.goodpracticies.model.Employee;
import com.octo.android.goodpracticies.network.service.IEmployeeService;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by madaaflak on 12/01/2016.
 */

public class EmployeesWOLActivity extends Activity {

    private ListView listView;
    private EmployeeWOLAdapter employeeWOLAdapter;
    private RestAdapter restAdapter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listView = (ListView) findViewById(R.id.nothing_listview);
        textView = (TextView) findViewById(R.id.test);

        textView.setText("Peoples");
        employeeWOLAdapter = new EmployeeWOLAdapter(this);
        listView.setAdapter(employeeWOLAdapter);
        restAdapter = new RestAdapter.Builder().setEndpoint(BuildConfig.rootUrl).build();

        IEmployeeService service = restAdapter.create(IEmployeeService.class);
        service.getEmployees(new Callback<List<Employee>>() {
            @Override
            public void success(List<Employee> employees, Response response) {
                employeeWOLAdapter.addAll(employees);
                employeeWOLAdapter.notifyDataSetChanged();
                listView.setSelection(employeeWOLAdapter.getCount() - 1);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("OK", error.getUrl());
            }
        });

    }



}
