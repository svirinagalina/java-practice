package EmployeeTask;

public class Employee {
    private String surname;
    private String gender;
    private int age;
    private int salary;

    public Employee(String surname, String gender, int age, int salary) {

        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void show() {
        System.out.printf("%s;%s;%d;%d\n", surname, gender, age, salary);
    }

    boolean isPensioner() {

        return (gender.equals("female") && age >= 58) || (gender.equals("male") && age >= 63);
    }

    void changeSalary(double koef) {
        salary = (int) (salary * koef);
    }


}