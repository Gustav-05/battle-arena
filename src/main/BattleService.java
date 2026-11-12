package main;

import java.util.Scanner;

public class BattleService {

    public void attack(Character attacker, Character defender, int incomingDamage) {
        int damage = attacker.getRandomDamage();

        if (defender instanceof Warrior warrior && warrior.isDefending()) {
            damage = warrior.defend(incomingDamage);
            warrior.setDefending(false);
        }

        System.out.println(attacker.getName() + " attackerar " + defender.getName());
        System.out.println(attacker.getName() + " skadade " + damage);

        defender.takeDamage(damage);
    }

    public void defend(Warrior warrior) {
        warrior.setDefending(true);
    }

    public void heal(Mage mage) {
        int healAmount = mage.heal();
        mage.setHp(mage.getHp() + healAmount);

        System.out.println(mage.getName() + " " + healAmount);

    }

    public void doubleShot(Archer archer, Character defender, int incomingDamage) {
        attack(archer, defender, incomingDamage);
        attack(archer, defender, incomingDamage);
    }
}
