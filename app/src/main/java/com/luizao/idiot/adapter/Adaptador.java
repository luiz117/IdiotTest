package com.luizao.idiot.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luizao.idiot.R;
import com.luizao.idiot.models.Filme;


import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {


    List<Filme> listaMovies;

    public Adaptador(List<Filme> listaMovie) {
        this.listaMovies = listaMovie;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list,parent,false); //parent.get é onde o componente de lista esta dentro
        return new MyViewHolder(movieItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme movies =  listaMovies.get(position);

        holder.titulo.setText(movies.getTitulo());
        holder.genero.setText(movies.getGenero());
        holder.ano.setText(movies.getAno());
        holder.duracao.setText(movies.getDuracao());

    }

    @Override
    public int getItemCount() {
        return listaMovies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView genero;
        TextView ano;
        TextView duracao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txtTitulo);
            genero = itemView.findViewById(R.id.txtGenero);
            ano = itemView.findViewById(R.id.txtAno);
            duracao = itemView.findViewById(R.id.txtDuracao);
        }
    }
}