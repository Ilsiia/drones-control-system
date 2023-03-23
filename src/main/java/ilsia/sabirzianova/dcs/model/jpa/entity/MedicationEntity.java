package ilsia.sabirzianova.dcs.model.jpa.entity;


import ilsia.sabirzianova.dcs.MedicationDataChecker;
import ilsia.sabirzianova.dcs.exceptions.IllegalDataException;

import javax.persistence.*;

@Entity
@Table(name = "MEDICATION")
public class MedicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "MEDICATION_NAME", nullable = false)
    private String name;//(allowed only letters, numbers, ‘-‘, ‘_’);
    @Column(name = "MEDICATION_WEIGHT", nullable = false)
    private Integer weight;

    @Column(name = "MEDICATION_CODE", nullable = false, unique = true)
    private String code;// (allowed only upper case letters, underscore and numbers);
    @Column(name = "MEDICATION_IMAGE", nullable = false)
    private byte[] image; // (picture of the medication case).

    public MedicationEntity() {
    }

    public MedicationEntity(String name, Integer weight, String code, byte[] image) throws IllegalDataException {
        if (!MedicationDataChecker.checkName(name) || !MedicationDataChecker.checkCode(code)) {
            throw new IllegalDataException(String.format("Medication name = %s or code = %s is not valid", name, code));
        }
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalDataException {
        if (!MedicationDataChecker.checkName(name))
            throw new IllegalDataException(String.format("Medication name = %s is not valid", name));
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) throws IllegalDataException {
        if (!MedicationDataChecker.checkCode(code))
            throw new IllegalDataException(String.format("Medication code = %s is not valid", code));
        this.code = code;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return String.format("Medication[code=%s, weight='%s', name='%s']",
                code, weight, name);
    }
}
