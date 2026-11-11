package main;

public class Main {

    public static void main(String[] args) {

        MenuService menuService = new MenuService();
        BattleService battleService = new BattleService();

        menuService.menu();
        menuService.showCharacters();
        Character player = menuService.showChosenCharacter();
        Character computer = menuService.getRandomCharacter();
        menuService.showRandomCharacter();

    }
}
