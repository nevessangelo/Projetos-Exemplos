<%-- 
    Document   : cadastro_publicacao
    Created on : May 7, 2018, 11:26:03 PM
    Author     : angelo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <form class="form-horizontal" method="post"
          action="action_cadastro_publicacao" role="form">
        <div class="form-group">
            <label for="titulo_publicacao" class="col-sm-5 control-label">Títutlo da Publicação</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="titulo_publicacao" name="titulo_publicacao"
                       placeholder="Digite Aqui o Título da Publicação" />
            </div>
        </div>
        <div class="form-group">
            <label for="conferencia_publicacao" class="col-sm-5 control-label">Conferência</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="conferencia_publicacao" name="conferencia_publicacao"
                       placeholder="Digite Aqui a Conferência" />
            </div>
        </div>
        <div class="form-group">
            <label for="ano_publicacao" class="col-sm-5 control-label">Ano</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="ano_publicacao" name="ano_publicacao"
                       placeholder="Digite Aqui o ano" />
            </div>
        </div>
        <div class="form-group">
                <label for="projeto" class="col-sm-5 control-label">Projeto</label>
                <div class="col-sm-1">
                     <jsp:useBean id="cn" class="br.inf.puc.DAO.ProjetoDAO" scope="page"> </jsp:useBean>
                      <%                    ResultSet rs = cn.mostrarProjetosAndamento();
                      %>
                      <select id = 'projetos' name = 'projetos'">
                        <option value="">Selecione</option>
                        <%
                            while (rs.next()) {


                        %>
                        <option value="<%=rs.getInt("cod_projeto")%>"> <%=rs.getString("projeto_titulo")%> </option>
                        <%
                            }
                            rs.close();
                        %>
                    </select>

                </div>
        </div>
      <jsp:useBean id="cn2" class="br.inf.puc.DAO.ColaboradorDAO" scope="page"> </jsp:useBean>
        <%                    ResultSet rs2 = cn2.mostrarProfessores();
        %>

        <div class="form-group">
            <label for="professores" class="col-sm-5 control-label">Professores </label>
            <div class="col-sm-2">
                <%
                    while (rs2.next()) {
                      
                %>
                <input type="checkbox" class="checkbox-inline" name="professores" value="<%=rs2.getInt("cod_professor")%>">  <%=rs2.getString("nome_professor")%> <br> 
                <%
                        
                    }
                %>
            </div>
        </div>
        
        <jsp:useBean id="cn3" class="br.inf.puc.DAO.ColaboradorDAO" scope="page"> </jsp:useBean>
        <%                    ResultSet rs3 = cn3.mostrarAlunos();

        %>

        <div class="form-group">
            <label for="alunos" class="col-sm-5 control-label">Alunos </label>
            <div class="col-sm-2">
                <% while (rs3.next()) {
                        

                %>
                <input type="checkbox" class="checkbox-inline" name = "alunos" value="<%=rs3.getInt("cod_aluno")%>">  <%=rs3.getString("nome_aluno")%> <br> 
                <%
                       
                    }
                %>
            </div>
        </div>
       
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-7">
                <button type="submit" class="btn btn-default">Cadastrar</button>
            </div>
        </div>

        
    </form>
</center>

<c:import url="rodape.jsp"/>

<%    }
%>
