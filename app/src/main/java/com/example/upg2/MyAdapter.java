package com.example.upg2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    int images[];
    String description[], nom[];
    Context context;

    public MyAdapter(int[] images, String[] description, String[] nom, Context context) {
        this.images = images;
        this.description = description;
        this.nom = nom;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ligne, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imageView.setImageResource(images[position]);
        holder.txt_description.setText(description[position]);
        holder.txt_nom.setText(nom[position]);

        holder.ligne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailsActivity.class);

                intent.putExtra("name",nom[position]);
                intent.putExtra("description",description[position]);
                intent.putExtra("image",images[position]);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nom.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout ligne;
        ImageView imageView;
        TextView txt_nom, txt_description;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ligne = itemView.findViewById(R.id.ligne);
            imageView = itemView.findViewById(R.id.image_view_language);
            txt_nom = itemView.findViewById(R.id.text_view_nom);
            txt_description = itemView.findViewById(R.id.text_view_description);
        }
    }
}
