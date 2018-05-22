package pantallaequipo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class EquipoClass extends AppCompatActivity {
    private Intent mScreen;
    private Long mId;
    private String mNombreEquipo;


    private TextView mNombreEquipoView;

    private ArrayList<MiembroModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        this.mId = getIntent().getLongExtra("id", 0);

        this.setmNombreDeporte();
        this.mNombreEquipoView = (TextView) findViewById(R.id.nombre_equipo_layout_equipo_textview);

        this.list = new ArrayList();

        //list.add(new MiembroModel(MiembroModel.IMAGE_TYPE,"Messi Bolaños",R.mipmap.messi));
        //list.add(new MiembroModel(MiembroModel.IMAGE_TYPE,"Mia Kalifa",R.mipmap.mia));
        //list.add(new MiembroModel(MiembroModel.IMAGE_TYPE,"Tonny Tun Tun",R.mipmap.tony));
        //list.add(new MiembroModel(MiembroModel.IMAGE_TYPE,"Hi again. Another cool image here. Which one is better?",R.mipmap.grid3));

    }

    /**
     * Este metodo obtiene el id del objeto seleccionado y le asigna un nombre para ser identificado de manera
     * sencilla.
     */
    private void setmNombreDeporte() {
        switch (mId.toString()) {
            case "0":
                this.mNombreEquipo = "Artes marciales";
                break;
            case "1":
                this.mNombreEquipo = "Atletismo";
                break;
            case "2":
                this.mNombreEquipo = "Badminton";
                break;
            case "3":
                this.mNombreEquipo = "Balon mano";
                break;
            case "4":
                this.mNombreEquipo = "Baseball";
                break;
            case "5":
                this.mNombreEquipo = "Basketball";
                break;
            case "6":
                this.mNombreEquipo = "Ciclismo";
                break;
            case "7":
                this.mNombreEquipo = "Levantamiento de pesas";
                break;
            case "8":
                this.mNombreEquipo = "Futball";
                break;
            case "9":
                this.mNombreEquipo = "Kayak";
                break;
            case "10":
                this.mNombreEquipo = "Ping pong";
                break;
            case "11":
                this.mNombreEquipo = "Esgrima";
                break;
            case "12":
                this.mNombreEquipo = "Tennis";
                break;
            case "13":
                this.mNombreEquipo = "Volleyball";
                break;
        }
    }
}
