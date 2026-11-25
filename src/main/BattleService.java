package main;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BattleService {

    public void attack(Character attacker, Character defender) {
        int damage = attacker.getRandomDamage();

        if (defender instanceof Defendable defendable && defendable.isDefending()) {
            damage = defendable.defend(damage);
            defendable.setDefending(false);
        }

        System.out.println("\n" + attacker.getName() + " attackerar " + defender.getName());
        System.out.println(attacker.getName() + " skadade " + damage);


        defender.takeDamage(damage);

        System.out.println(defender.getName() + " " + defender.getHp() + " hp");
    }

    public Action selectAbility() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                int choiceAbility = scanner.nextInt();

                if (choiceAbility == 1) {
                    return Action.ATTACK;
                } else if (choiceAbility == 2) {
                    return Action.SPECIAL_ABILITY;
                }

                System.out.println("Felaktigt val, välj 1 eller 2");
            }catch (InputMismatchException e) {
                System.out.println("Du måste ange en siffra");
                scanner.nextLine();
            }

        }
    }

    public void performAction(Action action, Character attacker, Character defender) {

        switch (action) {

            case ATTACK:
                attack(attacker, defender);
                break;

            case SPECIAL_ABILITY:
                attacker.useSpecialAbility(defender);
                break;
        }
    }

    public Action getRandomAction() {
        Random random = new Random();

        if (random.nextBoolean()) {
            return Action.ATTACK;
        }
        else {
            return Action.SPECIAL_ABILITY;
        }
    }

    public boolean isGameOver(Character player, Character computer) {

        return player.getHp() <= 0 || computer.getHp() <= 0;
    }

    public void showGameOver(Character player, Character computer) {
        if (player.getHp() <= 0) {
            System.out.println("Spelet över");
            System.out.println(computer.getName() + " vann!");
        } else {
            System.out.println("Spelet över");
            System.out.println(player.getName() + " vann!");
        }
    }

    public Character winner(Character player, Character computer) {
        if (player.getHp() <= 0) {
            return computer;
        }
        else {
            return player;
        }

    }

}
