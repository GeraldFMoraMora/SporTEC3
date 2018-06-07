package pantallaequipo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import model.Equipo;
import networking.RESTfulClient;
import sportec3.PantallaPrincipal.ConstantInterface;
import sportec3.PantallaPrincipal.R;

/**
 * Created by Gerald PC on 01/06/2018.
 */

public class ListaEquipoClass extends AppCompatActivity {
    private Long mId;

    private int contador = 0;

    private ArrayList<EquipoModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

        this.mId = getIntent().getLongExtra("id", 0);

        System.out.println("@@@@@@" + mId.toString());



    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.list = new ArrayList();
        this.equiposBanner();
    }

    @Override
    protected void onStart() {
        super.onStart();

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
                            list.add(new EquipoModel(EquipoModel.IMAGE_TYPE, result.get(contador).getName(), result.get(contador).getSport(), result.get(contador).getPhoto()));
                            contador += 1;
                        }
                        contador = 0;
                        Log.e(" Error: ", "No existe noticia destacada");
                    }
                });
        LEMainAdapter adapter = new LEMainAdapter(list, ListaEquipoClass.this, new ConstantInterface() {

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListaEquipoClass.this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_equipos);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }
}
