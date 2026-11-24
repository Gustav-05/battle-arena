package main;

import main.serverclient.Client;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MenuService menuService = new MenuService();
        BattleService battleService = new BattleService();
        Client client = new Client();

        while (true) {
            menuService.menu();
            menuService.showCharacters();
            Character player = menuService.showChosenCharacter();
            Character computer = menuService.getRandomCharacter();
            String computerName = computer.getName();
            menuService.showRandomCharacter(computerName);
            String playerName = player.getName();

            menuService.showStartBattle();

            while (!battleService.isGameOver(player, computer)) {
                menuService.showCharacterChoices(playerName);

                Action playerAction = battleService.selectAbility();
                battleService.performAction(playerAction, player, computer);

                Action computerAction = battleService.getRandomAction();
                battleService.performAction(computerAction, computer, player);


            }

            battleService.showGameOver(player, computer);

            Character result = battleService.winner(player, computer);
            client.sendMatchData(player, computer, result);


        }

    }

}
