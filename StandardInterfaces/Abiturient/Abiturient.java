package StandardInterfaces.Abiturient;

public class Abiturient {
    private String surname;
    private String name;
    private int mark1;
    private int mark2;
    private int mark3;

    public double average() {
        return (mark1 + mark2 + mark3) / 3.0;
    }

    public Abiturient(String surname, String name, int mark1, int mark2, int mark3) {
        this.surname = surname;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return surname + ";" + name + ";" + mark1 + ";" + mark2 + ";" + mark3 + ";" +
                String.format("%.1f",average());
    }

}
