/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.DAO;

import br.inf.puc.Conexao.ConexaoMysql;
import br.inf.puc.Controller.Orientacoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angelo
 */
public class OrientacaoDAO {
    
    public static boolean InsertOrientacao(Orientacoes orientacao) throws ClassNotFoundException, SQLException{
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_orientacao VALUES(?,?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, orientacao.getTitulo_trabalho());
            preparedStmt.setInt(3, orientacao.getProfessor().getId());
            preparedStmt.setInt(4, orientacao.getAluno().getId());
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
    
    public static int QuantidadeOrientacoes() {
        int retorno = 0;
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT * FROM tbl_orientacao";
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

    
}
