/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Controller;

import java.io.Serializable;

/**
 *
 * @author angelo
 */
public class Professor extends Colaborador implements Serializable{
    
    private int id_professor;
    private String usuario;
    private String senha;
    
    public Professor(){
        
    }
    
    public Professor(int id_professor, String usuario, String senha){
        this.id_professor = id_professor;
        this.usuario = usuario;
        this.senha = senha;
        
    }
    
    

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the id_professor
     */
    public int getId_professor() {
        return id_professor;
    }

    /**
     * @param id_professor the id_professor to set
     */
    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }


    
    
}
