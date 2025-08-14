package learners;

class SchoolBoy extends Learner {
private String school;
private String grade;

public SchoolBoy(String surname, int mark1, int mark2, String school, String grade) {
    super(surname, mark1, mark2);
    this.school = school;
    this.grade = grade;
    }
    @Override
    public int holidays() {
        return 124;
    }

    @Override
    public String toString() {
        return getSurname() + ";" + getMark1() + ";" + getMark2() + ";" + school + ";" + grade;
    }

}
