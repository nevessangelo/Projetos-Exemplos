/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Servlet;

import br.inf.puc.Controller.Aluno;
import br.inf.puc.Controller.Colaborador;
import br.inf.puc.Controller.Professor;
import br.inf.puc.Controller.Tipo_Colaborador;
import br.inf.puc.DAO.ColaboradorDAO;
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
@WebServlet(name = "Cadastro", urlPatterns = {"/action_cadastro"})
public class Cadastro extends HttpServlet {

    private final String PAGE = "cadastro.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean error = false;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String pessoa_nome = request.getParameter("nome");
        String pessoa_email = request.getParameter("email");
        Colaborador pessoa = new Colaborador();
        pessoa.setNome(pessoa_nome);
        pessoa.setEmail(pessoa_email);

        String s_tipo = request.getParameter("combo");
        int tipo = Integer.parseInt(s_tipo);
        
        if (tipo == 1) {
            String s_data_ingresso = request.getParameter("data");

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date = (Date) formatter.parse(s_data_ingresso);
                String s_orientador = request.getParameter("orientador");
                int id_orientador = Integer.parseInt(s_orientador);
                
                Professor professor = new Professor();
                professor.setId_professor(id_orientador);
                
                Aluno aluno = new Aluno();
                aluno.setNome(pessoa.getNome());
                aluno.setEmail(pessoa.getEmail());
                aluno.setData_ingresso(date);
                aluno.setOrientador(professor);
                
                Tipo_Colaborador tipo_colaborador = new Tipo_Colaborador();
                tipo_colaborador.setAluno(aluno);
                
                pessoa.setColaborador(tipo_colaborador);
                
                
                
                


                if (aluno.getNome().trim().isEmpty()
                        || aluno.getEmail().trim().isEmpty()
                        || aluno.getData_ingresso() == null
                        || aluno.getOrientador() == null) {
                    error = true;
                    request.getRequestDispatcher("cadastro.jsp").include(request, response);
                    out.print("<script>alert('Campo vazio');</script>");

                }

                if (!error) {
                    boolean retorno;
                    retorno = ColaboradorDAO.InsertAluno(pessoa);
                    if (retorno) {
                        request.getRequestDispatcher("index.jsp").include(request, response);
                        out.print("<script>alert('Cadastro Realizado com Sucesso');</script>");
                    }

                }

            } catch (ParseException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("index.jsp").include(request, response);
                out.print("<script>alert('Erro no Cadastro');</script>");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("index.jsp").include(request, response);
                out.print("<script>alert('Erro no Cadastro');</script>");
            } catch (SQLException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("index.jsp").include(request, response);
                out.print("<script>alert('Erro no Cadastro');</script>");
            }

        }

        if (tipo == 2) {
            String regime_curso = request.getParameter("sel");

            String s_data_ingresso = request.getParameter("datap");

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
              Date date = (Date) formatter.parse(s_data_ingresso);
                String s_orientador = request.getParameter("orientadorp");
                int id_orientador = Integer.parseInt(s_orientador);
                
                Professor professor = new Professor();
                professor.setId_professor(id_orientador);
                
                Aluno aluno = new Aluno();
                aluno.setNome(pessoa.getNome());
                aluno.setEmail(pessoa.getEmail());
                aluno.setData_ingresso(date);
                aluno.setOrientador(professor);
                aluno.setRegime_curso(regime_curso);
                
                
                Tipo_Colaborador tipo_colaborador = new Tipo_Colaborador();
                tipo_colaborador.setAluno(aluno);
                
                pessoa.setColaborador(tipo_colaborador);
                
                
                 if (aluno.getNome().trim().isEmpty()
                        || aluno.getEmail().trim().isEmpty()
                        || aluno.getData_ingresso() == null
                        || aluno.getOrientador() == null) {
                    request.getRequestDispatcher("cadastro.jsp").include(request, response);
                    out.print("<script>alert('Campo vazio');</script>");

                }

                if (!error) {
                    boolean retorno;
                    retorno = ColaboradorDAO.InsertAluno(pessoa);
                    if (retorno) {
                        request.getRequestDispatcher("index.jsp").include(request, response);
                        out.print("<script>alert('Cadastro Realizado com Sucesso');</script>");
                    }

                }

                
                

            } catch (ParseException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("index.jsp").include(request, response);
                out.print("<script>alert('Erro no Cadastro');</script>");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("index.jsp").include(request, response);
                out.print("<script>alert('Erro no Cadastro');</script>");
            } catch (SQLException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                request.getRequestDispatcher("index.jsp").include(request, response);
                out.print("<script>alert('Erro no Cadastro');</script>");
            }
        }

        if (tipo == 3) {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("password");
            Professor professor = new Professor();
            professor.setNome(pessoa.getNome());
            professor.setEmail(pessoa.getEmail());
            professor.setUsuario(usuario);
            professor.setSenha(senha);

            if (pessoa.getNome().trim().isEmpty()
                    || pessoa_email.trim().isEmpty()
                    || professor.getUsuario().trim().isEmpty()
                    || professor.getSenha().trim().isEmpty()) {

                out.print("<script>alert('Campo vazio');</script>");
                request.getRequestDispatcher("cadastro.jsp").include(request, response);

                error = true;
            }
            
            

            if (!error) {
                boolean retorno, retorno2;
                try {
                    int id = ColaboradorDAO.InsertProfessor_login(professor);
                    Tipo_Colaborador tipo_colaborador = new Tipo_Colaborador();
                    professor.setId_professor(id);
                    tipo_colaborador.setProfessor(professor);
                    pessoa.setColaborador(tipo_colaborador);
                    retorno = ColaboradorDAO.InsertProfessor(pessoa);
                    retorno2 = ColaboradorDAO.InsertPermissao(id);
                    if (retorno && retorno2) {
                        request.getRequestDispatcher("index.jsp").include(request, response);
                        out.print("<script>alert('Cadastro Realizado com Sucesso');</script>");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                    request.getRequestDispatcher("index.jsp").include(request, response);
                    out.print("<script>alert('Erro no Cadastro');</script>");
                } catch (SQLException ex) {
                    Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
                    request.getRequestDispatcher("index.jsp").include(request, response);
                    out.print("<script>alert('Erro no Cadastro');</script>");
                }

            }

        }

    }

}
