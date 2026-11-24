package main;

public interface Defendable {

    int defend(int incomingDamage);

    boolean isDefending();

    void setDefending(boolean defending);
}
