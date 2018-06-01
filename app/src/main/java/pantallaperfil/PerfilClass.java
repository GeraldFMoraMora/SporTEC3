package pantallaperfil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

import model.User;
import networking.RESTfulClient;
import sportec3.PantallaPrincipal.MainActivity;
import sportec3.PantallaPrincipal.R;


/**
 * Created by GeraldMM on 10/05/2018.
 */

public class PerfilClass extends AppCompatActivity implements View.OnClickListener {

    private EditText mNombreEdit;
    private EditText mCorreoEdit;
    private EditText mContrasenaEdit;

    private String mUserId;
    private String mUserPass;

    private int contador = 0;

    private static final String TAG = "CustomAuthActivity";
    private String mCustomToken;

    private EditText nombreUsuario1;
    private EditText correoUsuario1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        this.mNombreEdit = (EditText) findViewById(R.id.usuario_nombre);
        this.mCorreoEdit = (EditText) findViewById(R.id.usuario_correo);
        this.mContrasenaEdit = (EditText) findViewById(R.id.usuario_contrasena);

    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.actualizar_formulario_registro_button:
                this.buscarUsuario(mCorreoEdit.getText().toString());
                actualizarUsuario(mUserId, mCorreoEdit.getText().toString(), mContrasenaEdit.getText().toString(), mUserPass);
                startActivity(new Intent(PerfilClass.this, MainActivity.class));
                break;
            case R.id.salir_perfil_textview:
                startActivity(new Intent(PerfilClass.this, MainActivity.class));
                break;
        }
    }

    /**
     * Metodo para crear una cuenta, recive el correo y la contrasena, con eso es capaz de crear una cuenta en
     * el Auth de Firebase.
     *
     * @param email
     */
    public void buscarUsuario(final String email) {
        RESTfulClient
                .with(getApplicationContext())
                .getAllUser(new FutureCallback<List<User>>() {
                    @Override
                    public void onCompleted(Exception e, List<User> result) {
                        System.out.println("@@@@" + result.get(0).getEmail());
                        while (contador < result.size()) {
                            if (result.get(contador).getEmail().equals(email)) {
                                Log.i(" Exito: ", "Cuenta encontrada");
                                mUserId = result.get(contador).getId();
                                mUserPass = result.get(contador).getPass();
                                contador = result.size();
                            } else {
                                contador += 1;
                            }
                            Log.e(" Error: ", "Cuenta inexistente");
                        }
                    }
                });
    }

    /**
     * Metodo para guardar un usuario en la base de datos
     *
     * @param idUsuario
     * @param nombreUsuario
     * @param correoUsuario
     * @param pass
     */
    private void actualizarUsuario(String idUsuario, String nombreUsuario, String correoUsuario, String pass) {
        Ion.with(this)
                .load("PUT", "http://192.168.0.15:3000/api/usuario/" + idUsuario)
                //.load("http://192.168.0.15:3000/api/usuario/5b0f2c683785e44211000002")
                .setBodyParameter("name", nombreUsuario)
                .setBodyParameter("email", correoUsuario)
                .setBodyParameter("pass", pass)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        // do stuff with the result or error
                        Log.e(" Exito: ", "Usuario correctamente actualizado");
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
