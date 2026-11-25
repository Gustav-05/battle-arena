package main;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MenuService {

    public void menu() {
        System.out.println("Välkommen till Battle Arena");
        System.out.println("---------------------------");

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

    public Character selectCharacter() {
        Scanner scanner = new Scanner(System.in);

        Character[] characters = getCharacter();
        int choiceCharacter = 0;

        while (choiceCharacter < 1 || choiceCharacter > characters.length) {
            System.out.println("Välj en karaktär (1-" + characters.length + ")");

            try {
                choiceCharacter = scanner.nextInt();
                if (choiceCharacter < 1 || choiceCharacter > characters.length) {
                    System.out.println("Ogiltigt val, försök igen");
                }
            }catch (InputMismatchException e) {
                System.out.println("Du måste ange en siffra");
                scanner.nextLine();
            }
        }


        return characters[choiceCharacter - 1];

    }

    public Character showChosenCharacter() {

        Character chosenCharacter = selectCharacter();

        System.out.println("Vald karaktär: " + chosenCharacter.getName() + " " + chosenCharacter.getHp() + " hp");

        return chosenCharacter;


    }

    public Character getRandomCharacter() {
        Character[] characters = getCharacter();

        Random randomCharacter = new Random();
        int randomIndex = randomCharacter.nextInt(characters.length);

        return characters[randomIndex];
    }

    public void showRandomCharacter(String computerName) {

        System.out.println("Datorns val: " + computerName);
    }

    public void showCharacterChoices(String name) {

        System.out.println(name + " val möjligheter");


        int count = 0;
        for (Action action : Action.values()) {
            count += 1;
            System.out.println(count + ": " + action.getDisplayName());
        }

    }

    public void showStartBattle() {
        System.out.println("\nBattle arena har startat");
    }
}
