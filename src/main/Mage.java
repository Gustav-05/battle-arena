package main;

import java.util.Random;

public class Mage extends Character {

    public static final String MAGE_NAME = "Gandalf";
    private static final int MAGE_MAX_HP = 90;
    private static final int MAGE_MIN_DAMAGE = 10;
    private static final int MAGE_MAX_DAMAGE = 20;
    private static final int MAGE_MIN_HEAL = 15;
    private static final int MAGE_MAX_HEAL = 26;

    public Mage(String name) {
        super(name, MAGE_MAX_HP, MAGE_MIN_DAMAGE, MAGE_MAX_DAMAGE);
    }

    @Override
    public void useSpecialAbility(Character defender) {
        int healAmount = heal();
        setHp(Math.min(getHp() + healAmount, MAGE_MAX_HP));

    }

    public int heal() {
        Random randomHeal = new Random();

        int healAmount = randomHeal.nextInt(MAGE_MIN_HEAL, MAGE_MAX_HEAL);
        return healAmount;
    }
}
