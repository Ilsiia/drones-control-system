package ilsia.sabirzianova.dcs.model;

import ilsia.sabirzianova.dcs.exceptions.LoadingException;
import ilsia.sabirzianova.dcs.model.enums.DroneModel;
import ilsia.sabirzianova.dcs.model.enums.DroneState;
import ilsia.sabirzianova.dcs.model.jpa.entity.MedicationEntity;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Drone {
    String serialNumber;//100 characters max
    Integer batteryCapacity; // percentage
    DroneModel model;//(Lightweight, Middleweight, Cruiserweight, Heavyweight)
    Integer weightLimit;//500gr max;
    List<MedicationEntity> medications;
    DroneState state; //IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING

    public Drone(String serialNumber, Integer batteryCapacity, DroneModel model, Integer weightLimit, List<MedicationEntity> medications, DroneState state) {
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

    public List<MedicationEntity> getMedications() {
        if (medications == null) {
            medications = new ArrayList<>();
        }
        return medications;
    }

    public void setMedications(List<MedicationEntity> medications) {
        this.medications = medications;
    }

    public void load(@NotNull MedicationEntity medication) {
        if (getLoadedMedicationsWeight() + medication.getWeight() < this.weightLimit) {
            this.getMedications().add(medication);
        } else {
            throw new LoadingException("Drone with serial number %s reached cargo weight limit.");
        }
    }

    public void loadAll(@NotNull List<MedicationEntity> medications) {
        for (MedicationEntity medication : medications) {
            this.load(medication);
        }
    }

    public void unload(@NotNull MedicationEntity medication) {
        this.getMedications().remove(medication);
    }

    public void unloadAll() {
        this.medications = null;
    }

    public Integer getLoadedMedicationsWeight() {
        int result = 0;
        for (MedicationEntity medication : this.getMedications()) {
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
