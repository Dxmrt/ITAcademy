package TascaS1_01.N1.N5.N1.N5_N1exercici5;

import java.io.Serializable;

public class Player implements Serializable {

    private final String name;
    private final int age;

    public Player(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
