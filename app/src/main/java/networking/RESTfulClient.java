package networking;

import android.app.Application;
import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

import model.Deporte;
import model.Equipo;
import model.Noticia;
import model.Resultado;
import model.Reto;
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
                .load(SERVER + "/api/deportes/")
                .asString()
                .setCallback(callback);
    }

    public void getAllDeportes(FutureCallback<List<Deporte>> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/deportes/")
                .as(new TypeToken<List<Deporte>>() {
                })
                .setCallback(callback);
    }

    public void getEquipoById(FutureCallback<String> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/equipos/")
                .asString()
                .setCallback(callback);
    }

    public void getAllEquipos(FutureCallback<List<Equipo>> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/equipos/")
                .as(new TypeToken<List<Equipo>>() {
                })
                .setCallback(callback);
    }

    public void getNoticiaById(FutureCallback<String> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/noticias/")
                .asString()
                .setCallback(callback);
    }

    public void getAllNoticias(FutureCallback<List<Noticia>> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/noticias/")
                .as(new TypeToken<List<Noticia>>() {
                })
                .setCallback(callback);
    }

    public void getResultadoById(String urlk, FutureCallback<String> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/resultado/" + urlk)
                .asString()
                .setCallback(callback);
    }

    public void getAllResultados(FutureCallback<List<Resultado>> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/resultados/")
                .as(new TypeToken<List<Resultado>>() {
                })
                .setCallback(callback);
    }

    public void getRetoById(FutureCallback<String> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/retos/")
                .asString()
                .setCallback(callback);
    }

    public void getAllRetos(FutureCallback<List<Reto>> callback) {
        Ion.with(this.mApplication)
                .load(SERVER + "/api/retos/")
                .as(new TypeToken<List<Reto>>() {
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
