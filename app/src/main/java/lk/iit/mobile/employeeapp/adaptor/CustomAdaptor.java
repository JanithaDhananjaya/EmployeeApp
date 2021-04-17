package lk.iit.mobile.employeeapp.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import lk.iit.mobile.employeeapp.R;
import lk.iit.mobile.employeeapp.model.Employee;

public class CustomAdaptor extends ArrayAdapter<Employee> {

    private Context mContext;
    private int resource;

    public CustomAdaptor(@NonNull Context context, int resource, @NonNull ArrayList<Employee> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        convertView = inflater.inflate(resource,parent,false);

       TextView empId = convertView.findViewById(R.id.empId);
       TextView empName = convertView.findViewById(R.id.name);
       TextView empAddress = convertView.findViewById(R.id.address);
       TextView empAge = convertView.findViewById(R.id.age);
       TextView empPosition = convertView.findViewById(R.id.position);

       empId.setText(String.valueOf(getItem(position).getEmpId()));
       empName.setText(getItem(position).getEmpName());
       empAddress.setText(getItem(position).getEmpAddress());
       empAge.setText(getItem(position).getEmpAge());
       empPosition.setText(getItem(position).getPosition());

       return convertView;
    }
}
