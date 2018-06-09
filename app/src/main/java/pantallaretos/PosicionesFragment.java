package pantallaretos;

/**
 * Created by GeraldMM on 05/05/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import model.Equipo;
import networking.RESTfulClient;
import pantallaequipo.EquipoModel;
import pantallaequipo.LEMainAdapter;
import sportec3.PantallaPrincipal.ConstantInterface;
import sportec3.PantallaPrincipal.R;


public class PosicionesFragment extends Fragment {
    private int contador = 0;

    private ArrayList<EquipoModel> list;

    public PosicionesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_posiciones, container, false);

        this.list = new ArrayList();
        RESTfulClient
                .with(view.getContext().getApplicationContext())
                .getAllEquipos(new FutureCallback<List<Equipo>>() {
                    @Override
                    public void onCompleted(Exception e, List<Equipo> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            list.add(new EquipoModel(EquipoModel.IMAGE_TYPE, result.get(contador).getName(), result.get(contador).getSport(), result.get(contador).getPhoto(),result.get(contador).getWin(),result.get(contador).getLost(),result.get(contador).getTie()));
                            contador += 1;
                        }
                        contador = 0;
                        Log.e(" Error: ", "No existe noticia destacada");
                    }
                });
        LEMainAdapter adapter = new LEMainAdapter(list, view.getContext(), new ConstantInterface() {

            @Override
            public void onClick(View v, final int position) {


                contador = 0;
                RESTfulClient
                        .with(view.getContext().getApplicationContext())
                        .getAllEquipos(new FutureCallback<List<Equipo>>() {
                            @Override
                            public void onCompleted(Exception e, List<Equipo> result) {
                                System.out.println(result.size());
                                while (contador < result.size()) {
                                    if (contador == position) {
                                        Toast.makeText(view.getContext().getApplicationContext(), result.get(contador).getName(), Toast.LENGTH_SHORT).show();

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_posiciones);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
        return view;
    }

}
