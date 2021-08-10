package org.aplas.tugas1_rajendra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<ItemModel> Data;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Caption, Headline;
        ImageView Gambar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Headline = itemView.findViewById(R.id.txtName);
            Caption = itemView.findViewById(R.id.txtCaption);
            Gambar = itemView.findViewById(R.id.imageContact);
        }
    }

    ItemAdapter(ArrayList<ItemModel> Data){
        this.Data=Data;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {

        TextView HeadLine=holder.Headline;
        TextView Caption=holder.Caption;
        ImageView Gambar=holder.Gambar;

        HeadLine.setText(Data.get(position).getNama());
        Caption.setText(Data.get(position).getType());
        Gambar.setImageResource(Data.get(position).getGambar());

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }


}
