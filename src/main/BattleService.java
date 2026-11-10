package main;

import java.util.Scanner;

public class BattleService {

    public void menu() {
        System.out.println("Välkommen till Battle Arena");
        System.out.println("---------------------------");
        System.out.println("Välj din karaktär ");
    }

    public static Character[] getCharacter() {
        Character[] characters = {
                new Warrior("Aragorn"),
                new Mage("Gandalf"),
                new Archer("Legolas")
        };
        return characters;
    }

    public void showCharacters() {
        int counter = 0;
        for (Character character: getCharacter()) {
            counter += 1;
            System.out.println(counter + ": " + character.getName());

        }
    }

    public String selectCharacter() {
        Scanner scanner = new Scanner(System.in);
        String chooseCharacter = scanner.nextLine().trim();

        return chooseCharacter;
    }

    public boolean showChosenCharacter() {

        boolean found = false;

        for (Character character: getCharacter()) {

            if (selectCharacter().equalsIgnoreCase(character.getName())) {
                found = true;

                System.out.println("Vald karaktär: " + character.getName());

            }
        }

        if (!found) {
            System.out.println("Du skrev inte något av namnen");
        }

        return found;
    }



    public void attack(Character attacker, Character defender) {
        int damage = attacker.getRandomDamage();
        defender.takeDamage(damage);
        System.out.println(attacker + " attackerar " + defender);
        System.out.println(attacker + " skadade " + damage);
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
