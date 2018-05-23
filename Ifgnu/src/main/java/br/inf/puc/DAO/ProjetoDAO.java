/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.puc.DAO;

import br.inf.puc.Conexao.ConexaoMysql;
import br.inf.puc.Controller.Aluno;
import br.inf.puc.Controller.Colaborador;
import br.inf.puc.Controller.Professor;
import br.inf.puc.Controller.Projeto;
import br.inf.puc.Controller.Tipo_Colaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angelo
 */
public class ProjetoDAO {

    public static Projeto getProjeto(int id) throws ClassNotFoundException, SQLException {
        Projeto projeto = new Projeto();
        projeto.setId(id);

        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "SELECT * FROM tbl_projeto WHERE cod_projeto = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                String projeto_titulo = rs.getString("projeto_titulo");
                Date data_inicio = rs.getDate("data_inicio_projeto");
                Date data_termino = rs.getDate("data_termino_projeto");
                String agencia = rs.getString("agencia_projeto");
                Double valor = rs.getDouble("valor_financiado_projeto");
                String objetivo_projeto = rs.getString("objetivo_projeto");
                String descricao_projeto = rs.getString("descricao_projeto");
                String status_projeto = rs.getString("status_projeto");

                projeto.setTitulo(projeto_titulo);
                projeto.setData_inicio(data_inicio);
                projeto.setData_termino(data_termino);
                projeto.setAgencia(agencia);
                projeto.setValor_financiado(valor);
                projeto.setObjetivo(objetivo_projeto);
                projeto.setDescricao(descricao_projeto);
                projeto.setStatus(status_projeto);
            }
            preparedStmt.close();
            rs.close();

            ArrayList<Colaborador> colaboradores = new ArrayList<>();
            String query2 = "SELECT a.nome_professor FROM tbl_professor a, tbl_professores_projeto b "
                    + "WHERE b.cod_projeto = ? AND a.cod_professor = b.cod_professor";
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
            preparedStmt2.setInt(1, id);
            ResultSet rs2 = preparedStmt2.executeQuery();
            while (rs2.next()) {
                Professor professor = new Professor();
                String nome_colaborador = rs2.getString("nome_professor");
                professor.setNome(nome_colaborador);
                colaboradores.add(professor);
            }
            preparedStmt2.close();
            rs2.close();

            String query3 = "SELECT a.nome_aluno, a.cod_aluno FROM tbl_aluno a, tbl_alunos_projeto b "
                    + "WHERE b.cod_projeto = ? AND a.cod_aluno = b.cod_aluno";
            PreparedStatement preparedStmt3 = conn.prepareStatement(query3);
            preparedStmt3.setInt(1, id);
            ResultSet rs3 = preparedStmt3.executeQuery();
            while (rs3.next()) {
                Aluno aluno = new Aluno();
                String nome_aluno = rs3.getString("nome_aluno");
                int cod_aluno = rs3.getInt("cod_aluno");
                aluno.setId(cod_aluno);
                aluno.setNome(nome_aluno);
                colaboradores.add(aluno);
            }
            preparedStmt3.close();
            rs3.close();

            projeto.setParticipantes(colaboradores);

        }
        return projeto;

    }

    public static boolean updatestatusandamento(int id_projeto) throws ClassNotFoundException, SQLException {
        int retorno = 0;
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "UPDATE tbl_projeto SET status_projeto = ? WHERE cod_projeto = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "concluído");
            preparedStmt.setInt(2, id_projeto);
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

    public static boolean updatestatus(int id_projeto) throws ClassNotFoundException, SQLException {
        int retorno = 0;
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "UPDATE tbl_projeto SET status_projeto = ? WHERE cod_projeto = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "andamento");
            preparedStmt.setInt(2, id_projeto);
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

    public static int VerificaPublicacao(int id_projeto) throws ClassNotFoundException, SQLException {
        int retorno = 0;
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "SELECT * FROM tbl_publicacao WHERE cod_projeto = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id_projeto);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                retorno++;
            }
            rs.close();
            preparedStmt.close();
        }
        conn.close();
        return retorno;
    }

    public static int VerificaProjeto(int id_projeto, int id_aluno) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        int retorno = 0;
        if (conn != null) {
            String query = "SELECT * FROM tbl_alunos_projeto a, tbl_projeto b WHERE "
                    + "a.cod_projeto = b.cod_projeto AND a.cod_projeto = ? AND a.cod_aluno = ? AND b.status_projeto = 'andamento' ";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id_projeto);
            preparedStmt.setInt(2, id_aluno);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                retorno++;
            }
            rs.close();
            preparedStmt.close();
        }
        conn.close();
        return retorno;

    }

    public ResultSet mostrarProjetosProfessor(int id) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "SELECT a.cod_projeto, a.projeto_titulo, a.status_projeto FROM tbl_projeto a, tbl_professores_projeto b where "
                    + "a.cod_projeto = b.cod_projeto AND b.cod_professor = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            return rs;
        }
        return null;
    }

    public static int QuantidadeProjetosConcluidos() {
        int retorno = 0;
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT projeto_titulo FROM tbl_projeto where status_projeto = 'concluido'";
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

    public static int QuantidadeProjetosElaboracao() {
        int retorno = 0;
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT projeto_titulo FROM tbl_projeto where status_projeto = 'elaboração'";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    retorno++;
                }

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public static int QuantidadeProjetosAndamento() {
        int retorno = 0;
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT projeto_titulo FROM tbl_projeto where status_projeto = 'andamento'";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    retorno++;
                }

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    

    public ResultSet mostrarProjetosAndamento() throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "SELECT cod_projeto, projeto_titulo FROM tbl_projeto where status_projeto = 'andamento'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            return rs;

        }
        return null;
    }

    public ResultSet mostrarProjetos() throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "SELECT cod_projeto, projeto_titulo FROM tbl_projeto";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            ResultSet rs = preparedStmt.executeQuery();
            return rs;

        }
        return null;
    }
    
    public static ArrayList<Projeto> ProjetosOrderByAluno(int id_aluno){
        ArrayList<Projeto> projetos = new ArrayList<>();
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT a.projeto_titulo, a.data_termino_projeto FROM "
                        + "tbl_projeto a, tbl_alunos_projeto b where "
                        + "b.cod_aluno = ? AND a.cod_projeto = b.cod_projeto order by a.data_termino_projeto DESC";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, id_aluno);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    Projeto projeto = new Projeto();
                    projeto.setTitulo(rs.getString("projeto_titulo"));
                    projeto.setData_termino(rs.getDate("data_termino_projeto"));
                    projetos.add(projeto);
                }
                rs.close();
                preparedStmt.close();
            }
            
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return projetos;
        
    }

    public static ArrayList<Projeto> ProjetosOrderByProfessor(int id_professor){
        ArrayList<Projeto> projetos = new ArrayList<>();
        try {
            Connection conn = ConexaoMysql.Conectar();
            if (conn != null) {
                String query = "SELECT a.projeto_titulo, a.data_termino_projeto FROM "
                        + "tbl_projeto a, tbl_professores_projeto b where "
                        + "b.cod_professor = ? AND a.cod_projeto = b.cod_projeto order by a.data_termino_projeto DESC";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, id_professor);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    Projeto projeto = new Projeto();
                    projeto.setTitulo(rs.getString("projeto_titulo"));
                    projeto.setData_termino(rs.getDate("data_termino_projeto"));
                    projetos.add(projeto);
                }
                rs.close();
                preparedStmt.close();
            }
            
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return projetos;
        
    }
    public static boolean VerificaProjetoProfessor(int id_professor, int id_projeto) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        int cont = 0;
        boolean retorno = false;
        if (conn != null) {

            String query = "SELECT * FROM tbl_professores_projeto where cod_projeto = ? AND cod_professor = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id_projeto);
            preparedStmt.setInt(2, id_professor);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                cont++;
            }
            preparedStmt.close();
            rs.close();

        }
        conn.close();
        if (cont > 0) {
            retorno = true;

            return retorno;
        }
        return retorno;
    }

    public static boolean VerificaalunoProjeto(int id_aluno, int id_projeto) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        int cont = 0;
        boolean retorno = false;
        if (conn != null) {

            String query = "SELECT * FROM tbl_alunos_projeto where cod_projeto = ? AND cod_aluno = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id_projeto);
            preparedStmt.setInt(2, id_aluno);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                cont++;
            }
            preparedStmt.close();
            rs.close();

        }
        conn.close();
        if (cont > 0) {
            retorno = true;

            return retorno;
        }
        return retorno;
    }

    public static boolean InserirProjetoProfessor(int id_professor, int id_projeto) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_professores_projeto VALUES(?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            preparedStmt.setInt(2, id_projeto);
            preparedStmt.setInt(3, id_professor);
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

    public static boolean InsertColaborador(int id_aluno, int id_projeto) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_alunos_projeto VALUES(?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            preparedStmt.setInt(2, id_projeto);
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

    public static boolean InsertProjeto(Projeto projeto) throws ClassNotFoundException, SQLException {
        Connection conn = ConexaoMysql.Conectar();
        if (conn != null) {
            String query = "Insert INTO tbl_projeto VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, 0);
            preparedStmt.setString(2, projeto.getTitulo());
            preparedStmt.setObject(3, projeto.getData_inicio());
            preparedStmt.setObject(4, projeto.getData_termino());
            preparedStmt.setString(5, projeto.getAgencia());
            preparedStmt.setDouble(6, projeto.getValor_financiado());
            preparedStmt.setString(7, projeto.getObjetivo());
            preparedStmt.setString(8, projeto.getDescricao());
            preparedStmt.setString(9, projeto.getStatus());
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
