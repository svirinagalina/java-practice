public class Dog extends Pet {
    private String breed;

    public Dog(String nickname, int age, String breed) {
        super(nickname, age);
        this.breed = breed;
    }

    @Override
    public void getNoise() {
        System.out.println("гав-гав");
    }

    @Override
    public String toString() {
        return getNickname() + ";" + getAge() + ";" + breed;
    }
}
