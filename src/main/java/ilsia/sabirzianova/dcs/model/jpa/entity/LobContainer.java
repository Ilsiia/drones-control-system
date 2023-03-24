package ilsia.sabirzianova.dcs.model.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "MEDICATION_IMAGES")
public class LobContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "IMAGE", nullable = false)
    private byte[] image;

    public LobContainer() {
    }

    public LobContainer(byte[] image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
