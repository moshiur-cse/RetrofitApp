package com.moshiurcse.myapplication.flowers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moshiurcse.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder> {

    private final String IMAGE_URL="http://services.hanselandpetal.com/photos/";
    private Context context;
    private List<Flower> flowerList;

    public FlowerAdapter(Context context, List<Flower> flowerList) {
        this.context = context;
        this.flowerList = flowerList;
    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.flower_row,parent,false);
        return new FlowerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {
        holder.nameTV.setText(flowerList.get(position).getName());
        holder.priceTV.setText(""+flowerList.get(position).getPrice());

        String imageFullPath=IMAGE_URL+flowerList.get(position).getPhoto();
        Picasso.get().load(imageFullPath).into(holder.flowerImageIV);

    }

    @Override
    public int getItemCount() {
        return flowerList.size();
    }

    class FlowerViewHolder extends RecyclerView.ViewHolder {
        ImageView flowerImageIV;
        TextView nameTV,priceTV;
        public FlowerViewHolder(@NonNull View itemView) {
            super(itemView);

            flowerImageIV=itemView.findViewById(R.id.row_flower_image_id);
            nameTV=itemView.findViewById(R.id.row_flower_name_id);
            priceTV=itemView.findViewById(R.id.row_flower_prize_id);



        }
    }
}
