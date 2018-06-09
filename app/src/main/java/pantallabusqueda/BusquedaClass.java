package pantallabusqueda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import model.Equipo;
import model.Noticia;
import networking.RESTfulClient;
import pantallaequipo.EquipoModel;
import pantallaequipo.LEMainAdapter;
import pantallanoticia.NoticiaMainAdapter;
import pantallanoticia.NoticiaMainModel;
import sportec3.PantallaPrincipal.ConstantInterface;
import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class BusquedaClass extends AppCompatActivity {
    private GridView mGridView;

    private Intent mScreen;
    private Toolbar mToolbar;
    private ImageView mLogoNav;

    private ImageView mImagenNoticia;
    private TextView MTituloNoticia;

    private EditText mEntryBusqueda;

    private int contador = 0;

    private ArrayList<NoticiaMainModel> mList;
    private ArrayList<EquipoModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarBusqueda);
        setSupportActionBar(toolbar);

        this.list = new ArrayList();

        this.mEntryBusqueda = (EditText) findViewById(R.id.busqueda_editText);

        //this.realizarbusqueda();
    }

    public void realizarbusqueda() {
        this.buscarNoticias();

        this.buscarEquipos();

    }

    public void buscarNoticias() {
        this.mList = new ArrayList();
        RESTfulClient
                .with(getApplicationContext())
                .getAllNoticias(new FutureCallback<List<Noticia>>() {
                    @Override
                    public void onCompleted(Exception e, List<Noticia> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            if (result.get(contador).getTitle().contains(mEntryBusqueda.getText().toString())) {
                                mList.add(new NoticiaMainModel(NoticiaMainModel.IMAGE_TYPE, result.get(contador).getTitle(), result.get(contador).getPhoto(),
                                        result.get(contador).getDescription(), result.get(contador).getToday(), result.get(contador).getId()));
                            } else if (result.get(contador).getDescription().contains(mEntryBusqueda.getText().toString())) {
                                mList.add(new NoticiaMainModel(NoticiaMainModel.IMAGE_TYPE, result.get(contador).getTitle(), result.get(contador).getPhoto(),
                                        result.get(contador).getDescription(), result.get(contador).getToday(), result.get(contador).getId()));
                            }

                            contador += 1;
                        }
                        contador = 0;
                    }
                });
        NoticiaMainAdapter adapter = new NoticiaMainAdapter(mList, BusquedaClass.this, new ConstantInterface() {

            @Override
            public void onClick(View v, final int position) {


                contador = 0;
                RESTfulClient
                        .with(getApplicationContext())
                        .getAllNoticias(new FutureCallback<List<Noticia>>() {
                            @Override
                            public void onCompleted(Exception e, List<Noticia> result) {
                                System.out.println(result.size());
                                while (contador < result.size()) {
                                    if (contador == position) {


                                        contador = result.size();
                                    } else {
                                        contador += 1;
                                    }
                                }
                                contador = 0;
                            }
                        });

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BusquedaClass.this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_busqueda);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    public void buscarDeportes() {
    }

    public void buscarEquipos() {
        this.contador = 0;
        this.list = new ArrayList();
        RESTfulClient
                .with(getApplicationContext())
                .getAllEquipos(new FutureCallback<List<Equipo>>() {
                    @Override
                    public void onCompleted(Exception e, List<Equipo> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            if (result.get(contador).getName().contains(mEntryBusqueda.getText().toString())) {
                                list.add(new EquipoModel(EquipoModel.IMAGE_TYPE, result.get(contador).getName(), result.get(contador).getSport(), result.get(contador).getPhoto(),result.get(contador).getWin(),result.get(contador).getLost(),result.get(contador).getTie()));
                            }
                            contador += 1;
                        }
                        contador = 0;
                    }
                });
        LEMainAdapter adapter = new LEMainAdapter(list, BusquedaClass.this, new ConstantInterface() {

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
                            }
                        });

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BusquedaClass.this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_equipos);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }


    public void buscarUsuarios() {
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_busqueda:
                this.list = new ArrayList();
                this.realizarbusqueda();
                break;
        }
    }
}
