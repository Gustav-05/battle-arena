package main;

import java.util.Random;

public class Character {

    private String name;
    private int hp;
    private int minDamage;
    private int maxDamage;

    public Character(String name, int hp, int minDamage, int maxDamage) {
        this.name = name;
        this.hp = hp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Random randomDamage = new Random();
        return randomDamage.nextInt(getMinDamage(), getMaxDamage() + 1);
    }


    public void takeDamage(int damage) {
        hp = hp - damage;
        if (hp < 0) {
            hp = 0;
        }
    }
}
