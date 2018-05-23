<%-- 
    Document   : alterar_projeto
    Created on : May 1, 2018, 11:18:01 AM
    Author     : angelo
--%>

<%@page import="br.inf.puc.DAO.ProjetoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%
    if (session.getAttribute("nivel").equals("Administrador")) {

%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:import url="cabecalho.jsp"/>
<c:import url="menu.jsp"/>

<div class="container theme-showcase" role="main">
    <div class="jumbotron">
        <h1>Ifgnu</h1>
        <p>Sistema de Produção Acadêmica</p>
    </div>
    <hr>
</div>

<center>
    <%  String value_id = request.getParameter("id");
        int cod_projeto = Integer.parseInt(value_id);
        ProjetoDAO projetodao = new ProjetoDAO();
    %>
    <form class="form-horizontal" method="post"
          action="action_alterar" role="form">
        <jsp:useBean id="cn" class="br.inf.puc.DAO.ColaboradorDAO" scope="page"> </jsp:useBean>
        <%                    ResultSet rs = cn.mostrarProfessores();
        %>

        <div class="form-group">
            <label for="professores" class="col-sm-5 control-label">Professores </label>
            <div class="col-sm-2">
                <%
                    while (rs.next()) {
                        if (!projetodao.VerificaProjetoProfessor(rs.getInt("cod_professor"), cod_projeto)) {


                %>
                <input type="checkbox" class="checkbox-inline" name="professores" value="<%=rs.getInt("cod_professor")%>">  <%=rs.getString("nome_professor")%> <br> 
                <%
                        }
                    }
                %>
            </div>
        </div>


        <jsp:useBean id="cn2" class="br.inf.puc.DAO.ColaboradorDAO" scope="page"> </jsp:useBean>
        <%                    ResultSet rs2 = cn2.mostrarAlunos();

        %>

        <div class="form-group">
            <label for="alunos" class="col-sm-5 control-label">Alunos </label>
            <div class="col-sm-2">
                <%                    while (rs2.next()) {
                        if (!projetodao.VerificaalunoProjeto(rs2.getInt("cod_aluno"), cod_projeto)) {

                %>
                <input type="checkbox" class="checkbox-inline" name = "alunos" value="<%=rs2.getInt("cod_aluno")%>">  <%=rs2.getString("nome_aluno")%> <br> 
                <%
                        }
                    }
                %>
            </div>
        </div>
        <input type="hidden" name="id" value="<%=value_id%>" />
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-7">
                <button type="submit" class="btn btn-default">Cadastrar</button>
            </div>
        </div>
    </form>

</center>


<c:import url="rodape.jsp"/>

<%
    }
%>
