package lk.iit.mobile.employeeapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import lk.iit.mobile.employeeapp.R;
import lk.iit.mobile.employeeapp.adaptor.CustomAdaptor;
import lk.iit.mobile.employeeapp.data.EmployeeData;
import lk.iit.mobile.employeeapp.model.Employee;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        final ArrayList<Employee> allEmployeeDetails = new EmployeeData(this).getAllEmployeeDetails();

        CustomAdaptor customAdaptor = new CustomAdaptor(this, R.layout.row_item, allEmployeeDetails);

        listView.setAdapter(customAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("fsjf", "fljskhb");
                Toast.makeText(MainActivity.this, allEmployeeDetails.get(position).getPosition(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void addNewOne(View view) {
        Intent intent = new Intent(getApplicationContext(), AddEmployeeActivity.class);
        view.getContext().startActivity(intent);
    }

}