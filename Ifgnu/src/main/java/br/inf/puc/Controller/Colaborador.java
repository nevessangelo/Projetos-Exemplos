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
public class Colaborador {
    
    private int id;
    private String nome;
    private String email;
    private Tipo_Colaborador colaborador;
    private ArrayList<Projeto> projetos;
    private ArrayList<Publicacao> publicacao;
    
    public Colaborador(){
        
    }
    
    public Colaborador(int id, String nome, String email, Tipo_Colaborador colaborador, ArrayList<Projeto> projetos,
            ArrayList<Publicacao> publicacao){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.colaborador = colaborador;
        this.projetos = projetos;
        this.publicacao = publicacao;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the colaborador
     */
    public Tipo_Colaborador getColaborador() {
        return colaborador;
    }

    /**
     * @param colaborador the colaborador to set
     */
    public void setColaborador(Tipo_Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    /**
     * @return the projetos
     */
    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }

    /**
     * @param projetos the projetos to set
     */
    public void setProjetos(ArrayList<Projeto> projetos) {
        this.projetos = projetos;
    }

    /**
     * @return the publicacao
     */
    public ArrayList<Publicacao> getPublicacao() {
        return publicacao;
    }

    /**
     * @param publicacao the publicacao to set
     */
    public void setPublicacao(ArrayList<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }
    
    
    
    
    
    
    
}
