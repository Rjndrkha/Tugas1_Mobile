package org.aplas.tugas1_rajendra.recycle_data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.aplas.tugas1_rajendra.R;
import org.aplas.tugas1_rajendra.calculator.MainCalculator;
import org.aplas.tugas1_rajendra.persistance_data.Internal;
import org.aplas.tugas1_rajendra.maps.MainActivity ;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<ItemModel> Data;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Caption, Headline;
        ImageView Gambar;

        LinearLayoutCompat Parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Headline = itemView.findViewById(R.id.txtName);
            Caption = itemView.findViewById(R.id.txtCaption);
            Gambar = itemView.findViewById(R.id.imageContact);
            Parent = itemView.findViewById(R.id.Parent);
        }
    }

    public ItemAdapter(Context context,ArrayList<ItemModel> Data){
        this.context=context;

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

        holder.Parent.setOnClickListener(v ->{

            if(Data.get(position).getNama().equals("R Calculator")) {
                Toast.makeText(context, "Redirecting To " + Data.get(position).getNama(), Toast.LENGTH_LONG).show();
                context.startActivity(new Intent(context, MainCalculator.class));
            }else if(Data.get(position).getNama().equals("Persistence App")){
                Toast.makeText(context, "Redirecting To " + Data.get(position).getNama(), Toast.LENGTH_LONG).show();
                context.startActivity(new Intent(context, Internal.class));
            }else if(Data.get(position).getNama().equals("R Location Detected")){
                Toast.makeText(context, "Redirecting To " + Data.get(position).getNama(), Toast.LENGTH_LONG).show();
                context.startActivity(new Intent(context,MainActivity.class));
            }else if(Data.get(position).getNama().equals("Save You'R Contact")){
                Toast.makeText(context, "Redirecting To " + Data.get(position).getNama(), Toast.LENGTH_LONG).show();
                context.startActivity(new Intent(context,MainActivity.class));

            }else{
                Toast.makeText(context,"App "+Data.get(position).getNama(), Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }


}
