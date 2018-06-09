package pantalladeporte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import sportec3.PantallaPrincipal.R;

/**
 * Created by geraldportatil on 09/06/18.
 */

public class RegistroEquipoClass extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_equipo);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.equipo_registro_buttom:
                Intent registro = new Intent(this,RegistroEquipoClass.class);
                startActivity(registro);
                break;
        }
    }
}
