package main;

public class Main {

    public static void main(String[] args) {

        MenuService menuService = new MenuService();
        BattleService battleService = new BattleService();

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
        }




    }
}
