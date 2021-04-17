package lk.iit.mobile.employeeapp.model;

public class Employee {
    private int empId;
    private String empName;
    private String empAddress;
    private String empAge;
    private String position;

    public Employee() {
    }

    public Employee(int empId, String empName, String empAddress, String empAge, String position) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empAge = empAge;
        this.position = position;
    }

    public Employee(String empName, String empAddress, String empAge, String position) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empAge = empAge;
        this.position = position;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpAge() {
        return empAge;
    }

    public void setEmpAge(String empAge) {
        this.empAge = empAge;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empAge=" + empAge +
                ", position='" + position + '\'' +
                '}';
    }
}
