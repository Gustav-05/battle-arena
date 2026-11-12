package main;

public class Main {

    public static void main(String[] args) {

        MenuService menuService = new MenuService();
        BattleService battleService = new BattleService();

        menuService.menu();
        menuService.showCharacters();
        Character player = menuService.showChosenCharacter();
        Character computer = menuService.getRandomCharacter();
        String computerName = computer.getName();
        menuService.showRandomCharacter(computerName);
        String playerName = player.getName();

        menuService.showCharacterChoices(playerName);

    }
}
