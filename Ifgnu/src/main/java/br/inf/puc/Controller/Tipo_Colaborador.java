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
public class Tipo_Colaborador {
    private Professor professor;
    private Aluno aluno;
    
    
    
    public Tipo_Colaborador(){
   
    }
    
    public Tipo_Colaborador(Professor professor, Aluno aluno){
        this.professor = professor;
        this.aluno = aluno;
        
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

    



   
    
}
