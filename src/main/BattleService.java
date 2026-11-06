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
}
