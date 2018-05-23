/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Servlet;

import br.inf.puc.Controller.Colaborador;
import br.inf.puc.Controller.Projeto;
import br.inf.puc.DAO.ProjetoDAO;
import com.lowagie.text.pdf.ByteBuffer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
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
@WebServlet(name = "Action_Status", urlPatterns = {"/action_status"})
public class Action_Status extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProjetoDAO projetodao = new ProjetoDAO();
        
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String id = request.getParameter("id_projeto");
        int id_projeto = Integer.parseInt(id);

        String status = request.getParameter("projeto_status");
        byte[] bytes = status.getBytes(StandardCharsets.ISO_8859_1);
        status = new String(bytes, StandardCharsets.UTF_8);

        final String base64String = request.getParameter("lista_cod_alunos");
        final byte[] objToBytes = Base64.getDecoder().decode(base64String);
        ByteArrayInputStream bais = new ByteArrayInputStream(objToBytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        int flag = 0;
        if (status.equals("elaboração")) {
            try {
                ArrayList<Integer> ids = (ArrayList<Integer>) ois.readObject();
                if (!ids.isEmpty()) {
                    for (Integer cod_aluno : ids) {
                        int numero_projetos = projetodao.VerificaProjeto(cod_aluno, id_projeto);
                        if (numero_projetos >= 2) {
                            flag = 1;
                            break;
                        }
                    }

                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Action_Status.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Action_Status.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (flag == 0) {
                try {
                    if(projetodao.updatestatus(id_projeto)){
                        out.print("<script>alert('Status alterado com sucesso');</script>");
                        request.getRequestDispatcher("visualizar_projeto.jsp").include(request, response);
                        
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Action_Status.class.getName()).log(Level.SEVERE, null, ex);
                    out.print("<script>alert('Erro ao mudar status');</script>");
                    request.getRequestDispatcher("visualizar_projeto.jsp").include(request, response);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Action_Status.class.getName()).log(Level.SEVERE, null, ex);
                    out.print("<script>alert('Erro ao mudar status');</script>");
                    request.getRequestDispatcher("visualizar_projeto.jsp").include(request, response);
                }
                    
            } else {
                request.getRequestDispatcher("visualizar_projeto.jsp").include(request, response);
                out.print("<script>alert('Erro ao mudar status');</script>");
            }

        }else if(status.equals("andamento")){
            try {
                int num_publicacao = projetodao.VerificaPublicacao(id_projeto);
                if(num_publicacao > 0){
                    if(projetodao.updatestatusandamento(id_projeto)){
                        out.print("<script>alert('Alteração Realizada com Sucesso');</script>");
                        request.getRequestDispatcher("visualizar_projeto.jsp").include(request, response);
                        
                    }
                }else{
                    out.print("<script>alert('Não existe publicação associada ao projeto');</script>");
                    request.getRequestDispatcher("visualizar_projeto.jsp").include(request, response);
                    
                    
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Action_Status.class.getName()).log(Level.SEVERE, null, ex);
                out.print("<script>alert('Erro ao mudar status');</script>");
                request.getRequestDispatcher("visualizar_projeto.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Action_Status.class.getName()).log(Level.SEVERE, null, ex);
                out.print("<script>alert('Erro ao mudar status');</script>");
                request.getRequestDispatcher("visualizar_projeto.jsp").include(request, response);
                
            }
        }

       

    }

}
