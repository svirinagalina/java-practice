package UniversalStack;

class Student {
    private String surname;
    private double averageMark;
    private int age;

    public Student(String surname, double averageMark, int age) {
        this.surname = surname;
        this.averageMark = averageMark;
        this.age = age;
    }

    @Override
    public String toString() {
        return surname + ";" + averageMark + ";" + age;
    }
    //put your code here
}
