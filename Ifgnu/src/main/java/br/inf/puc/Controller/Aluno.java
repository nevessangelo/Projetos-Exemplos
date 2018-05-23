/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Controller;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author angelo
 */
public class Aluno extends Colaborador implements Serializable{
    private Date data_ingresso;
    private String regime_curso;
    private Professor orientador;
   
    
    public Aluno(){
        
    }
    
    public Aluno(Date data_ingresso, String regime_curso, Professor orientador, Tipo_Colaborador tipo_aluno){
        this.data_ingresso = data_ingresso;
        this.regime_curso = regime_curso;
        this.orientador = orientador;
        
    }

    /**
     * @return the data_ingresso
     */
    public Date getData_ingresso() {
        return data_ingresso;
    }

    /**
     * @param data_ingresso the data_ingresso to set
     */
    public void setData_ingresso(Date data_ingresso) {
        this.data_ingresso = data_ingresso;
    }

    /**
     * @return the regime_curso
     */
    public String getRegime_curso() {
        return regime_curso;
    }

    /**
     * @param regime_curso the regime_curso to set
     */
    public void setRegime_curso(String regime_curso) {
        this.regime_curso = regime_curso;
    }

    /**
     * @return the orientador
     */
    public Professor getOrientador() {
        return orientador;
    }

    /**
     * @param orientador the orientador to set
     */
    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

   
    
    
    
}
