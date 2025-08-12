package EmployeesTask;

public class Programmer extends Employees {
    private String status;
    private String specialization;

    public Programmer(String surname, String gender, int age, int salary, String status, String specialization) {
        super(surname, gender, age, salary);
        this.status = status;
        this.specialization = specialization;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialization() {
            return getSpecialization();
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    @Override
    public void show() {
        System.out.printf("%s;%s;%d;%d;%s\n", getSurname(), getGender(), getAge(), getSalary(), status);
    }
}
