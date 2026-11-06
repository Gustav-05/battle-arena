package main;

public class Archer extends Character{

    private static final int ARCHER_MAX_HP = 105;
    private static final int ARCHER_MIN_DAMAGE = 8;
    private static final int ARCHER_MAX_DAMAGE = 18;


    public Archer(String name) {
        super(name, ARCHER_MAX_HP, ARCHER_MIN_DAMAGE, ARCHER_MAX_DAMAGE);
    }
}
