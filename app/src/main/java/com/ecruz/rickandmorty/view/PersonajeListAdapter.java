package com.ecruz.rickandmorty.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ecruz.rickandmorty.R;
import com.ecruz.rickandmorty.model.Personaje;

import java.util.List;

public class PersonajeListAdapter extends RecyclerView.Adapter<PersonajeListAdapter.MyViewHolder> {

    private List<Personaje> personajeList;
    private Context context;

    public PersonajeListAdapter(List<Personaje> personajeList, Context context) {
        this.personajeList = personajeList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_personaje_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textViewNombre.setText(personajeList.get(position).getName());
        holder.textViewEspecie.setText(personajeList.get(position).getSpecies());
        holder.textViewTipo.setText("");
        Glide.with(context).load(personajeList.get(position).getImage()).into(holder.imgViewPersonaje);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(v.getContext(), PersonajeDetalles.class);
                detailIntent.putExtra("PERSONAJE_KEY", personajeList.get(position).getId());
                v.getContext().startActivity(detailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return personajeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewNombre;

        public TextView textViewEspecie;

        public TextView textViewTipo;

        public ImageView imgViewPersonaje;

        public ProgressBar pbLoadImage;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            textViewNombre = itemView.findViewById(R.id.txtViewNombre);
            textViewEspecie = itemView.findViewById(R.id.txtViewEspecie);
            textViewTipo = itemView.findViewById(R.id.txtViewTipo);
            imgViewPersonaje = itemView.findViewById(R.id.imgView_personaje);
            pbLoadImage = itemView.findViewById(R.id.pb_load_image);

        }
    }
}
