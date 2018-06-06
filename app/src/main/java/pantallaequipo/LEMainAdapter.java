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

import sportec3.PantallaPrincipal.ConstantInterface;
import sportec3.PantallaPrincipal.R;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class LEMainAdapter extends RecyclerView.Adapter implements ConstantInterface {
    private ArrayList<EquipoModel> dataSet;
    Context mContext;
    int total_types;

    public ConstantInterface mConstantInterface;

    @Override
    public void onClick(View v, int position) {

    }


    class ImageTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titulo;
        ImageView mImage;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);
            this.titulo = (TextView) itemView.findViewById(R.id.textview_equipos);
            this.mImage = (ImageView) itemView.findViewById(R.id.imageview_equipos_foto);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mConstantInterface.onClick(v, getAdapterPosition());

        }
    }


    public LEMainAdapter(ArrayList<EquipoModel> data, Context context, ConstantInterface mConstantInterface) {
        this.dataSet = data;
        this.mContext = context;
        this.mConstantInterface = mConstantInterface;
        total_types = dataSet.size();
    }

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

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return EquipoModel.IMAGE_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        EquipoModel object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case EquipoModel.IMAGE_TYPE:
                    ((LEMainAdapter.ImageTypeViewHolder) holder).titulo.setText(object.text);
                    Picasso
                            .get()
                            .load(object.foto)
                            .resize(72, 72)
                            .into(((LEMainAdapter.ImageTypeViewHolder) holder).mImage);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
