package ilsia.sabirzianova.dcs.model;

import ilsia.sabirzianova.dcs.exceptions.DcsAppException;
import ilsia.sabirzianova.dcs.model.enums.DroneModel;
import ilsia.sabirzianova.dcs.model.enums.DroneState;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Drone {
    String serialNumber;//100 characters max
    Integer batteryCapacity; // percentage
    DroneModel model;//(Lightweight, Middleweight, Cruiserweight, Heavyweight)
    Integer weightLimit;//500gr max;
    List<Medication> medications;
    DroneState state; //IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING

    public Drone(String serialNumber, Integer batteryCapacity, DroneModel model, Integer weightLimit, List<Medication> medications, DroneState state) {
        this.serialNumber = serialNumber;
        this.batteryCapacity = batteryCapacity;
        this.model = model;
        this.weightLimit = weightLimit;
        this.medications = medications;
        this.state = state;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DroneModel getModel() {
        return model;
    }

    public void setModel(DroneModel model) {
        this.model = model;
    }

    public Integer getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Integer weightLimit) {
        this.weightLimit = weightLimit;
    }

    public List<Medication> getMedications() {
        if (medications == null) {
            medications = new ArrayList<>();
        }
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public void load(@NotNull Medication medication) {
        if (getLoadedMedicationsWeight() + medication.getWeight() < this.weightLimit) {
            this.getMedications().add(medication);
        } else {
            throw new DcsAppException(String.format("Drone with serial number %s reached cargo weight limit.", serialNumber));
        }
    }

    public void loadAll(@NotNull List<Medication> medications) {
        for (Medication medication : medications) {
            this.load(medication);
        }
    }

    public void unload(@NotNull Medication medication) {
        this.getMedications().remove(medication);
    }

    public void unloadAll() {
        this.medications = null;
    }

    public Integer getLoadedMedicationsWeight() {
        int result = 0;
        for (Medication medication : this.getMedications()) {
            result = result + medication.getWeight();
        }
        return result;
    }

    public DroneState getState() {
        return state;
    }

    public void setState(DroneState state) {
        this.state = state;
    }
}
