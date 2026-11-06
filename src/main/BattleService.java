package main;

public class BattleService {


    public void attack(Character attacker, Character defender) {
        int damage = attacker.getRandomDamage();
        defender.takeDamage(damage);
    }

    public void defend(Warrior warrior, int incomingDamage) {
        int reducedDamage = warrior.defend(incomingDamage);
        warrior.takeDamage(reducedDamage);
    }

    public void heal(Mage mage) {
        int healAmount = mage.heal();
        mage.setHp(mage.getHp() + healAmount);

        System.out.println(mage.getName() + " " + healAmount);

    }

    public void doubleShot(Archer archer, Character defender) {
        attack(archer, defender);
        attack(archer, defender);
    }
}
