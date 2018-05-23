/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Controller;

/**
 *
 * @author angelo
 */
public class Orientacoes {
    
    private Professor professor;
    private Aluno aluno;
    private String titulo_trabalho;
    
    public Orientacoes(){
        
    }
    
    public Orientacoes(Professor professor, Aluno aluno, String titulo_trabalho){
        this.professor = professor;
        this.aluno = aluno;
        this.titulo_trabalho = titulo_trabalho;
    }

    /**
     * @return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the titulo_trabalho
     */
    public String getTitulo_trabalho() {
        return titulo_trabalho;
    }

    /**
     * @param titulo_trabalho the titulo_trabalho to set
     */
    public void setTitulo_trabalho(String titulo_trabalho) {
        this.titulo_trabalho = titulo_trabalho;
    }
    
    
    
}
