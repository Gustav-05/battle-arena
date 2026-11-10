package main;

public class Main {

    public static void main(String[] args) {

        BattleService battleService = new BattleService();

        battleService.menu();
        battleService.showCharacters();
        battleService.selectCharacter();
        battleService.showChosenCharacter();

    }
}
