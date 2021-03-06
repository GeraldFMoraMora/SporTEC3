package pantallahistorial;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;

import java.util.ArrayList;
import java.util.List;

import model.Resultado;
import networking.RESTfulClient;
import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class ResultadoClass extends FragmentActivity {

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        final ArrayList<ResultadoModel> list = new ArrayList();
        RESTfulClient
                .with(getApplicationContext())
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

        ResultadoAdapter adapter = new ResultadoAdapter(list, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_resultado);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

    }
}
