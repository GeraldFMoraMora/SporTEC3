package pantallaequipo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import model.Equipo;
import model.Noticia;
import model.User;
import networking.RESTfulClient;
import pantallanoticia.NoticiaFragment;
import pantallanoticia.NoticiaMainAdapter;
import pantallanoticia.NoticiaMainModel;
import sportec3.PantallaPrincipal.ConstantInterface;
import sportec3.PantallaPrincipal.MainActivity;
import sportec3.PantallaPrincipal.R;

/**
 * Created by Gerald PC on 01/06/2018.
 */

public class ListaEquipoClass extends AppCompatActivity{
    private Intent mScreen;
    private Long mId;
    private String mNombreEquipo;

    private int contador = 0;

    private ArrayList<EquipoModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

        this.mId = getIntent().getLongExtra("id", 0);

        System.out.println("@@@@@@" + mId.toString());

        this.list = new ArrayList();

        /**RESTfulClient
                .with(getApplicationContext())
                .getAllEquipos(new FutureCallback<List<Equipo>>() {
                    @Override
                    public void onCompleted(Exception e, List<Equipo> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            list.add(new EquipoModel(EquipoModel.IMAGE_TYPE, result.get(contador).getName(), result.get(contador).getSport(),result.get(contador).getPhoto()));
                            contador += 1;
                        }
                        contador = 0;
                        EquipoAdapter adapter = new EquipoAdapter(list, ListaEquipoClass.this);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListaEquipoClass.this, OrientationHelper.VERTICAL, false);

                        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_equipos);
                        mRecyclerView.setLayoutManager(linearLayoutManager);
                        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                        mRecyclerView.setAdapter(adapter);
                        Log.e(" Error: ", "Cuenta inexistente");
                    }
                });**/
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
                            list.add(new EquipoModel(EquipoModel.IMAGE_TYPE, result.get(contador).getName(), result.get(contador).getSport(),result.get(contador).getPhoto()));
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
