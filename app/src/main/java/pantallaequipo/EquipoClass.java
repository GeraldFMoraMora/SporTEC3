package pantallaequipo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import model.User;
import networking.RESTfulClient;
import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class EquipoClass extends AppCompatActivity {
    private Intent mScreen;
    private Long mId;
    private String mNombreEquipo;

    private int contador = 0;


    private TextView mNombreEquipoView;

    private ArrayList<MiembroModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        this.mId = getIntent().getLongExtra("id", 0);

        System.out.println("@@@@@@" + mId.toString());

        this.mNombreEquipoView = (TextView) findViewById(R.id.nombre_equipo_layout_equipo_textview);
        this.setmNombreDeporte();

        this.mNombreEquipoView.setText(this.mNombreEquipo);

        this.list = new ArrayList();

        RESTfulClient
                .with(getApplicationContext())
                .getAllUser(new FutureCallback<List<User>>() {
                    @Override
                    public void onCompleted(Exception e, List<User> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            list.add(new MiembroModel(MiembroModel.IMAGE_TYPE, result.get(contador)
                                    .getName(), "https://firebasestorage.googleapis.com/v0/b/sportec-cf3d1.appspot.com/o/usuarios%2Fuserlogo.png?alt=media&token=83b0e50e-9a87-477e-8695-6c60fb23cf64"));
                            contador += 1;
                        }
                        contador = 0;
                        MiembroAdapter adapter = new MiembroAdapter(list, EquipoClass.this);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(EquipoClass.this, OrientationHelper.VERTICAL, false);

                        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_miembro);
                        mRecyclerView.setLayoutManager(linearLayoutManager);
                        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                        mRecyclerView.setAdapter(adapter);
                        Log.e(" Error: ", "Cuenta inexistente");
                    }
                });
    }

    /**
     * Este metodo obtiene el id del objeto seleccionado y le asigna un nombre para ser identificado de manera
     * sencilla.
     */
    private void setmNombreDeporte() {
        switch (mId.intValue()) {
            case 0:
                this.mNombreEquipo = "Artes marciales";
                break;
            case 1:
                this.mNombreEquipo = "Atletismo";
                break;
            case 2:
                this.mNombreEquipo = "Badminton";
                break;
            case 3:
                this.mNombreEquipo = "Balon mano";
                break;
            case 4:
                this.mNombreEquipo = "Baseball";
                break;
            case 5:
                this.mNombreEquipo = "Basketball";
                break;
            case 6:
                this.mNombreEquipo = "Ciclismo";
                break;
            case 7:
                this.mNombreEquipo = "Levantamiento de pesas";
                break;
            case 8:
                this.mNombreEquipo = "Futball";
                break;
            case 9:
                this.mNombreEquipo = "Kayak";
                break;
            case 10:
                this.mNombreEquipo = "Ping pong";
                break;
            case 11:
                this.mNombreEquipo = "Esgrima";
                break;
            case 12:
                this.mNombreEquipo = "Tennis";
                break;
            case 13:
                this.mNombreEquipo = "Volleyball";
                break;
        }
    }
}
