package com.luizao.idiot.models;

import android.widget.TextView;

public class Filme {

    private String titulo;
    private String genero;
    private String ano;
    private String duracao;

    public Filme() {
    }

    public Filme(String titulo, String genero, String ano, String duracao) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.duracao = duracao;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
