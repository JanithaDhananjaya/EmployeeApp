package lk.iit.mobile.employeeapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import lk.iit.mobile.employeeapp.model.Employee;

public class EmployeeData extends SQLiteOpenHelper {

    private static final String DB_NAME = "company";
    private static final String TABLE_NAME = "employee";
    private static final int DB_VERSION = 1;

    private Context context;
    private SQLiteDatabase databse;

    public EmployeeData(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "empName TEXT NOT NULL, " +
                "empAddress TEXT NOT NULL, " +
                "empAge TEXT NOT NULL, " +
                "empPosition TEXT NOT NULL" +
                ")");

        Log.i("Database", "Table created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addNewEmployee(Employee newEmployee) {
        databse = getWritableDatabase();
        String query = "INSERT INTO " + TABLE_NAME + " (empName, empAddress, empAge, empPosition) VALUES (?,?,?,?)";
        databse.execSQL(query, new String[]{newEmployee.getEmpName(), newEmployee.getEmpAddress(), newEmployee.getEmpAge(), newEmployee.getPosition()});
        databse.close();
        return true;
    }

    public ArrayList<Employee> getAllEmployeeDetails() {
        databse = getReadableDatabase();
        Cursor cursor = databse.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Employee> employeeList = new ArrayList<>();

        while (cursor.moveToNext()) {
            employeeList.add(
                    new Employee(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4)
                    ));
        }

        Log.i("All Emp", employeeList.toString());
        return employeeList;
    }
}
