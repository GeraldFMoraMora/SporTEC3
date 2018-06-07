package pantallasesion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.koushikdutta.async.future.FutureCallback;

import java.util.List;

import model.User;
import networking.RESTfulClient;
import pantallaregistro.RegistroClass;
import sportec3.PantallaPrincipal.ConstantInterface;
import sportec3.PantallaPrincipal.MainActivity;
import sportec3.PantallaPrincipal.R;


/**
 * Created by GeraldMM on 08/05/2018.
 */

public class SessionClass extends AppCompatActivity implements ConstantInterface {

    private EditText mCorreoEdit;
    private EditText mContrasenaEdit;

    private int contador = 0;

    private static final String TAG = "CustomAuthActivity";

    private ProgressBar mProgressBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        this.mCorreoEdit = (EditText) findViewById(R.id.usuario_correo_iniciosession_edittext);
        this.mContrasenaEdit = (EditText) findViewById(R.id.usuario_contrasena_inicio_session_edittext);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progressBarSession);
        this.mProgressBar.setVisibility(View.GONE);


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
    private void goMainScreen(String email, String name) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("name", name);
        try{
            startActivity(intent);
            this.finish();
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public void connectAccount(final String email, final String password) {
        RESTfulClient
                .with(getApplicationContext())
                .getAllUser(new FutureCallback<List<User>>() {
                    @Override
                    public void onCompleted(Exception e, List<User> result) {

                        while (contador < result.size()) {
                            if (result.get(contador).getEmail().equals(email)) {
                                if (result.get(contador).getPass().equals(password)) {
                                    goMainScreen(result.get(contador).getEmail().toString(), result.get(contador).getName().toString());
                                    Log.i(" Exito: ", "Sesion iniciada");
                                    contador = result.size();
                                } else {
                                    Log.e(" Error: ", "Contraseña incorrecta");
                                }
                            } else {
                                contador += 1;
                            }
                        }
                        contador = 0;
                        Log.e(" Error: ", "Cuenta inexistente");
                    }
                });
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
                this.mProgressBar.setVisibility(View.VISIBLE);
                connectAccount(mCorreoEdit.getText().toString(), mContrasenaEdit.getText().toString());
                break;
            case R.id.registrarse_session_buttom:
                this.mProgressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(SessionClass.this, RegistroClass.class));
                break;
        }
    }

    @Override
    public void onClick(View v, int position) {

    }
}
