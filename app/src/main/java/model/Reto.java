package model;

import java.io.Serializable;

/**
 * Created by Gerald PC on 31/05/2018.
 */

public class Reto implements Serializable {
    private String name;
    private String team1;
    private String team2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    @Override
    public String toString() {
        return "Equipo: " + getName() + " equipo 1: " + getTeam1() + " equipo 2:" + getTeam2();
    }
}
