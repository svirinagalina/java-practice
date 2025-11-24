package Streams.Dogs;

public class Dog {
    private String name;
    private String breed;
    private Collar collar;

    public Dog(String name, String breed, Collar collar) {
        this.name = name;
        this.breed = breed;
        this.collar = collar;
    }

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
        this.collar = null;
    }

    public String toString() {
        return (collar == null)
                ? name + ";" + breed + ";"
                : name + ";" + breed + ";" + collar.toString();

    }

    public Collar getCollar() {
        return collar;
    }
}

