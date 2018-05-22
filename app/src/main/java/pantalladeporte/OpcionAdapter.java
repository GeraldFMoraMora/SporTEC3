package pantalladeporte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class OpcionAdapter extends BaseAdapter {
    private Context mContext;

    public OpcionAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView textView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_grid_item, parent, false);
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            //imageView.setLayoutParams(new ViewGroup.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(8, 8, 8, 8);
            textView = new TextView(mContext);
            textView.setText("gerald");
        }

        imageView = (ImageView) convertView.findViewById(R.id.imagen_coche);
        textView = (TextView) convertView.findViewById(R.id.nombre_coche);
        imageView.setImageResource(mThumbIds[position]);
        textView.setText(mThumbNames[position]);
        return convertView;
    }

    private Integer[] mThumbIds = {
            R.mipmap.historial_logo, R.mipmap.equipo_logo,
            R.mipmap.reto_logo
    };
    private String[] mThumbNames = {
            "Historial", "Equipo",
            "Retos"
    };
}
