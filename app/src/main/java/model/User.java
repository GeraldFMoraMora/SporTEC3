package model;

import java.io.Serializable;

/**
 * Created by GeraldMM on 31/05/2018.
 */

public class User implements Serializable {
    private String name;
    private String email;
    private String pass;
    private String _id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User: " + getName() + " email: " + getEmail() + " pass:" + getPass();
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
}
