package main;

import java.util.Random;

public class Warrior extends Character {

    public static final String WARRIOR_NAME = "Aragorn";
    private static final int WARRIOR_MAX_HP = 130;
    private static final int WARRIOR_MIN_DAMAGE = 5;
    private static final int WARRIOR_MAX_DAMAGE = 15;
    private static final int WARRIOR_MIN_DEFEND = 50;
    private static final int WARRIOR_MAX_DEFEND = 101;
    private boolean defending = false;

    public Warrior(String name) {
        super(name, WARRIOR_MAX_HP, WARRIOR_MIN_DAMAGE, WARRIOR_MAX_DAMAGE);

    }

    public boolean isDefending() {
        return defending;
    }

    public void setDefending(boolean defending) {
        this.defending = defending;
    }

    @Override
    public void useSpecialAbility() {
        setDefending(true);
    }

    public int defend(int incomingDamage) {
        Random randomDefend = new Random();

        int reduction = randomDefend.nextInt(WARRIOR_MIN_DEFEND, WARRIOR_MAX_DEFEND);
        return incomingDamage * (100 - reduction) / 100;
    }

}
