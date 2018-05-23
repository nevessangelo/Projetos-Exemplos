/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Servlet;

import br.inf.puc.Controller.Aluno;
import br.inf.puc.Controller.Orientacoes;
import br.inf.puc.Controller.Professor;
import br.inf.puc.DAO.OrientacaoDAO;
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
@WebServlet(name = "Action_Cadastro_Orientacao", urlPatterns = {"/action_orientacao"})
public class Action_Cadastro_Orientacao extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo_orientacao");
        String s_id_professor = request.getParameter("orientador");
        String s_id_aluno = request.getParameter("aluno");
        
        int id_professor = Integer.parseInt(s_id_professor);
        int id_aluno = Integer.parseInt(s_id_aluno);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int flag = 0;
        if(titulo.isEmpty()|| s_id_professor.isEmpty() || s_id_aluno.isEmpty()){
            request.getRequestDispatcher("cadastro_orientacao.jsp").include(request, response);
            out.print("<script>alert('Campo vazio');</script>");
            flag = 1;
        }
        
        if(flag == 0){
            OrientacaoDAO orientacaodao = new OrientacaoDAO();
            Professor professor = new Professor();
            professor.setId(id_professor);
            
            Aluno aluno = new Aluno();
            aluno.setId(id_aluno);
            
            Orientacoes orientacao = new Orientacoes();
            orientacao.setTitulo_trabalho(titulo);
            orientacao.setProfessor(professor);
            orientacao.setAluno(aluno);
            
            try {
                if(orientacaodao.InsertOrientacao(orientacao)){
                    request.getRequestDispatcher("index.jsp").include(request, response);
                    out.print("<script>alert('Cadastrado Com Sucesso');</script>");
                    
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Action_Cadastro_Orientacao.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("cadastro_orientacao.jsp").include(request, response);
                out.print("<script>alert('Erro');</script>");
            } catch (SQLException ex) {
                Logger.getLogger(Action_Cadastro_Orientacao.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("cadastro_orientacao.jsp").include(request, response);
                out.print("<script>alert('Erro');</script>");
            }
        }
        
    }

   

}
