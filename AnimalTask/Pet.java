public abstract class Pet {
    private String nickname;
    private int age;

    public Pet() {

    }

    public Pet(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return nickname + ";" + age;
    }
public abstract void getNoise();

}

