package main;

public class BattleService {


    public void attack(Character attacker, Character defender) {
        int damage = attacker.getRandomDamage();
        defender.takeDamage(damage);
    }
}
