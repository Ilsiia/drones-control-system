package ilsia.sabirzianova.dcs.model.enums;

public enum DroneState {
    IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING;
    private static final DroneState[] values = values();

    public DroneState next() {
        return values[(this.ordinal() + 1) % values.length];
    }
}
