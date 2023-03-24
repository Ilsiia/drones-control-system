package ilsia.sabirzianova.dcs.model.jpa.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    @Min(0)
    @Max(100)
    private int batteryLevel;
    @ManyToOne
    private DroneEntity drone;
    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    public History() {
    }

    public History(int batteryLevel, DroneEntity drone, LocalDateTime localDateTime) {
        this.batteryLevel = batteryLevel;
        this.drone = drone;
        this.localDateTime = localDateTime;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public DroneEntity getDrone() {
        return drone;
    }

    public void setDrone(DroneEntity drone) {
        this.drone = drone;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
