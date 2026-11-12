package main;

public class BattleService {

    public void attack(Character attacker, Character defender) {
        int damage = attacker.getRandomDamage();

        if (defender instanceof Warrior warrior && warrior.isDefending()) {
            damage = warrior.defend(damage);
            warrior.setDefending(false);
        }

        System.out.println(attacker.getName() + " attackerar " + defender.getName());
        System.out.println(attacker.getName() + " skadade " + damage);

        defender.takeDamage(damage);
    }

    public void doubleShot(Archer archer, Character defender) {
        attack(archer, defender);
        attack(archer, defender);
    }

    public void performAction(Action action, Character attacker, Character defender) {

        switch (action) {

            case ATTACK:
                attack(attacker, defender);
                break;

            case SPECIAL_ABILITY:
                attacker.useSpecialAbility();
                break;
        }
    }

}
