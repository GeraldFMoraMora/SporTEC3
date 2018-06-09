package pantallaequipo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import model.Equipo;
import model.User;
import networking.RESTfulClient;
import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class EquipoClass extends AppCompatActivity {
    private Intent mScreen;
    private String mNombreEquipo;

    private int contador = 0;


    private TextView mNombreEquipoView;

    private ArrayList<EquipoModel> list;

    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        this.mNombreEquipo = getIntent().getStringExtra("name");

        this.mNombreEquipoView = (TextView) findViewById(R.id.nombre_equipo_layout_equipo_textview);

        this.mNombreEquipoView.setText(this.mNombreEquipo);

        this.mImage = (ImageView) findViewById(R.id.foto_equipo_imageview);

        this.list = new ArrayList();
        RESTfulClient
                .with(getApplicationContext())
                .getAllEquipos(new FutureCallback<List<Equipo>>() {
                    @Override
                    public void onCompleted(Exception e, List<Equipo> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            if (result.get(contador).getName().equals(mNombreEquipo)) {
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

        RESTfulClient
                .with(getApplicationContext())
                .getAllUser(new FutureCallback<List<User>>() {
                    @Override
                    public void onCompleted(Exception e, List<User> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            list.add(new EquipoModel(EquipoModel.IMAGE_TYPE, result.get(contador).getName(), "https://firebasestorage.googleapis.com/v0/b/sportec-cf3d1.appspot.com/o/usuarios%2Fuserlogo.png?alt=media&token=83b0e50e-9a87-477e-8695-6c60fb23cf64", "https://firebasestorage.googleapis.com/v0/b/sportec-cf3d1.appspot.com/o/usuarios%2Fuserlogo.png?alt=media&token=83b0e50e-9a87-477e-8695-6c60fb23cf64", "", "", ""));
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
}
