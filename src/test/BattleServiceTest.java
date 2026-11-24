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
        int hpBeforeAttack = defender.getHp();

        battleService.attack(attacker, defender);

        int hpAfterAttack = defender.getHp();

        int actualDamage = hpBeforeAttack - hpAfterAttack;

        assertTrue(actualDamage >= 8 && actualDamage <= 18);

    }

    @Test
    void useSpecialityAbilityShouldActivateDefending() {

        defender.useSpecialAbility(null);

        assertTrue(defender.isDefending());
    }


    @Test
    void defendShouldDecreaseDamage() {

        int damageWithoutDefend = 10;

        int damageWithDefended = defender.defend(damageWithoutDefend);

        assertTrue(damageWithDefended < damageWithoutDefend);
        assertTrue(damageWithDefended >= 0);
    }


    @Test
    void healShouldIncreaseHp() {
        mageDefender.setHp(50);

        int hpBeforeHeal = mageDefender.getHp();

        mageDefender.useSpecialAbility(null);

        int hpAfterHeal = mageDefender.getHp();

        assertTrue(hpAfterHeal > hpBeforeHeal);



    }

    @Test
    void explosiveArrowShouldDamage() {

        int hpBeforeAttack = defender.getHp();

        attacker.useSpecialAbility(defender);

        int hpAfterAttack = defender.getHp();

        int actualDamage = hpBeforeAttack - hpAfterAttack;

        assertTrue(actualDamage >= 16 && actualDamage <= 36);



    }

    @Test
    void hpShouldNotGoBelow0() {

        defender.setHp(5);

        battleService.attack(attacker, defender);

        assertEquals(0, defender.getHp());
    }



}
