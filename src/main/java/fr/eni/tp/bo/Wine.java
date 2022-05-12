package fr.eni.tp.bo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String vintage;

    @Length(min = 5, max = 50)
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean sparkly;

    @Range(min = 1)
    @Column(nullable = false)
    private int quantity;
    @ManyToOne
    private Color color;
    @ManyToOne
    private Region region;

    public Wine() {
    }

    public Wine(String vintage, String name, boolean sparkly, int quantity, Color color, Region region) {
        this.vintage = vintage;
        this.name = name;
        this.sparkly = sparkly;
        this.quantity = quantity;
        this.color = color;
        this.region = region;
    }

    public Wine(long id, String vintage, String name, boolean sparkly, int quantity, Color color, Region region) {
        this.id = id;
        this.vintage = vintage;
        this.name = name;
        this.sparkly = sparkly;
        this.quantity = quantity;
        this.color = color;
        this.region = region;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSparkly() {
        return sparkly;
    }

    public void setSparkly(boolean sparkly) {
        this.sparkly = sparkly;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", vintage='" + vintage + '\'' +
                ", name='" + name + '\'' +
                ", sparkly=" + sparkly +
                ", quantity=" + quantity +
                ", color=" + color +
                ", region=" + region +
                '}';
    }
}
