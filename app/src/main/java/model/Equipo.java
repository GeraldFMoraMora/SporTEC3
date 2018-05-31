package model;

import java.io.Serializable;

/**
 * Created by Gerald PC on 31/05/2018.
 */

public class Equipo implements Serializable {
    private String name;
    private String sport;
    private String photo;

    @Override
    public String toString() {
        return "Equipo: " + getName() + " deporte: " + getSport() + " foto:" + getPhoto();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
