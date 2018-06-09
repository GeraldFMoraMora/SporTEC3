package pantalladeporte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

import model.User;
import networking.RESTfulClient;
import sportec3.PantallaPrincipal.R;

/**
 * Created by geraldportatil on 09/06/18.
 */

public class RegistroEquipoClass extends AppCompatActivity {

    private int contador = 0;
    private EditText mName;
    private EditText mPhoto;
    private EditText mWin;
    private EditText mLost;
    private EditText mTie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_equipo);

        this.mName = (EditText) findViewById(R.id.equipo_nombre_editText);
        this.mPhoto = (EditText) findViewById(R.id.equipo_foto_editText);
        this.mWin = (EditText) findViewById(R.id.equipo_ganadas_editText);
        this.mLost = (EditText) findViewById(R.id.equipo_perdidas_editText);
        this.mTie = (EditText) findViewById(R.id.equipo_empatadas_editText);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.equipo_registro_buttom:
                createAccount(mName.getText().toString(),mPhoto.getText().toString(),
                        mWin.getText().toString(),mLost.getText().toString(),mTie.getText().toString());
                try{
                    Intent deporte = new Intent(this, DeporteOpcionClass.class);
                    startActivity(deporte);
                    Thread.sleep(1000);
                }catch(InterruptedException ex){

            }

                break;
        }
    }

    public void createAccount(String nombre, String foto, String ganadas, String perdidas, String empates) {
        Ion.with(this)
                .load("http://192.168.0.15:3000/api/equipos/")
                .setBodyParameter("name", nombre)
                .setBodyParameter("sport", "5b10545772689ad238000008")
                .setBodyParameter("photo", foto)
                .setBodyParameter("win", ganadas)
                .setBodyParameter("lost", perdidas)
                .setBodyParameter("tie", empates)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        // do stuff with the result or error
                        Log.e(" Exito: ", "Equipo correctamente creado");
                        Toast.makeText(RegistroEquipoClass.this, "Equipo correctamente creado", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void onBackPressed(){
        Intent deporte = new Intent(this, DeporteOpcionClass.class);
        startActivity(deporte);
    }
}
