
   package learners;

    abstract class Learner {
       private String surname;
       private int mark1;
       private int mark2;

        public Learner(String surname, int mark1, int mark2) {
            this.surname = surname;
            this.mark1 = mark1;
            this.mark2 = mark2;
        }
public String getSurname() {
            return surname;
}

public int getMark1() {
            return mark1;
}

public int getMark2() {
            return mark2;
}
public double averageGrade() {
            return (mark1 + mark2) / 2.0;
}

public abstract int holidays();

@Override
public abstract String toString();
}

