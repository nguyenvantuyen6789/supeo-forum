package rc.domain;

import javax.persistence.*;

@Entity
@Table(name = "tbl_hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int classification;
    private boolean isOpen;

    public Hotel() {
    }

    public Hotel(String name, int classification, boolean isOpen) {
        this.name = name;
        this.classification = classification;
        this.isOpen = isOpen;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getClassification() {
        return classification;
    }

    public boolean isOpen() {
        return isOpen;
    }

}
