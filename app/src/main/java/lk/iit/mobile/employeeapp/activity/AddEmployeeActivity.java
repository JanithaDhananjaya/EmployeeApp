package lk.iit.mobile.employeeapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import lk.iit.mobile.employeeapp.R;
import lk.iit.mobile.employeeapp.data.EmployeeData;
import lk.iit.mobile.employeeapp.model.Employee;

public class AddEmployeeActivity extends AppCompatActivity {

    private EditText txt_name;
    private EditText txt_address;
    private EditText txt_age;
    private EditText txt_position;

    private EmployeeData employeeData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        txt_name = findViewById(R.id.txt_name);
        txt_address = findViewById(R.id.txt_address);
        txt_age = findViewById(R.id.txt_age);
        txt_position = findViewById(R.id.txt_position);

        employeeData = new EmployeeData(this);
        getAllEmployeeDetails();
    }

    public void saveNewEmployee(View view) {

        String empName = txt_name.getText().toString();
        String empAddress = txt_address.getText().toString();
        String empAge = txt_age.getText().toString();
        String empPosition = txt_position.getText().toString();

        boolean result = employeeData.addNewEmployee(new Employee(empName, empAddress, empAge, empPosition));

        if (result) {
            Toast toast = Toast.makeText(getApplicationContext(), "Save Employee!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void getAllEmployeeDetails(){
        List<Employee> allEmployeeDetails = employeeData.getAllEmployeeDetails();
        Log.i("Details ", allEmployeeDetails.toString());
    }
}