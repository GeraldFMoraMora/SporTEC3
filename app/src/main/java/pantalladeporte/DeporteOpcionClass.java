package pantalladeporte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import pantallahistorial.ResultadoClass;
import pantallaretos.TabActivity;
import sportec3.PantallaPrincipal.R;


/**
 * Created by GeraldMM on 05/05/2018.
 */

public class DeporteOpcionClass extends AppCompatActivity {

    private Long mId;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcion);

        this.mId = getIntent().getLongExtra("id", 0);

        GridView gridview = (GridView) findViewById(R.id.gridview_layout_opcion);
        gridview.setAdapter(new OpcionAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(DeporteOpcionClass.this, "" + position,
                        Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        mIntent = new Intent(DeporteOpcionClass.this, ResultadoClass.class);
                        mIntent.putExtra("id", mId);
                        startActivity(mIntent);
                        break;
                    case 1:
                        mIntent = new Intent(DeporteOpcionClass.this, DeporteClass.class);
                        mIntent.putExtra("id", mId);
                        startActivity(mIntent);
                        break;
                    case 2:
                        mIntent = new Intent(DeporteOpcionClass.this, TabActivity.class);
                        mIntent.putExtra("id", mId);
                        startActivity(mIntent);
                        break;
                }
            }
        });

    }
}
