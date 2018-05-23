/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Controller;

import br.inf.puc.DAO.ColaboradorDAO;
import br.inf.puc.DAO.OrientacaoDAO;

import br.inf.puc.DAO.ProjetoDAO;
import br.inf.puc.DAO.PublicacaoDAO;

/**
 *
 * @author angelo
 */
public class Emitir_Relatorio implements Relatorio{

    @Override
    public int numero_colaboradores() {
        int total_colaboradores = 0;
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        int total_professor = colaboradorDAO.QuantidadeProfessores();
        int total_aluno = colaboradorDAO.QuantidadeAlunos();
        total_colaboradores = total_professor + total_aluno;
        return total_colaboradores;
    }

    @Override
    public int projetos_elaboracao() {
        int total_projetos = 0;
        ProjetoDAO projetodao = new ProjetoDAO();
        total_projetos = projetodao.QuantidadeProjetosElaboracao();
        return total_projetos;
    }

    @Override
    public int projetos_andamento() {
        int total_projetos = 0;
        ProjetoDAO projetodao = new ProjetoDAO();
        total_projetos = projetodao.QuantidadeProjetosAndamento();
        return total_projetos;
    }

    @Override
    public int projetos_concluidos() {
        int total_projetos = 0;
        ProjetoDAO projetodao = new ProjetoDAO();
        total_projetos = projetodao.QuantidadeProjetosConcluidos();
        return total_projetos;
    }

    @Override
    public int total_projetos() {
        int projetos_concluidos = this.projetos_concluidos();
        int projetos_andamento = this.projetos_andamento();
        int projetos_elaboracao = this.projetos_elaboracao();
        return projetos_concluidos + projetos_andamento + projetos_elaboracao;
    }

    @Override
    public int quantidade_publicacoes(){
        int quantidade = 0;
        PublicacaoDAO publicacaodao = new PublicacaoDAO();
        quantidade = publicacaodao.QuantidadePublicacao();
        return quantidade;
    }
    
    @Override
    public int quantidade_orientacoes(){
        int quantidade = 0;
        OrientacaoDAO orientacaodao = new OrientacaoDAO();
        quantidade = orientacaodao.QuantidadeOrientacoes();
        return quantidade;
    }
    

   
}
