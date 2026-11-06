package test;

import main.BattleService;
import main.Character;
import main.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BattleServiceTest {

    private BattleService battleService;
    private Warrior attacker;
    private Warrior defender;

    @BeforeEach
    public void setUp() {
        battleService = new BattleService();
        attacker = new Warrior("Aragorn");
        defender = new Warrior("Legolas");
    }

    @Test
    void attackShouldReduceHpByCorrectDamage() {
        int hpBeforeAttack = defender.getHp();

        battleService.attack(attacker, defender);

        int hpAfterAttack = defender.getHp();

        int actualDamage = hpBeforeAttack - hpAfterAttack;

        assertTrue(actualDamage >= 5 && actualDamage <= 15);

    }

    @Test
    void defendShouldDecreasedDamage() {

        int incomingDamage = 10;

        int reduceDamage = defender.defend(incomingDamage);

        assertTrue(reduceDamage <= 5 && reduceDamage >= 0);
        ;




    }
}
