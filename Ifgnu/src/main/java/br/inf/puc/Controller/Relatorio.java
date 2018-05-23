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
public interface Relatorio {
    
    public int numero_colaboradores();
    
    public int projetos_elaboracao();
    
    public int projetos_andamento();
    
    public int projetos_concluidos();
    
    public int total_projetos();
    
    public int quantidade_publicacoes();
    
    public int quantidade_orientacoes();
    
}
