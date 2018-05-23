<%-- 
    Document   : listar_projetos
    Created on : May 1, 2018, 3:06:29 AM
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
    <jsp:useBean id="cn" class="br.inf.puc.DAO.ProjetoDAO" scope="page"> </jsp:useBean>
                    <%                    ResultSet rs = cn.mostrarProjetos();
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
                    <%=rs.getString("projeto_titulo")%>
                </td>
                <td>
                    <a  class="btn btn-default btn-sm" href="alterarprojeto?&id=<%=rs.getInt("cod_projeto")%>"> Editar </a> 
                    <a  class="btn btn-default btn-sm" href="historico_projeto?&id=<%=rs.getInt("cod_projeto")%>"> Histórico </a> 
                </td>
            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
</center>

<c:import url="rodape.jsp"/>
<%
    }
%>
