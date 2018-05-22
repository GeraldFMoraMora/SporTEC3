package pantallabusqueda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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

    private ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        this.list = new ArrayList();

        this.mEntryBusqueda = (EditText) findViewById(R.id.busqueda_editText);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_busqueda:
                this.list = new ArrayList();
                break;
        }
    }
}
