package main;

import java.util.Scanner;

public class MenuService {

    public void menu() {
        System.out.println("Välkommen till Battle Arena");
        System.out.println("---------------------------");
        System.out.println("Välj din karaktär ");
    }

    public static Character[] getCharacter() {
        Character[] characters = {
                new Warrior(Warrior.WARRIOR_NAME),
                new Mage(Mage.MAGE_NAME),
                new Archer(Archer.ARCHER_NAME)
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

    public Character showChosenCharacter() {

        String chosenCharacter = selectCharacter();

        for (Character character: getCharacter()) {

            if (chosenCharacter.equalsIgnoreCase(character.getName())) {
                System.out.println("Vald karaktär: " + character.getName());

                return character;

            }
        }

        System.out.println("Du valde ingen av karaktärerna");
        return null;
    }
}
