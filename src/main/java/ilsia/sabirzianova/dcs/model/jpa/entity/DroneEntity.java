package ilsia.sabirzianova.dcs.model.jpa.entity;

import ilsia.sabirzianova.dcs.model.enums.DroneModel;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "DRONES")
public class DroneEntity {
    @Column(name = "DRONE_SERIAL_NUMBER", nullable = false, unique = true, length = 100)
    String serialNumber; // (100 characters max);
    @Column(name = "DRONE_MODEL", nullable = false)
    @Enumerated(EnumType.STRING)
    DroneModel model;//model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
    @Column(name = "DRONE_WEIGHT", nullable = false)
    @Min(0)
    @Max(500)
    Integer weightLimit;// limit (500gr max);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public DroneEntity() {
    }

    public DroneEntity(String serialNumber, DroneModel model, Integer weightLimit) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format("Drone[serialNumber=%s, model='%s', weightLimit='%s']",
                serialNumber, model, weightLimit);
    }
}
