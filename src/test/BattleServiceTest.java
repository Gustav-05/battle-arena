package test;

import main.*;
import main.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BattleServiceTest {

    private BattleService battleService;
    private Archer attacker;
    private Warrior defender;
    private Mage mageDefender;

    @BeforeEach
    public void setUp() {
        battleService = new BattleService();
        attacker = new Archer("Legolas");
        defender = new Warrior("Aragorn");
        mageDefender = new Mage("Gandalf");
    }

    @Test
    void attackShouldReduceHpByCorrectDamage() {
        int incomingDamage = 10;
        int hpBeforeAttack = defender.getHp();

        battleService.attack(attacker, defender, incomingDamage);

        int hpAfterAttack = defender.getHp();

        int actualDamage = hpBeforeAttack - hpAfterAttack;

        assertEquals(actualDamage, incomingDamage);

    }


    @Test
    void defendShouldDecreasedDamage() {

        int incomingDamage = 10;
        defender.setHp(50);

        battleService.defend(defender);
        battleService.attack(attacker, defender, incomingDamage);

        assertTrue(defender.getHp() > 45);
        System.out.println(incomingDamage);
    }


    @Test
    void healShouldHealBetween15And25() {
        mageDefender.setHp(50);

        battleService.heal(mageDefender);

        int hpAfterHeal = mageDefender.getHp();

        assertTrue(hpAfterHeal >= 65 && hpAfterHeal <= 75);

    }

    @Test
    void doubleShotShouldDamageAttack2Times() {
        int incomingDamage = 10;
        int hpBeforeAttack = defender.getHp();
        battleService.doubleShot(attacker, defender, incomingDamage);
        int hpAfterAttack = defender.getHp();

        int actualDamage = hpBeforeAttack - hpAfterAttack;


        assertTrue(actualDamage >= 16 && actualDamage <= 36);
    }

    @Test
    void hpShouldNotGoBelow0() {
        int incomingDamage = 10;
        defender.setHp(5);

        battleService.attack(attacker, defender, incomingDamage);

        assertEquals(0, defender.getHp());
    }



}
