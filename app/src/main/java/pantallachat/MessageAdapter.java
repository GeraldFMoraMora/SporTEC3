package pantallachat;

/**
 * Created by geraldportatil on 03/06/18.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sportec3.PantallaPrincipal.R;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<Mensaje> mMessages;

    public MessageAdapter(List<Mensaje> messages) {
        mMessages = messages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.layout_message, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Mensaje message = mMessages.get(position);
        viewHolder.setMessage(message.getMessage());
    }

    @Override
    public int getItemCount() {

        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {

        return mMessages.get(position).getType();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mMessageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mMessageView = (TextView) itemView.findViewById(R.id.message);
        }

        public void setMessage(String message) {
            if (null == mMessageView) return;
            if(null == message) return;
            mMessageView.setText(message);
        }
    }
}
