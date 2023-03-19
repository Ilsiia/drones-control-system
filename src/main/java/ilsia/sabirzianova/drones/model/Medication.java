package ilsia.sabirzianova.drones.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;//(allowed only letters, numbers, ‘-‘, ‘_’);
    private Integer weight;
    @NotBlank(message = "Medication with this code already exist")
    private String code;// (allowed only upper case letters, underscore and numbers);
    private byte[] image; // (picture of the medication case).

    public Medication(String name, Integer weight, String code, byte[] image) {
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

    public void setName(String name) {
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

    public void setCode(String code) {
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
