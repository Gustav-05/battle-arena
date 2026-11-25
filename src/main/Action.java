package main;

public enum Action {
    ATTACK("Attack"),
    SPECIAL_ABILITY("Specialförmåga");

    private final String displayName;

    Action(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}