package model;

import java.io.Serializable;

/**
 * Created by Gerald PC on 31/05/2018.
 */

public class Noticia implements Serializable {
    private String title;
    private String description;
    private String photo;
    private String id;
    private Boolean today;

    @Override
    public String toString() {
        return "titulo: " + getTitle() + " description: " + getDescription() + " photo:" +
                getPhoto() + " today:" + getToday();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getToday() {
        return today;
    }

    public void setToday(Boolean today) {
        this.today = today;
    }
}
