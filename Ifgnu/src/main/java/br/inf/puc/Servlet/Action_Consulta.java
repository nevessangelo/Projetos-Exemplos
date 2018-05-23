/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Servlet;

import br.inf.puc.Controller.Colaborador;
import br.inf.puc.DAO.ColaboradorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author angelo
 */
@WebServlet(name = "Action_Consulta", urlPatterns = {"/action_consulta"})
public class Action_Consulta extends HttpServlet {

    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s_cod_professor = request.getParameter("orientador");
        String s_cod_aluno = request.getParameter("aluno");
        int flag = 0;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(s_cod_aluno.isEmpty() && s_cod_professor.isEmpty()){
            request.getRequestDispatcher("consulta.jsp").include(request, response);
            out.print("<script>alert('Selecione pelo menos 1');</script>");
            flag = 1;
            
        }else if(!s_cod_aluno.isEmpty() && !s_cod_professor.isEmpty()){
            request.getRequestDispatcher("consulta.jsp").include(request, response);
            out.print("<script>alert('Selecione no máximo 1 colaborador');</script>");
            flag = 1;
        }
        
        if(flag == 0){
            ColaboradorDAO colaboradordao = new ColaboradorDAO();
           if(!s_cod_professor.isEmpty()){
               int cod_professor = Integer.parseInt(s_cod_professor);
               Colaborador colaborador = colaboradordao.historico_colaborador(cod_professor);
               request.setAttribute("colaborador", colaborador);
               request.getRequestDispatcher("mostrar_colaborador.jsp").forward(request, response);
           }else if(!s_cod_aluno.isEmpty()){
               int cod_aluno = Integer.parseInt(s_cod_aluno);
               Colaborador colaborador = colaboradordao.historico_colaboradorAluno(cod_aluno);
               request.setAttribute("colaborador", colaborador);
               request.getRequestDispatcher("mostrar_colaborador.jsp").forward(request, response);
           } 
           
            
        
        }
        
        
        
        
    }



}
