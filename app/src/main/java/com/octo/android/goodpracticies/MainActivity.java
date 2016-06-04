package com.octo.android.goodpracticies;


import android.app.Activity;
import android.content.Intent;
import com.octo.android.goodpracticies.actitvityWithLibraries.EmployeesWLActivity;
import com.octo.android.goodpracticies.actitvityWithoutLibraries.EmployeesWOLActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.withoutdependecies)
    public void clickButtonWithoutDependencies() {
        Intent i = new Intent(this, EmployeesWLActivity.class);
        startActivity(i);
    }


    @OnClick(R.id.withdagger)
    public void clickButtonWithDependencies() {
        Intent i = new Intent(this, EmployeesWOLActivity.class);
        startActivity(i);
    }
}
