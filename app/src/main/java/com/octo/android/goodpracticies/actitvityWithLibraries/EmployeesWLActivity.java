package com.octo.android.goodpracticies.actitvityWithLibraries;

import com.octo.android.goodpracticies.GoodPracticiesApplication;
import com.octo.android.goodpracticies.manager.EmployeeManager;
import com.octo.android.goodpracticies.R;
import com.octo.android.goodpracticies.model.Employee;
import com.octo.android.goodpracticies.network.event.MyEmployeesEvent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by madaaflak on 12/01/2016.
 */
public class EmployeesWLActivity extends AppCompatActivity {

    @Bind(R.id.nothing_listview) ListView listView;
    @Bind(R.id.test) TextView text;
    @Inject EmployeeWLAdapter employeeWLAdapter;
    @Inject EmployeeManager manager;
    @Inject Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ButterKnife.bind(this);
        text.setText("Peoples");
        GoodPracticiesApplication.app().getComponent().inject(this);
        listView.setAdapter(employeeWLAdapter);
    }

    /**  It is a good practice to register and unregister in onStart and onStop methods */
    @Override
    public void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    public void onResume() {
        super.onResume();
//        manager.getEmployees(new MyEmployeeCallbak());
        manager.getEmployees();
    }


    @Override
    public void onStop() {
        super.onStop();
        bus.unregister(this);
    }

    /**  I Use EventBus to avoid getting data on UIThread */

    @Subscribe
    public void onEvent(MyEmployeesEvent employeesEvent) {
        employeeWLAdapter.clear();
        employeeWLAdapter.addAll(employeesEvent.getEmployees());

    }


//    private class MyEmployeeCallback implements EmployeeManager.EmployeeCallback {
//        @Override
//        public void onSuccess(List<Employee> employees) {
//
//        }
//    }
}
