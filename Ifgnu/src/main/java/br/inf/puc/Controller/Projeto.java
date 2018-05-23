/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author angelo
 */
public class Projeto implements Serializable{
    private int id;
    private String titulo;
    private Date data_inicio;
    private Date data_termino;
    private String agencia;
    private double valor_financiado;
    private String objetivo;
    private String descricao;
    private ArrayList<Colaborador> participantes;
    private String status;
    private ArrayList<Publicacao> publicacao;
    
    public Projeto(){
        
    }
    
    public Projeto(int id, String titulo, Date data_inicio, Date data_termino, 
            String agencia, double valor_financiado, String objetivo,
            String descricao, ArrayList<Colaborador> participantes, String status, ArrayList<Publicacao> publicacao){
        this.id = id;
        this.titulo = titulo;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.agencia = agencia;
        this.valor_financiado = valor_financiado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.participantes = participantes;
        this.status = status;
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
     * @return the data_inicio
     */
    public Date getData_inicio() {
        return data_inicio;
    }

    /**
     * @param data_inicio the data_inicio to set
     */
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    /**
     * @return the data_termino
     */
    public Date getData_termino() {
        return data_termino;
    }

    /**
     * @param data_termino the data_termino to set
     */
    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
    }

    /**
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the valor_financiado
     */
    public double getValor_financiado() {
        return valor_financiado;
    }

    /**
     * @param valor_financiado the valor_financiado to set
     */
    public void setValor_financiado(double valor_financiado) {
        this.valor_financiado = valor_financiado;
    }

    /**
     * @return the objetivo
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * @param objetivo the objetivo to set
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the participantes
     */
    public ArrayList<Colaborador> getParticipantes() {
        return participantes;
    }

    /**
     * @param participantes the participantes to set
     */
    public void setParticipantes(ArrayList<Colaborador> participantes) {
        this.participantes = participantes;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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
