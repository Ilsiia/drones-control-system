package ilsia.sabirzianova.drones.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Drone with this serial number already exists")
    Integer serialNumber; // (100 characters max);
    String model; // (Lightweight, Middleweight, Cruiserweight, Heavyweight);
    Integer weightLimit; // limit (500gr max);
    Integer batteryCapacity; // (percentage);
    String state; // (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).

    public Drone(Integer serialNumber, String model, Integer weightLimit, Integer batteryCapacity) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Integer weightLimit) {
        this.weightLimit = weightLimit;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    Medication medication;

    //loading a drone with medication items;
    public void load(Medication medication) {
        this.medication = medication;
    }

    public void unload() {
        this.medication = null;
    }

    @Override
    public String toString() {
        return String.format("Drone[serialNumber=%s, model='%s', weightLimit='%s', batteryCapacity='%s', state='%s']",
                serialNumber, model, weightLimit, batteryCapacity, state);
    }
}
