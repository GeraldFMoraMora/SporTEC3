package pantalladeporte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import model.Deporte;
import model.Equipo;
import networking.RESTfulClient;
import pantallaequipo.EquipoClass;
import pantallaequipo.EquipoModel;
import pantallaequipo.LEMainAdapter;
import sportec3.PantallaPrincipal.ConstantInterface;
import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class DeporteClass extends AppCompatActivity {
    private Intent mScreen;
    private Long mId;
    private String mNombreDeporte;

    private int contador = 0;

    private ImageView mImage;

    private TextView mNombreEquipoView;

    private ArrayList<EquipoModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deporte);

        this.mId = getIntent().getLongExtra("id", 0);

        this.mImage = (ImageView) findViewById(R.id.foto_deporte_imageview);

        this.mNombreEquipoView = (TextView) findViewById(R.id.nombre_equipo_layout_equipo_textview);
        this.setmNombreDeporte();

        this.mNombreEquipoView.setText(this.mNombreDeporte);

        this.list = new ArrayList();

        RESTfulClient
                .with(getApplicationContext())
                .getAllDeportes(new FutureCallback<List<Deporte>>() {
                    @Override
                    public void onCompleted(Exception e, List<Deporte> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            if (result.get(contador).getName().equals(mNombreDeporte)) {
                                Log.e("Esto es lo que pasa: ", result.get(contador).getPhoto());
                                Picasso.get().load(result.get(contador).getPhoto()).into(mImage);
                                contador = result.size();
                            } else {
                                contador += 1;
                            }
                            Log.e(" No se encontro: ", " Nunca se encontro deporte");
                        }
                        contador = 0;

                    }
                });

        this.equiposBanner();
    }

    private void equiposBanner() {
        this.list = new ArrayList();
        RESTfulClient
                .with(getApplicationContext())
                .getAllEquipos(new FutureCallback<List<Equipo>>() {
                    @Override
                    public void onCompleted(Exception e, List<Equipo> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            list.add(new EquipoModel(EquipoModel.IMAGE_TYPE, result.get(contador).getName(), result.get(contador).getSport(), result.get(contador).getPhoto(), result.get(contador).getWin(), result.get(contador).getLost(), result.get(contador).getTie()));
                            contador += 1;
                        }
                        contador = 0;
                        Log.e(" Error: ", "No existe noticia destacada");
                    }
                });
        LEMainAdapter adapter = new LEMainAdapter(list, DeporteClass.this, new ConstantInterface() {

            @Override
            public void onClick(View v, final int position) {


                contador = 0;
                RESTfulClient
                        .with(getApplicationContext())
                        .getAllEquipos(new FutureCallback<List<Equipo>>() {
                            @Override
                            public void onCompleted(Exception e, List<Equipo> result) {
                                System.out.println(result.size());
                                while (contador < result.size()) {
                                    if (contador == position) {
                                        Intent mIntent = new Intent(DeporteClass.this, EquipoClass.class);
                                        mIntent.putExtra("name", result.get(contador).getName().toString());
                                        startActivity(mIntent);
                                        Toast.makeText(getApplicationContext(), result.get(contador).getName(), Toast.LENGTH_SHORT).show();

                                        contador = result.size();
                                    } else {
                                        contador += 1;
                                    }
                                }
                                contador = 0;
                                Log.e(" Error: ", "Se termino de cargar pantallas");
                            }
                        });

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DeporteClass.this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_equipos);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button_miembro_agregar:
                Intent registro = new Intent(this,RegistroEquipoClass.class);
                startActivity(registro);
                break;
        }
    }

    /**
     * Este metodo obtiene el id del objeto seleccionado y le asigna un nombre para ser identificado de manera
     * sencilla.
     */
    private void setmNombreDeporte() {
        switch (mId.intValue()) {
            case 0:
                this.mNombreDeporte = "Artes marciales";
                break;
            case 1:
                this.mNombreDeporte = "Atletismo";
                break;
            case 2:
                this.mNombreDeporte = "Badminton";
                break;
            case 3:
                this.mNombreDeporte = "Balon mano";
                break;
            case 4:
                this.mNombreDeporte = "Baseball";
                break;
            case 5:
                this.mNombreDeporte = "Basketball";
                break;
            case 6:
                this.mNombreDeporte = "Ciclismo";
                break;
            case 7:
                this.mNombreDeporte = "Levantamiento de pesas";
                break;
            case 8:
                this.mNombreDeporte = "Futball";
                break;
            case 9:
                this.mNombreDeporte = "Kayak";
                break;
            case 10:
                this.mNombreDeporte = "Ping pong";
                break;
            case 11:
                this.mNombreDeporte = "Esgrima";
                break;
            case 12:
                this.mNombreDeporte = "Tennis";
                break;
            case 13:
                this.mNombreDeporte = "Volleyball";
                break;
        }
    }
}
