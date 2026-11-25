package main;

import java.util.Random;


public  abstract class   Character {

    private String name;
    private int hp;
    private int minDamage;
    private int maxDamage;
    private final int MINIMUM_HP = 0;
    private static final Random randomDamage = new Random();

    public Character(String name, int hp, int minDamage, int maxDamage) {
        this.name = name;
        this.hp = hp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getRandomDamage() {
        return randomDamage.nextInt(getMinDamage(), getMaxDamage() + 1);
    }


    public void takeDamage(int damage) {
        hp = hp - damage;
        if (hp < MINIMUM_HP) {
            hp = MINIMUM_HP;
        }
    }

    public abstract void useSpecialAbility(Character defender);

}
