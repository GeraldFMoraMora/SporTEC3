package model;

import java.io.Serializable;

/**
 * Created by Gerald PC on 31/05/2018.
 */

public class Deporte implements Serializable {
    private String name;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Deporte: " + getName() + " foto url: " + getPhoto();
    }
}
