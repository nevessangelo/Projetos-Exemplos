/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Servlet;

import br.inf.puc.Controller.Projeto;
import br.inf.puc.Controller.Publicacao;
import br.inf.puc.DAO.ProjetoDAO;
import br.inf.puc.DAO.PublicacaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author angelo
 */
@WebServlet(name = "Action_Cadastro_Publicacao", urlPatterns = {"/action_cadastro_publicacao"})
public class Action_Cadastro_Publicacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String titulo_publicacao = request.getParameter("titulo_publicacao");
        String conferencia_publicacao = request.getParameter("conferencia_publicacao");
        String s_ano_publicacao = request.getParameter("ano_publicacao");
        String s_cod_projeto = request.getParameter("projetos");
        String[] s_professores = request.getParameterValues("professores");
        String[] s_alunos = request.getParameterValues("alunos");

        int flag = 0;

        if (titulo_publicacao == null
                || conferencia_publicacao == null
                || s_ano_publicacao == null
                || s_cod_projeto == null) {
            request.getRequestDispatcher("cadastro_publicacao.jsp").include(request, response);
            out.print("<script>alert('Campos Vazio');</script>");
            flag = 1;
        }
        
        if(s_professores == null &&  s_alunos == null){
            request.getRequestDispatcher("cadastro_publicacao.jsp").include(request, response);
            out.print("<script>alert('Professor e alunos vazios');</script>");
            flag = 1;
            
        }
        
        

        int cod_projeto = Integer.parseInt(s_cod_projeto);
        Projeto projeto = new Projeto();
        projeto.setId(cod_projeto);
        ProjetoDAO projetoDAO = new ProjetoDAO();
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
        try {
            if (flag == 0) {
                Publicacao publicacao = new Publicacao();
                publicacao.setTitulo(titulo_publicacao);
                publicacao.setConferencia(s_cod_projeto);

                int ano_publicacao = Integer.parseInt(s_ano_publicacao);

                publicacao.setAno(ano_publicacao);
                publicacao.setProjeto(projeto);

                int id_publicacao = publicacaoDAO.InsertPublicacao(publicacao);
                if(s_professores != null){
                    for (String s_cod_professor : s_professores) {
                        int cod_professor = Integer.parseInt(s_cod_professor);
                        publicacaoDAO.InsertProfessorPublicacao(cod_professor, id_publicacao);
                    }   
                    
                }
                
                if (s_alunos != null) {
                    for (String s_cod_aluno : s_alunos) {
                        int cod_aluno = Integer.parseInt(s_cod_aluno);
                        publicacaoDAO.InsertAlunoPublicacao(cod_aluno, id_publicacao);
                    }

                }
                

                request.getRequestDispatcher("cadastro_publicacao.jsp").include(request, response);
                out.print("<script>alert('Publicação cadastrado com sucesso');</script>");

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Action_Cadastro_Publicacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Action_Cadastro_Publicacao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
