/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.DAO;

import br.inf.puc.Conexao.ConexaoMysql;
import br.inf.puc.Controller.Colaborador;
import br.inf.puc.Controller.Professor;
import br.inf.puc.Controller.Projeto;
import br.inf.puc.Controller.Publicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angelo
 */
public class ColaboradorDAO {
    
     public static String NivelAcesso(int id) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        String acesso = null;
        if (conn != null) {
            String query = "SELECT * FROM tbl_acesso WHERE cod_login = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                acesso = rs.getString("acesso_nivel");
            }
            preparedStmt.close();
            rs.close();
        }
        conn.close();
        return acesso;
    }

    public static Professor Login(String user, String senha) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "SELECT * FROM tbl_login WHERE nome_login = ? AND senha_login = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, user);
            preparedStmt.setString(2, senha);
            ResultSet rs = preparedStmt.executeQuery();
            Professor usuario = new Professor();
            while (rs.next()) {
                int id = rs.getInt("id_login");
                String nome_usuario = rs.getString("nome_login");
                String senha_usuario = rs.getString("senha_login");
                usuario.setId(id);
                usuario.setUsuario(nome_usuario);
                usuario.setSenha(senha);
            }
            preparedStmt.close();
            rs.close();
            conn.close();
            return usuario;
        }
        return null;

    }
    
    public int QuantidadeProfessores(){
        int retorno = 0;
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                 String query = "SELECT DISTINCT nome_professor FROM tbl_professor";
                 PreparedStatement preparedStmt = conn.prepareStatement(query);
                 ResultSet rs = preparedStmt.executeQuery();
                 while(rs.next()){
                     retorno++;
                 }
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public ResultSet mostrarProfessores() throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "SELECT cod_professor, nome_professor FROM tbl_professor";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            return rs;

        }
        return null;

    }

//    public static int GetIdProfessor(String email) throws ClassNotFoundException, SQLException {
//        Connection conn = ConexaoMysql.Conectar();
//        int id = 0;
//        if (conn != null) {
//            String query = "Select cod_professor FROM tbl_professor Where email_professor = ?";
//            PreparedStatement preparedStmt = conn.prepareStatement(query);
//            preparedStmt.setString(1, email);
//            ResultSet rs = preparedStmt.executeQuery();
//            while (rs.next()) {
//                id = rs.getInt("cod_professor");
//            }
//            preparedStmt.close();
//            rs.close();
//        }
//        conn.close();
//        return id;
//
//    }

    public static boolean InsertPermissao(int id_login) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_acesso VALUES(?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, "Gerente");
            preparedStmt.setInt(3, id_login);
            int rs = preparedStmt.executeUpdate();
            if (rs == 1) {
                preparedStmt.close();
                conn.close();
                return true;

            }

        }
        conn.close();
        return false;
    }

    public static boolean InsertProfessor(Colaborador colaborador) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_professor VALUES(?,?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, colaborador.getNome());
            preparedStmt.setString(3, colaborador.getEmail());
            preparedStmt.setInt(4, colaborador.getColaborador().getProfessor().getId_professor());
            int rs = preparedStmt.executeUpdate();
            if (rs == 1) {
                preparedStmt.close();
                conn.close();
                return true;

            }

        }
        conn.close();
        return false;
    }

    public static int InsertProfessor_login(Professor professor) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_login VALUES(?,?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, professor.getUsuario());
            preparedStmt.setString(3, professor.getSenha());
            preparedStmt.setString(4, "Gerente");
            int rs = preparedStmt.executeUpdate();
            if (rs == 1) {
                ResultSet keys = preparedStmt.getGeneratedKeys();
                keys.next();
                int key = keys.getInt(1);
                preparedStmt.close();
                conn.close();
                return key;
            }
        }

        conn.close();
        return 0;
    }

    
      public static String GetNome(int id) throws ClassNotFoundException, SQLException {
        String retorno = null;
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "SELECT nome_aluno FROM tbl_aluno WHERE cod_aluno = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                retorno = rs.getString("nome_aluno");
            }
            rs.close();
            preparedStmt.close();
        }
        conn.close();
        return retorno;
    }

    public int QuantidadeAlunos() {
        int retorno = 0;
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT DISTINCT nome_aluno FROM tbl_aluno";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    retorno++;
                }

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;

    }

    public ResultSet mostrarAlunos() throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "SELECT cod_aluno, nome_aluno FROM tbl_aluno";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            return rs;

        }
        return null;

    }

    public static boolean VerificaGraduacao(int id) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        boolean retorno = false;
        if (conn != null) {
            String query = "SELECT * FROM tbl_aluno WHERE cod_aluno = ? AND regime_curso IS NULL";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                retorno = true;
            }
            rs.close();
            preparedStmt.close();
        }
        conn.close();
        return retorno;
    }

    public static boolean InsertAluno(Colaborador colaborador) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_aluno VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, colaborador.getNome());
            preparedStmt.setString(3, colaborador.getEmail());
            preparedStmt.setObject(4, colaborador.getColaborador().getAluno().getData_ingresso());
            preparedStmt.setInt(5, colaborador.getColaborador().getAluno().getOrientador().getId_professor());

            if (colaborador.getColaborador().getAluno().getRegime_curso() == null) {
                preparedStmt.setString(6, null);
            } else {
                preparedStmt.setString(6, colaborador.getColaborador().getAluno().getRegime_curso());
            }

            int rs = preparedStmt.executeUpdate();
            if (rs == 1) {
                preparedStmt.close();
                conn.close();
                return true;

            }
        }
        conn.close();
        return false;

    }
    
    
    public static Colaborador historico_colaboradorAluno(int id) {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(id);
        Connection conn;
        try {
            conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT nome_aluno, email_aluno FROM tbl_aluno WHERE cod_aluno = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, id);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    colaborador.setNome(rs.getString("nome_aluno"));
                    colaborador.setEmail(rs.getString("email_aluno"));
                }
                preparedStmt.close();
                rs.close();

                ProjetoDAO projetodao = new ProjetoDAO();
                PublicacaoDAO publicacaodao = new PublicacaoDAO();
                ArrayList<Projeto> list_projeto = projetodao.ProjetosOrderByAluno(id);
                ArrayList<Publicacao> list_publicacao = publicacaodao.PublicacaoOrderByAluno(id);
                colaborador.setProjetos(list_projeto);
                colaborador.setPublicacao(list_publicacao);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return colaborador;
    }

    public static Colaborador historico_colaborador(int id) {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(id);
        Connection conn;
        try {
            conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT nome_professor, email_professor FROM tbl_professor WHERE cod_professor = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, id);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    colaborador.setNome(rs.getString("nome_professor"));
                    colaborador.setEmail(rs.getString("email_professor"));
                }
                preparedStmt.close();
                rs.close();

                ProjetoDAO projetodao = new ProjetoDAO();
                PublicacaoDAO publicacaodao = new PublicacaoDAO();
                ArrayList<Projeto> list_projeto = projetodao.ProjetosOrderByProfessor(id);
                ArrayList<Publicacao> list_publicacao = publicacaodao.PublicacaoOrderByProfessor(id);
                colaborador.setProjetos(list_projeto);
                colaborador.setPublicacao(list_publicacao);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return colaborador;
    }

}
