package com.example.sin_fut_oficial2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterRvme extends RecyclerView.Adapter<adapterRvme.MensajeHolder>{
    private List<MensajeVO> lstMensajes;

    public adapterRvme(List<MensajeVO> lstMensajes) {
        this.lstMensajes = lstMensajes;
    }

    @NonNull
    @Override
    public MensajeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message,parent, false);
        return new MensajeHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeHolder holder, int position) {
        holder.tvName.setText(lstMensajes.get(position).getName());
        holder.tvMessage.setText(lstMensajes.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return lstMensajes.size();
    }

    class MensajeHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvMessage;
        public MensajeHolder(@NonNull View itemView) {
            super(itemView);
            tvName =itemView.findViewById(R.id.tvName);
            tvName =itemView.findViewById(R.id.tvMessage);
        }
    }
}
