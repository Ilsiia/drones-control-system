package ilsia.sabirzianova.dcs.model;

public class Medication {
    private String name;//(allowed only letters, numbers, ‘-‘, ‘_’);
    private Integer weight;
    private String code;// (allowed only upper case letters, underscore and numbers);
    private byte[] image; // (picture of the medication case).

    public Medication(String name, Integer weight, String code, byte[] image) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
