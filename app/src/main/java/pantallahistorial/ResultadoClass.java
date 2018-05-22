package pantallahistorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class ResultadoClass extends AppCompatActivity {
    private GridView mGridView;

    private Intent mScreen;
    private Toolbar mToolbar;
    private ImageView mLogoNav;

    private ImageView mImagenNoticia;
    private TextView MTituloNoticia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultado);

        ArrayList<ResultadoModel> list= new ArrayList();
        list.add(new ResultadoModel(ResultadoModel.IMAGE_TYPE,"Barcelona - Real Madrid", R.mipmap.facebook_icon,"1-1"));
        list.add(new ResultadoModel(ResultadoModel.IMAGE_TYPE,"LDA - San Jose",R.mipmap.facebook_icon,"5-1"));
        list.add(new ResultadoModel(ResultadoModel.IMAGE_TYPE,"PZ - Limon FC",R.mipmap.facebook_icon,"3-2"));
        list.add(new ResultadoModel(ResultadoModel.IMAGE_TYPE,"Hediano - Saprisa",R.mipmap.facebook_icon,"0-0"));

        ResultadoAdapter adapter = new ResultadoAdapter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_resultado);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

    }
}
