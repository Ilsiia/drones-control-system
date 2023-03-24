package ilsia.sabirzianova.dcs.model;

public class Medication {
    private String name;
    private Integer weight;
    private String code;
    private String imageUrl;

    public Medication(String name, Integer weight, String code, String imageUrl) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
