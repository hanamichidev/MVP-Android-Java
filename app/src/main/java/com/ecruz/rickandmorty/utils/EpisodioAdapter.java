package com.ecruz.rickandmorty.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecruz.rickandmorty.R;

import java.util.List;

public class EpisodioAdapter extends RecyclerView.Adapter<EpisodioAdapter.ViewHolder> {

    List<String> Episodio;

    public EpisodioAdapter(List<String> episodio) {
        Episodio = episodio;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episodio_row_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String episode = Episodio.get(position).substring(Episodio.get(position).length()-1);
        holder.NoEpisodio.setText(episode);
    }

    @Override
    public int getItemCount() {
        return Episodio.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView NoEpisodio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            NoEpisodio = itemView.findViewById(R.id.episodiodetails);
        }
    }
}
