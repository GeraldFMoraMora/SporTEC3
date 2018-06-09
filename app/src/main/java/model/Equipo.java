package model;

import java.io.Serializable;

/**
 * Created by Gerald PC on 31/05/2018.
 */

public class Equipo implements Serializable {
    private String name;
    private String sport;
    private String photo;
    private String win;
    private String lost;
    private String tie;

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

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getTie() {
        return tie;
    }

    public void setTie(String tie) {
        this.tie = tie;
    }
}
