package pantallaregistro;

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

public class RegistroClass extends AppCompatActivity implements View.OnClickListener{

    private EditText mNombreEdit;
    private EditText mCorreoEdit;
    private EditText mContrasenaEdit;
    private String mUserId;

    private static final String TAG = "CustomAuthActivity";
    private String mCustomToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_formulario_resgistro);

        this.mNombreEdit = (EditText) findViewById(R.id.usuario_nombre_formulario_registro_textedit);
        this.mCorreoEdit = (EditText) findViewById(R.id.usuario_correo_formulario_registro_textedit);
        this.mContrasenaEdit = (EditText) findViewById(R.id.usuario_contrasena_formulario_registro_edittex);


    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rigistrar_formulario_registro_button:
                createAccount(mCorreoEdit.getText().toString(),mContrasenaEdit.getText().toString());
                startActivity(new Intent(RegistroClass.this,MainActivity.class));
                break;
            case R.id.cancelar_formulario_registro_textview:
                break;
        }
    }

    /**
     * Metodo para crear una cuenta, recive el correo y la contrasena, con eso es capaz de crear una cuenta en
     * el Auth de Firebase.
     * @param email
     * @param password
     */
    public void createAccount(String email, String password){

    }
    /**
     * Metodo para guardar un usuario en la base de datos
     * @param idUsuario
     * @param nombreUsuario
     * @param correoUsuario
     * @param foto
     */
    private void guardarUsuario(String idUsuario, String nombreUsuario, String correoUsuario, String foto){

    }

    @Override
    public void onStart() {
        super.onStart();
        // Revisa que exista un usuario y actualiza la activity.
    }

    /**
     * Metodo que actualiza los elementos de la interfaz.
     * @param user
     */
    private void updateUI() {
    }


}
