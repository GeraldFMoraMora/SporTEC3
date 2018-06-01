package pantallaregistro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import pantallasesion.SessionClass;
import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 10/05/2018.
 */

public class RegistroClass extends AppCompatActivity implements View.OnClickListener {

    private EditText mNombreEdit;
    private EditText mCorreoEdit;
    private EditText mContrasenaEdit;
    private String mUserId;

    private static final String TAG = "CustomAuthActivity";
    private String mCustomToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);

        this.mNombreEdit = (EditText) findViewById(R.id.usuario_nombre_formulario_registro_textedit);
        this.mCorreoEdit = (EditText) findViewById(R.id.usuario_correo_formulario_registro_textedit);
        this.mContrasenaEdit = (EditText) findViewById(R.id.usuario_contrasena_formulario_registro_edittex);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rigistrar_formulario_registro_button:
                createAccount(mNombreEdit.getText().toString(), mCorreoEdit.getText().toString(), mContrasenaEdit.getText().toString());
                startActivity(new Intent(RegistroClass.this, SessionClass.class));
                break;
            case R.id.cancelar_formulario_registro_textview:
                break;
        }
    }

    /**
     * Metodo para crear una cuenta, recive el correo y la contrasena, con eso es capaz de crear una cuenta en
     * el Auth de Firebase.
     *
     * @param email
     * @param password
     */
    public void createAccount(String name, String email, String password) {
        Ion.with(this)
                .load("http://192.168.0.15:3000/api/usuarios/")
                .setBodyParameter("name", name)
                .setBodyParameter("email", email)
                .setBodyParameter("pass", password)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        // do stuff with the result or error
                        Log.e(" Exito: ", "Usuario correctamente creado");
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Revisa que exista un usuario y actualiza la activity.
    }


}
