package learners;

public class Student extends Learner {
    private String university;
    private String group;

    private static int baseScholarship;

    public static void setBaseScholarship(int base) {
        baseScholarship = base;
    }

    public Student(String surname, int mark1, int mark2, String university, String group) {
        super(surname, mark1, mark2);
        this.university = university;
        this.group = group;
    }

    @Override
    public int holidays() {
        return 74;
    }

    public int calculateScholarship() {
        double avg = averageGrade();
        if (avg >= 9) {
            return (int) (baseScholarship * 1.6);
        } else if (avg >= 8) {
            return (int) (baseScholarship * 1.4);
        } else if (avg >= 6) {
            return (int) (baseScholarship * 1.2);
        } else if (avg >= 5) {
            return baseScholarship;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        // CSV: фамилия;оценка1;оценка2;вуз;группа
        return getSurname() + ";" + getMark1() + ";" + getMark2() + ";" + university + ";" + group;
    }
}
