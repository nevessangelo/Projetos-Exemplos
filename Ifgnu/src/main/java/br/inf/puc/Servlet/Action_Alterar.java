/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Servlet;

import br.inf.puc.Controller.Colaborador;
import br.inf.puc.Controller.Projeto;
import br.inf.puc.DAO.ColaboradorDAO;
import br.inf.puc.DAO.ProjetoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "Action_Alterar", urlPatterns = {"/action_alterar"})
public class Action_Alterar extends HttpServlet {

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
        boolean error2 = false;
        String id_projeto = request.getParameter("id");
        int value_id_projeto = Integer.parseInt(id_projeto);
        String[] professores = request.getParameterValues("professores");
        String[] alunos = request.getParameterValues("alunos");
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<Integer> ids_professor = new ArrayList<>();
        ProjetoDAO projetodao = new ProjetoDAO();
        if (professores == null) {
            error = true;
            request.getRequestDispatcher("listar_projetos.jsp").include(request, response);
            out.print("<script>alert('Escolha pelo menos um professor');</script>");
        } else {
            for (String id_colaborador_professor : professores) {
                int id_colaborador_professor_value = Integer.parseInt(id_colaborador_professor);
                ids_professor.add(id_colaborador_professor_value);
            }

        }

        if (!error) {
            boolean error3 = false;
            String nome_aluno = null;
            if (alunos != null) {
                ColaboradorDAO colaboradordao = new ColaboradorDAO();
                for (String id_colaborador : alunos) {
                    int id_colaborador_value = Integer.parseInt(id_colaborador);
                    try {
                        nome_aluno = colaboradordao.GetNome(id_colaborador_value);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Action_Alterar.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Action_Alterar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        if (colaboradordao.VerificaGraduacao(id_colaborador_value)) {
                            int numero_projetos = projetodao.VerificaProjeto(id_colaborador_value, value_id_projeto);
                            if (numero_projetos < 2) {
                                ids.add(id_colaborador_value);
                            } else {
                                error3 = true;
                                request.getRequestDispatcher("listar_projetos.jsp").include(request, response);
                                out.print("<script>alert('Aluno " + nome_aluno + " esta em dois projetos');</script>");
                            }
                        } else {
                            ids.add(id_colaborador_value);
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Action_Alterar.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Action_Alterar.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                int flag1 = 0;
                int flag2 = 0;
                if (!error3 && !error) {
                    for (Integer id_professor : ids_professor) {
                        try {
                            if(projetodao.InserirProjetoProfessor(id_professor, value_id_projeto)){
                                flag1 = 1;
                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Action_Alterar.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Action_Alterar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    for (Integer id : ids) {
                        try {
                            if(projetodao.InsertColaborador(id, value_id_projeto)){
                                flag2 = 1;
                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Action_Alterar.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Action_Alterar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if(flag1 == 1 || flag2 == 2){
                        request.getRequestDispatcher("index.jsp").include(request, response);
                        out.print("<script>alert('Cadastrado com Sucesso');</script>");
                        
                    }

                }
            }

        }

    }
}
