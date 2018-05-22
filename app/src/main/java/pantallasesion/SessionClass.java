package pantallasesion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import pantallaregistro.RegistroClass;
import sportec3.PantallaPrincipal.ConstantInterface;
import sportec3.PantallaPrincipal.MainActivity;
import sportec3.PantallaPrincipal.R;


/**
 * Created by GeraldMM on 08/05/2018.
 */

public class SessionClass extends AppCompatActivity implements ConstantInterface {

    private EditText mNombreEdit;
    private EditText mCorreoEdit;
    private EditText mContrasenaEdit;

    private static final String TAG = "CustomAuthActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_session);

        this.mCorreoEdit = (EditText) findViewById(R.id.usuario_correo_iniciosession_edittext);
        this.mContrasenaEdit = (EditText) findViewById(R.id.usuario_contrasena_inicio_session_edittext);


    }


    /**
     * Metodo que maneja el resultado de conexion, indicara que pasa si hay una conexion exitosa
     * o fallida.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Metodo que me envia a la pagina principal de la app una vez hay un usuario conectado
     */
    private void goMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    public void connectAccount(String email, String password) {

    }

    private void updateUI() {
    }

    /**
     * Metodo autogenerado
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Metodo Autogenerado
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iniciar_session_buttom:
                connectAccount(mCorreoEdit.getText().toString(), mContrasenaEdit.getText().toString());
                //startActivity(new Intent(SessionLayout.this,MainActivity.class));
                break;
            case R.id.registrarse_session_buttom:
                startActivity(new Intent(SessionClass.this, RegistroClass.class));
                break;
        }
    }

    @Override
    public void onClick(View v, int position) {

    }
}
