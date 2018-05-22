package pantallaperfil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

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
                //createAccount(mCorreoEdit.getText().toString(),mContrasenaEdit.getText().toString());
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
     * @param password
     */
    public void createAccount(String email, String password) {

    }

    /**
     * Metodo para guardar un usuario en la base de datos
     *
     * @param idUsuario
     * @param nombreUsuario
     * @param correoUsuario
     * @param foto
     */
    private void guardarUsuario(String idUsuario, String nombreUsuario, String correoUsuario, String foto) {
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    /**
     * Metodo que actualiza los elementos de la interfaz.
     *
     * @param user
     */
    private void updateUI() {
    }
}
