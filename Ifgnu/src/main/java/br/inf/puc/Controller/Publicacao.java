/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Controller;

import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class Publicacao {
    private String titulo;
    private String conferencia;
    private int ano;
    private Projeto projeto;
    private ArrayList<Colaborador> colaboradores;
    
    public Publicacao(){
        
    }
    
    public Publicacao(String titulo, String conferencia, int ano, Projeto projeto, ArrayList<Colaborador> colaboradores){
        this.titulo = titulo;
        this.conferencia = conferencia;
        this.ano = ano;
        this.projeto = projeto;
        this.colaboradores = colaboradores;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the conferencia
     */
    public String getConferencia() {
        return conferencia;
    }

    /**
     * @param conferencia the conferencia to set
     */
    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the projeto
     */
    public Projeto getProjeto() {
        return projeto;
    }

    /**
     * @param projeto the projeto to set
     */
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    /**
     * @return the colaboradores
     */
    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    /**
     * @param colaboradores the colaboradores to set
     */
    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
    
    
    
}
