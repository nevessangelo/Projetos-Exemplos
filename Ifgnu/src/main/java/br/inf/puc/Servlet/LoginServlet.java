/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.Servlet;

import br.inf.puc.Controller.Professor;
import br.inf.puc.DAO.ColaboradorDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author angelo
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private final String PAGE = "index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario_nome = req.getParameter("usuario");
        String senha = req.getParameter("password");
        boolean error = false;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (usuario_nome.trim().isEmpty()) {
            out.print("<script>alert('Usuário Vazio');</script>");
            error = true;
            
        }

        if (senha.trim().isEmpty()) {
            out.print("<script>alert('Senha Vazia');</script>");
            error = true;
           
        }
         req.getRequestDispatcher(PAGE).include(req, resp);

        if (!error) {
            try {
                ColaboradorDAO colaboradordao = new ColaboradorDAO();
                Professor usuario = colaboradordao.Login(usuario_nome, senha);
                String nivel = colaboradordao.NivelAcesso(usuario.getId());
                if (nivel != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("id", usuario.getId());
                    session.setAttribute("nivel", nivel);
                    

                    //req.getRequestDispatcher("views/logado.jsp").forward(req, resp);
                    resp.sendRedirect("index.jsp");

                } else {
                    out.print("<script>alert('Acesso Negado');</script>");
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.print("<script>alert('Erro no Login');</script>");
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.print("<script>alert('Erro no Login');</script>");
            }

        }

    }

}
