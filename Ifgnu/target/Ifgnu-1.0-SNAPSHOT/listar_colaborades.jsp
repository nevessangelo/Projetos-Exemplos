<%-- 
    Document   : listar_colaborades
    Created on : Apr 30, 2018, 10:55:17 AM
    Author     : angelo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="br.inf.puc.DAO.ProfessorDAO"%>
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

<div class="container theme-showcase" role="main">
    <b> Professores: </b>
</div>
<center>
    
    <jsp:useBean id="cn" class="br.inf.puc.DAO.ColaboradorDAO" scope="page"> </jsp:useBean>
                    <%                    ResultSet rs = cn.mostrarProfessores();
                    %>
    <div class="container theme-showcase" role="main">

        
        <table class="table table-bordered table-hover">
            <th>Nome</th>
            <th>Ações</th>
            <%
                            while (rs.next()) {


                        %>
                       <tr>
                <td>
                    <%=rs.getString("nome_professor")%>
                </td>
                <td>
                    <a href=""> Editar </a> <a class ="btn btn-danger btn-sm" href="excluirprofessor?action=del&id=${rs.getInt('cod_professor')}">Excluir </a>
                </td>
            </tr>
            
             <%
                            }
                            rs.close();
                        %>

        </table>
    </div>
</center>

<div class="container theme-showcase" role="main">
    <b> Alunos: </b>
</div>
                        
<center>
    
    <jsp:useBean id="cn2" class="br.inf.puc.DAO.ColaboradorDAO" scope="page"> </jsp:useBean>
                    <%                    ResultSet rs2 = cn2.mostrarAlunos();
                    %>
    <div class="container theme-showcase" role="main">

        
        <table class="table table-bordered table-hover">
            <th>Nome</th>
            <th>Ações</th>
            <%
                            while (rs2.next()) {


                        %>
                       <tr>
                <td>
                    <%=rs2.getString("nome_aluno")%>
                </td>
                <td>
                    <a href=""> Editar </a> <a href="excluirprofessor">Excluir </a>
                </td>
            </tr>
            
             <%
                            }
                            rs.close();
                        %>

        </table>
    </div>
</center>



<c:import url="rodape.jsp"/>

<%    }
%>