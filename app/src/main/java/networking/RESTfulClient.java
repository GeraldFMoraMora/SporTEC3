package networking;

import android.app.Application;
import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

import model.User;

/**
 * Created by GeraldMM on 31/05/2018.
 */

public class RESTfulClient implements ServerConstants {
    private Application mApplication;

    public RESTfulClient(Application application) {
        this.mApplication = application;
    }

    public static RESTfulClient with(Context application) {
        return new RESTfulClient((Application) application);
    }

    public void getDeporteById(FutureCallback<String> callback) {
        Ion.with(this.mApplication)
                //.load(SERVER+"/api/usuario/5b0e37af94b2d5367e000002")
                .load(SERVER + "/api/usuarios/")
                .asString()
                .setCallback(callback);
    }

    public void getAllDeportes(FutureCallback<List<User>> callback) {
        Ion.with(this.mApplication)
                //.load(SERVER+"/api/usuario/5b0e37af94b2d5367e000002")
                .load(SERVER + "/api/usuarios/")
                .as(new TypeToken<List<User>>() {
                })
                .setCallback(callback);
    }

    public void getEquipoById(FutureCallback<String> callback) {
        Ion.with(this.mApplication)
                //.load(SERVER+"/api/usuario/5b0e37af94b2d5367e000002")
                .load(SERVER + "/api/usuarios/")
                .asString()
                .setCallback(callback);
    }

    public void getAllEquipos(FutureCallback<List<User>> callback) {
        Ion.with(this.mApplication)
                //.load(SERVER+"/api/usuario/5b0e37af94b2d5367e000002")
                .load(SERVER + "/api/usuarios/")
                .as(new TypeToken<List<User>>() {
                })
                .setCallback(callback);
    }

    public void getNoticiaById(FutureCallback<String> callback) {
        Ion.with(this.mApplication)
                //.load(SERVER+"/api/usuario/5b0e37af94b2d5367e000002")
                .load(SERVER + "/api/usuarios/")
                .asString()
                .setCallback(callback);
    }

    public void getAllNoticias(FutureCallback<List<User>> callback) {
        Ion.with(this.mApplication)
                //.load(SERVER+"/api/usuario/5b0e37af94b2d5367e000002")
                .load(SERVER + "/api/usuarios/")
                .as(new TypeToken<List<User>>() {
                })
                .setCallback(callback);
    }

    public void getRetoById(FutureCallback<String> callback) {
        Ion.with(this.mApplication)
                //.load(SERVER+"/api/usuario/5b0e37af94b2d5367e000002")
                .load(SERVER + "/api/usuarios/")
                .asString()
                .setCallback(callback);
    }

    public void getAllRetos(FutureCallback<List<User>> callback) {
        Ion.with(this.mApplication)
                //.load(SERVER+"/api/usuario/5b0e37af94b2d5367e000002")
                .load(SERVER + "/api/usuarios/")
                .as(new TypeToken<List<User>>() {
                })
                .setCallback(callback);
    }

    public void getUserById(String urlk, FutureCallback<String> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/usuario/" + urlk)
                .asString()
                .setCallback(callback);
    }

    public void getAllUser(FutureCallback<List<User>> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/usuarios/")
                .as(new TypeToken<List<User>>() {
                })
                .setCallback(callback);
    }
}
