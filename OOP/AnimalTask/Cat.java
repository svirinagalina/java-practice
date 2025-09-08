public class Cat extends Pet {
    private String color;

    public Cat(String nickname, int age, String color) {
        super(nickname, age);
        this.color = color;
    }

    @Override
    public String toString() {
        return getNickname() + ";" + getAge() + ";" + color;
    }

    @Override
    public void getNoise() {
        System.out.println("Мяу-мяу!");
    }


}