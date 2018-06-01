package pantallahistorial;

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

public class ResultadoAdapter extends RecyclerView.Adapter {
    private ArrayList<ResultadoModel> dataSet;
    Context mContext;
    int total_types;


    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView mMarcador;
        private ImageView mImage1;
        private ImageView mImage2;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.titulo = (TextView) itemView.findViewById(R.id.textview_resultado_partido);
            this.mMarcador = (TextView) itemView.findViewById(R.id.textview_resultado_marcador);
            this.mImage1 = (ImageView) itemView.findViewById(R.id.imageview_resultado_foto2);
            this.mImage2 = (ImageView) itemView.findViewById(R.id.imageview_resultado_foto);
        }
    }


    public ResultadoAdapter(ArrayList<ResultadoModel> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case ResultadoModel.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_resultado_item, parent, false);
                return new ImageTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return ResultadoModel.IMAGE_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        ResultadoModel object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case ResultadoModel.IMAGE_TYPE:
                    ((ImageTypeViewHolder) holder).titulo.setText(object.mPartido);
                    ((ImageTypeViewHolder) holder).mMarcador.setText(object.mMarcador);
                    Picasso.get().load(object.mFoto1).into(((ResultadoAdapter.ImageTypeViewHolder) holder).mImage1);
                    Picasso.get().load(object.mFoto2).into(((ResultadoAdapter.ImageTypeViewHolder) holder).mImage2);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
