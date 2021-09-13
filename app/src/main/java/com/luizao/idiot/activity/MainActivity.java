package com.luizao.idiot.activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.luizao.idiot.R;
import com.luizao.idiot.Utils.RecyclerItemClickListener;
import com.luizao.idiot.adapter.Adaptador;
import com.luizao.idiot.models.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerMovies;
    List<Filme> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addMovies();
        setContentView(R.layout.activity_main);
        recyclerMovies = findViewById(R.id.recyclerMovies);
        recyclerMovies.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerMovies.setLayoutManager(layoutManager);

        Adaptador adaptador = new Adaptador(movies);
        recyclerMovies.setAdapter(adaptador);

        recyclerMovies.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

        recyclerMovies.addOnItemTouchListener( new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerMovies,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = movies.get(position);
                        Toast.makeText(getApplicationContext(),"Título " + filme.getTitulo(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = movies.get(position);
                        Toast.makeText(getApplicationContext(), filme.getDuracao(), Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));
    }


    public void addMovies(){
        String titulo = "TITULO ";
        String[] genero = {"Ação", "Comédia"};
        Integer ano = 2000;
        Integer duracao = 70;

        for(int i =0;i<41;i++){

            Filme filme = new Filme(titulo+i,genero[i%2],Integer.toString(ano+i),"Duração: "+ Integer.toString(duracao+(i*2)) + " minutos");
            movies.add(filme);
        }

    }
}