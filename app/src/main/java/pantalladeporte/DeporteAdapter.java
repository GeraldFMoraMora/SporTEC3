package pantalladeporte;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class DeporteAdapter extends BaseAdapter {
    private Context mContext;

    public DeporteAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mThumbIds().size();
    }

    @Override
    public Object getItem(int position) {
        ImageView imageView = new ImageView(mContext);
        return imageView;
    }

    @Override
    public long getItemId(int position) {
        return position;
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
        imageView.setBackgroundColor(Color.WHITE);
        textView = (TextView) convertView.findViewById(R.id.nombre_coche);
        imageView.setImageResource(mThumbIds().get(position));
        textView.setText(mThumbNames().get(position));


        return convertView;
    }

    private List<Integer> mThumbIds() {
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(R.mipmap.logo_artesmarciales);
        myList.add(R.mipmap.logo_atletismo);
        myList.add(R.mipmap.logo_badminton);
        myList.add(R.mipmap.logo_balonmano);
        myList.add(R.mipmap.logo_baseball);
        myList.add(R.mipmap.logo_basquetball);
        myList.add(R.mipmap.logo_ciclismo);
        myList.add(R.mipmap.logo_fisicoculturismo);
        myList.add(R.mipmap.logo_futball);
        myList.add(R.mipmap.logo_kayak);
        myList.add(R.mipmap.logo_pinpong);
        myList.add(R.mipmap.logo_sgrima);
        myList.add(R.mipmap.logo_tennis);
        myList.add(R.mipmap.logo_volleyball);
        return myList;
    }

    private List<String> mThumbNames() {
        List<String> myList = new ArrayList<String>();
        myList.add("Artes marciales");
        myList.add("Atletismo");
        myList.add("Badminton");
        myList.add("Balon mano");
        myList.add("Baseball");
        myList.add("Basketball");
        myList.add("Ciclismo");
        myList.add("Levantamiento de pesas");
        myList.add("Futball");
        myList.add("Kayak");
        myList.add("Ping pong");
        myList.add("Esgrima");
        myList.add("Tennis");
        myList.add("Volleyball");
        return myList;
    }
}
