package main;

public class Archer extends Character{

    public static final String ARCHER_NAME = "Legolas";
    private static final int ARCHER_MAX_HP = 105;
    private static final int ARCHER_MIN_DAMAGE = 8;
    private static final int ARCHER_MAX_DAMAGE = 18;
    private static final int DOUBLE_DAMAGE = 2;


    public Archer(String name) {
        super(name, ARCHER_MAX_HP, ARCHER_MIN_DAMAGE, ARCHER_MAX_DAMAGE);
    }

    @Override
    public void useSpecialAbility(Character defender) {
        int damage = explosiveArrow();
        defender.takeDamage(damage);

        System.out.println("\n" + getName() + " skjuter en eldpil");
        System.out.println(getName() + " skadade " + damage);
        System.out.println(defender.getName() + " " + defender.getHp() + " hp");
    }

    public int explosiveArrow() {
        return getRandomDamage() * DOUBLE_DAMAGE;
    }

}
