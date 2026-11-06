package main;

import java.util.Random;

public class Warrior extends Character {


    private static final int WARRIOR_MAX_HP = 130;
    private static final int WARRIOR_MIN_DAMAGE = 5;
    private static final int WARRIOR_MAX_DAMAGE = 15;

    public Warrior(String name) {
        super(name, WARRIOR_MAX_HP, WARRIOR_MIN_DAMAGE, WARRIOR_MAX_DAMAGE);

    }


    public int defend(int incomingDamage) {
        Random randomDefend = new Random();

        int reduction = randomDefend.nextInt(50, 101);

        return incomingDamage * (100 - reduction) / 100;
    }

}
