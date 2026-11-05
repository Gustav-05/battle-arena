package main;

public class Warrior extends Character {


    private static final int WARRIOR_MAX_HP = 130;
    private static final int WARRIOR_MIN_DAMAGE = 5;
    private static final int WARRIOR_MAX_DAMAGE = 15;

    public Warrior(String name) {
        super(name, WARRIOR_MAX_HP, WARRIOR_MIN_DAMAGE, WARRIOR_MAX_DAMAGE);



    }

}
