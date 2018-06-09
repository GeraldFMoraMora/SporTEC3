package pantallaequipo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class EquipoAdapter extends RecyclerView.Adapter {
    private ArrayList<EquipoModel> dataSet;
    Context mContext;
    int total_types;


    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {

        TextView mTitulo;
        ImageView mImage;
        TextView mWin;
        TextView mLost;
        TextView mTie;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.mTitulo = (TextView) itemView.findViewById(R.id.textview_equipos);
            this.mImage = (ImageView) itemView.findViewById(R.id.imageview_equipos_foto);
            this.mWin = (TextView) itemView.findViewById(R.id.win_textView);
            this.mLost = (TextView) itemView.findViewById(R.id.lost_textView);
            this.mTie = (TextView) itemView.findViewById(R.id.tie_textView);
        }
    }


    /**
     * Constructor
     *
     * @param data
     * @param context
     */
    public EquipoAdapter(ArrayList<EquipoModel> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }

    /**
     * Metodo en el cual se monta el card  view sobre el layout
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case EquipoModel.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_equipo_item, parent, false);
                return new ImageTypeViewHolder(view);
        }
        return null;
    }

    /**
     * El adaptador recibe un tipo que quiere decir si va a cargar una imagen o un audio
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return EquipoModel.IMAGE_TYPE;
            default:
                return -1;
        }
    }

    /**
     * En este metodo se le cargan los datos a los cardview
     *
     * @param holder
     * @param listPosition
     */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        EquipoModel object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case EquipoModel.IMAGE_TYPE:
                    ((ImageTypeViewHolder) holder).mTitulo.setText(object.text);
                    Picasso.get().load(object.foto).into(((ImageTypeViewHolder) holder).mImage);
                    ((ImageTypeViewHolder) holder).mWin.setText(object.win);
                    ((ImageTypeViewHolder) holder).mLost.setText(object.lost);
                    ((ImageTypeViewHolder) holder).mTie.setText(object.tie);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
