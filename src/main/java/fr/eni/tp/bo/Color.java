package fr.eni.tp.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Color {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    public Color() {
    }

    public Color(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
