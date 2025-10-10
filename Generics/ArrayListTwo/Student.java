package ArrayListTwo;

public class Student {

    private String surname;
    private double avg;
    private int age;

    public Student (String surname, double avg, int age) {
        this.surname = surname;
        this.avg = avg;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
this.surname = surname;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

@Override
        public String toString() {
        return surname + ";" + avg + ";" + age;
}

}
