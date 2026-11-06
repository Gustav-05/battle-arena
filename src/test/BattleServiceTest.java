package test;

import main.*;
import main.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BattleServiceTest {

    private BattleService battleService;
    private Archer attacker;
    private Mage defender;

    @BeforeEach
    public void setUp() {
        battleService = new BattleService();
        attacker = new Archer("Legolas");
        defender = new Mage("Gandalf");
    }

    @Test
    void attackShouldReduceHpByCorrectDamage() {
        int hpBeforeAttack = defender.getHp();

        battleService.attack(attacker, defender);

        int hpAfterAttack = defender.getHp();

        int actualDamage = hpBeforeAttack - hpAfterAttack;

        assertTrue(actualDamage >= 5 && actualDamage <= 15);

    }

    /*
    @Test
    void defendShouldDecreasedDamage() {

        int incomingDamage = 10;

        int reduceDamage = defender.defend(incomingDamage);

        assertTrue(reduceDamage <= 5 && reduceDamage >= 0);

    }

     */

    @Test
    void healShouldHealBetween15And25() {
        defender.setHp(50);

        battleService.heal(defender);

        int hpAfterHeal = defender.getHp();

        assertTrue(hpAfterHeal >= 65 && hpAfterHeal <= 75);

    }

    @Test
    void doubleShotShouldDamageAttack2Times() {
        int hpBeforeAttack = defender.getHp();
        battleService.doubleShot(attacker, defender);
        int hpAfterAttack = defender.getHp();

        int actualDamage = hpBeforeAttack - hpAfterAttack;


        assertTrue(actualDamage >= 16 && actualDamage <= 36);
    }


}
