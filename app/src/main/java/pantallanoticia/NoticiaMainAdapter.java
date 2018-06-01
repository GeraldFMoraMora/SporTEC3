package pantallanoticia;

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

public class NoticiaMainAdapter extends RecyclerView.Adapter implements ConstantInterface {
    private ArrayList<NoticiaMainModel> dataSet;
    Context mContext;
    int total_types;

    public ConstantInterface mConstantInterface;

    private Context mContext1;

    @Override
    public void onClick(View v, int position) {

    }


    class ImageTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mTitulo;
        ImageView mImage;
        TextView mDescripcion;
        TextView mId;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);
            this.mDescripcion = (TextView) itemView.findViewById(R.id.noticia_descripcion_layout_card_textview);
            this.mTitulo = (TextView) itemView.findViewById(R.id.noticia_titulo_layout_card_textview);
            this.mImage = (ImageView) itemView.findViewById(R.id.noticia_foto_layout_card_imageview);
            this.mId = (TextView) itemView.findViewById(R.id.id_textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mConstantInterface.onClick(v, getAdapterPosition());

        }
    }


    public NoticiaMainAdapter(ArrayList<NoticiaMainModel> data, Context context, ConstantInterface mConstantInterface) {
        this.dataSet = data;
        this.mContext = context;
        this.mConstantInterface = mConstantInterface;
        total_types = dataSet.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case NoticiaMainModel.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_noticia_item, parent, false);
                return new ImageTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return NoticiaMainModel.IMAGE_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        NoticiaMainModel object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case NoticiaMainModel.IMAGE_TYPE:
                    ((ImageTypeViewHolder) holder).mTitulo.setText(object.titulo);
                    ((ImageTypeViewHolder) holder).mDescripcion.setText(object.descripcion);
                    ((ImageTypeViewHolder) holder).mId.setText(object.id);
                    mContext1 = ((ImageTypeViewHolder) holder).mImage.getContext();
                    int idFoto = mContext1.getResources().getIdentifier(object.foto, "mipmap", mContext1.getPackageName());
                    //((ImageTypeViewHolder) holder).mImage.setImageResource(idFoto);
                    Picasso.get().load(object.foto).into(((ImageTypeViewHolder) holder).mImage);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
