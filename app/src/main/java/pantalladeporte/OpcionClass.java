package pantalladeporte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import pantallaequipo.EquipoClass;
import sportec3.PantallaPrincipal.R;


/**
 * Created by GeraldMM on 05/05/2018.
 */

public class OpcionClass extends AppCompatActivity {
    private GridView mGridView;

    private Intent mScreen;
    private Toolbar mToolbar;
    private ImageView mLogoNav;

    private Long mId;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_opcion);

        this.mId = getIntent().getLongExtra("id", 0);

        GridView gridview = (GridView) findViewById(R.id.gridview_layout_opcion);
        gridview.setAdapter(new OpcionAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(OpcionClass.this, "" + position,
                        Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        mIntent = new Intent(OpcionClass.this, EquipoClass.class);
                        mIntent.putExtra("id", mId);
                        startActivity(mIntent);
                        break;
                    case 1:
                        mIntent = new Intent(OpcionClass.this, EquipoClass.class);
                        mIntent.putExtra("id", mId);
                        startActivity(mIntent);
                        break;
                    case 2:
                        mIntent = new Intent(OpcionClass.this, EquipoClass.class);
                        mIntent.putExtra("id", mId);
                        startActivity(mIntent);
                        break;
                }
            }
        });

    }
}
