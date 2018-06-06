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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.async.future.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import model.Resultado;
import networking.RESTfulClient;
import pantallaequipo.EquipoModel;
import pantallahistorial.ResultadoAdapter;
import pantallahistorial.ResultadoModel;
import sportec3.PantallaPrincipal.R;


public class RetoFragment extends Fragment {
    private Long mId;
    private int contador = 0;

    private ArrayList<EquipoModel> list;

    public RetoFragment() {
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
        View view = inflater.inflate(R.layout.fragment_reto, container, false);
        final ArrayList<ResultadoModel> list = new ArrayList();
        RESTfulClient
                .with(view.getContext().getApplicationContext())
                .getAllResultados(new FutureCallback<List<Resultado>>() {
                    @Override
                    public void onCompleted(Exception e, List<Resultado> result) {
                        System.out.println(result.size());
                        while (contador < result.size()) {
                            list.add(new ResultadoModel(ResultadoModel.IMAGE_TYPE,
                                    result.get(contador).getName(), R.mipmap.facebook_icon,
                                    result.get(contador).getResult()
                                    , result.get(contador).getFoto1()
                                    , result.get(contador).getFoto2()));
                            contador += 1;
                        }
                        contador = 0;
                    }
                });

        ResultadoAdapter adapter = new ResultadoAdapter(list, view.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_retos);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
        return view;
    }

    private void retosBanner() {

    }

}
