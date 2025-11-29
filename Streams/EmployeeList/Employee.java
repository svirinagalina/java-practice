package Streams.EmployeeList;

public class Employee {
    private String lastName;
    private String department;
    private double salary;

    public Employee(String lastName, String department, double salary) {
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Main{" +
                "name='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
