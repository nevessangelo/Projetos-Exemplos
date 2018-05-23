/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Servlet;

import br.inf.puc.Controller.Projeto;
import br.inf.puc.DAO.ProjetoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "Cadastro_Projeto_Action", urlPatterns = {"/action_cadastro_projeto"})
public class Cadastro_Projeto_Action extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        boolean error = false;
        
//        String[] professores = request.getParameterValues("professores");
//        String[] alunos = request.getParameterValues("alunos");
//        
//        for (int i = 0; i<alunos.length;i++) {
//            
//        }

        String titulo = request.getParameter("nome_projeto");
        String s_data_inicio = request.getParameter("data_inicio");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date_inico = (Date) formatter.parse(s_data_inicio);
            String s_data_termino = request.getParameter("data_termino");
            Date date_termino = (Date) formatter.parse(s_data_termino);
            String agencia = request.getParameter("agencia");
            String s_valor = request.getParameter("valor");
            double valor = Double.parseDouble(s_valor);
            String objetivo = request.getParameter("objetivo");
            String descricao = request.getParameter("descricao");
        
            Projeto projeto = new Projeto();
            projeto.setTitulo(titulo);
            projeto.setData_inicio(date_inico);
            projeto.setData_termino(date_termino);
            projeto.setAgencia(agencia);
            projeto.setValor_financiado(valor);
            projeto.setObjetivo(objetivo);
            projeto.setDescricao(descricao);
            projeto.setStatus("elaboração");
            
            if(projeto.getTitulo().trim().isEmpty() || projeto.getTitulo().trim().isEmpty() ||
                projeto.getData_termino() == null || projeto.getData_inicio() == null ||
                projeto.getAgencia().trim().isEmpty() ||
                projeto.getObjetivo().trim().isEmpty() || projeto.getDescricao().trim().isEmpty()){
                error = true;
                //request.getRequestDispatcher("index.jsp").include(request, response);
                request.getRequestDispatcher("cadastro_projeto.jsp").include(request, response);
                out.print("<script>alert('Campo vazio');</script>");
                
                
            }
            
            if (!error) {
                    boolean retorno;
                    retorno = ProjetoDAO.InsertProjeto(projeto);
                    if (retorno) {
                        request.getRequestDispatcher("index.jsp").include(request, response);
                        out.print("<script>alert('Cadastro Realizado com Sucesso');</script>");
                    }
            }
            
        

        } catch (ParseException ex) {
            Logger.getLogger(Cadastro_Projeto_Action.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("cadastro_projeto.jsp").include(request, response);
            out.print("<script>alert('Campo vazio');</script>");
            //request.getRequestDispatcher("index.jsp").include(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cadastro_Projeto_Action.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("cadastro_projeto.jsp").include(request, response);
            out.print("<script>alert('Campo vazio');</script>");
            
            //request.getRequestDispatcher("index.jsp").include(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro_Projeto_Action.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("cadastro_projeto.jsp").include(request, response);
            out.print("<script>alert('Campo vazio');</script>");
            //request.getRequestDispatcher("index.jsp").include(request, response);
            //out.print("<script>alert('Error');</script>");
        }
        
       

        
    }

    

}
