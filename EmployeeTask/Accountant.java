package EmployeeTask;

public class Accountant extends Employee {
    char gruppa;

    public Accountant(String surname, String gender, int age, int salary, char gruppa) {
        super(surname, gender, age, salary);
        this.gruppa = gruppa;
    }

    public char getGruppa() {
        return gruppa;
    }

    public void setGruppa(char gruppa) {
        this.gruppa = gruppa;
    }

    @Override
    public void show() {
        System.out.printf("%s;%s;%d;%d;%s;%c\n", getSurname() + ";" + getGender() + ":" + getAge() + ";" + getSalary() + ";" + getGruppa());
    }

}

