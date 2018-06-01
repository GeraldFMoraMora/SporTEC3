package sportec3.PantallaPrincipal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import model.Noticia;
import networking.RESTfulClient;
import pantalladeporte.DeporteClass;
import pantallaequipo.EquipoClass;
import pantallahistorial.ResultadoClass;
import pantallanoticia.NoticiaFragment;
import pantallanoticia.NoticiaMainAdapter;
import pantallanoticia.NoticiaMainModel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public String mTituloNoticiaDia;
    public String mFotoNoticiaDia;
    public String mDescripcionDia;

    private ImageView mImagenNoticia;
    private TextView mTituloNoticia;

    private int contador = 0;

    private ArrayList<NoticiaMainModel> mList;

    private ImageView mLogoNav;
    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.mList = new ArrayList();

        this.mLogoNav = (ImageView) findViewById(R.id.nav_logo);

        this.mImagenNoticia = (ImageView) findViewById(R.id.noticia_foto_dia_imageview);
        this.mTituloNoticia = (TextView) findViewById(R.id.noticia_titulo_dia_textview);

        this.noticiaDia();
        this.noticiasBanner();
    }

    private void noticiaDia() {
        RESTfulClient
                .with(getApplicationContext())
                .getAllNoticias(new FutureCallback<List<Noticia>>() {
                    @Override
                    public void onCompleted(Exception e, List<Noticia> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            if (result.get(contador).getToday()) {
                                Picasso.get().load(result.get(contador).getPhoto()).into(mImagenNoticia);
                                mTituloNoticia.setText(result.get(contador).getTitle());
                                mTituloNoticiaDia = result.get(contador).getTitle();
                                mFotoNoticiaDia = result.get(contador).getPhoto();
                                mDescripcionDia = result.get(contador).getDescription();
                                contador = result.size();
                            } else {
                                contador += 1;
                            }
                        }
                        contador = 0;
                        Log.e(" Error: ", "No existe noticia destacada");
                    }
                });
    }

    private void noticiasBanner() {
        this.mList = new ArrayList();
        RESTfulClient
                .with(getApplicationContext())
                .getAllNoticias(new FutureCallback<List<Noticia>>() {
                    @Override
                    public void onCompleted(Exception e, List<Noticia> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            mList.add(new NoticiaMainModel(NoticiaMainModel.IMAGE_TYPE, result.get(contador).getTitle(), result.get(contador).getPhoto(),
                                    result.get(contador).getDescription(), result.get(contador).getToday(), result.get(contador).getId()));
                            contador += 1;
                        }
                        contador = 0;
                        Log.e(" Error: ", "No existe noticia destacada");
                    }
                });
        NoticiaMainAdapter adapter = new NoticiaMainAdapter(mList, MainActivity.this, new ConstantInterface() {

            @Override
            public void onClick(View v, final int position) {
                RESTfulClient
                        .with(getApplicationContext())
                        .getAllNoticias(new FutureCallback<List<Noticia>>() {
                            @Override
                            public void onCompleted(Exception e, List<Noticia> result) {
                                System.out.println(result.size());
                                while (contador < result.size()) {
                                    if (String.valueOf(result.get(contador).getId().equals(String.valueOf(position)))=="true") {
                                        getSupportFragmentManager()
                                                .beginTransaction()
                                                .replace(R.id.main_activity_fragment,
                                                        NoticiaFragment.newInstance(result.get(contador).getTitle(),
                                                                result.get(contador).getPhoto(),
                                                                result.get(contador).getDescription()))
                                                .commit()
                                        ;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.noticia_app_bar_main_recyclerview);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    public void onClick(View view) {
        this.mCardView = (CardView) findViewById(R.id.card_view);
        TextView textView = (TextView) findViewById(R.id.noticia_titulo_layout_card_textview);
        switch (view.getId()) {
            case R.id.noticia_dia_app_bar_main:
                this.mLogoNav.setVisibility(View.VISIBLE);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_activity_fragment,
                                NoticiaFragment.newInstance(mTituloNoticiaDia,
                                        mFotoNoticiaDia,
                                        mDescripcionDia))
                        .commit()
                ;
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent deporteS = new Intent(this, DeporteClass.class);
            startActivity(deporteS);
        } else if (id == R.id.nav_gallery) {
            Intent equipoS = new Intent(this, EquipoClass.class);
            startActivity(equipoS);

        } else if (id == R.id.nav_slideshow) {
            Intent resultadoS = new Intent(this, ResultadoClass.class);
            startActivity(resultadoS);

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
