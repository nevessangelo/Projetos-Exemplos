/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.DAO;

import br.inf.puc.Conexao.ConexaoMysql;
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
public class PublicacaoDAO {
    
    public static ArrayList<Publicacao> PublicacaoOrderByAluno(int id_aluno){
        ArrayList<Publicacao> publicacoes = new ArrayList<>();
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT a.titulo_publicacao, a.ano_pulicacao FROM "
                        + "tbl_publicacao a, tbl_aluno_publicacao b where "
                        + "b.cod_aluno = ? AND a.cod_publicacao = b.cod_publicacao order by a.ano_pulicacao DESC";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, id_aluno);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    Publicacao publicacao = new Publicacao();
                    publicacao.setTitulo(rs.getString("titulo_publicacao"));
                    publicacao.setAno(rs.getInt("ano_pulicacao"));
                    publicacoes.add(publicacao);
                }
                rs.close();
                preparedStmt.close();
                
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PublicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return publicacoes;
        
    }
    
    public static ArrayList<Publicacao> PubicacaoOrderByProjeto(int id_projeto){
        ArrayList<Publicacao> publicacoes = new ArrayList<>();
        Connection conn;
        try {
            conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT titulo_publicacao, ano_pulicacao FROM "
                        + "tbl_publicacao where "
                        + "cod_projeto = ? order by ano_pulicacao DESC";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, id_projeto);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    Publicacao publicacao = new Publicacao();
                    publicacao.setTitulo(rs.getString("titulo_publicacao"));
                    publicacao.setAno(rs.getInt("ano_pulicacao"));
                    publicacoes.add(publicacao);
                }
                rs.close();
                preparedStmt.close();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PublicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return publicacoes;
    }
    
    public static ArrayList<Publicacao> PublicacaoOrderByProfessor(int id_professor){
        ArrayList<Publicacao> publicacoes = new ArrayList<>();
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT a.titulo_publicacao, a.ano_pulicacao FROM "
                        + "tbl_publicacao a, tbl_professor_publicacao b where "
                        + "b.cod_professor = ? AND a.cod_publicacao = b.cod_publicacao order by a.ano_pulicacao DESC";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, id_professor);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    Publicacao publicacao = new Publicacao();
                    publicacao.setTitulo(rs.getString("titulo_publicacao"));
                    publicacao.setAno(rs.getInt("ano_pulicacao"));
                    publicacoes.add(publicacao);
                }
                rs.close();
                preparedStmt.close();
                
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PublicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return publicacoes;
        
    }
    
     public static int InsertPublicacao(Publicacao publicacao) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_publicacao VALUES(?,?,?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, publicacao.getTitulo());
            preparedStmt.setString(3, publicacao.getConferencia());
            preparedStmt.setInt(4, publicacao.getAno());
            preparedStmt.setInt(5, publicacao.getProjeto().getId());
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
    
    public static boolean InsertProfessorPublicacao(int id_professor, int id_publicacao) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_professor_publicacao VALUES(?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            preparedStmt.setInt(2, id_professor);
            preparedStmt.setInt(3, id_publicacao);
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
    
    
    public static int QuantidadePublicacao() {
        int retorno = 0;
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT * FROM tbl_publicacao";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    retorno++;
                }

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PublicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PublicacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    
    public static boolean InsertAlunoPublicacao(int id_aluno, int id_publicacao) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_aluno_publicacao VALUES(?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            preparedStmt.setInt(2, id_publicacao);
            preparedStmt.setInt(3, id_aluno);
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
        
}
    
    

