<%-- 
    Document   : visualizar_projeto
    Created on : May 2, 2018, 1:35:04 AM
    Author     : angelo
--%>

<%@page import="java.sql.ResultSet"%>
<%
    if (session.getAttribute("nivel").equals("Gerente")) {

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
                    <%  
                        int id = (Integer) session.getAttribute("id");
                        ResultSet rs = cn.mostrarProjetosProfessor(id);
                    %>
                    <div class="container theme-showcase" role="main">
                        <table class="table table-bordered table-hover">
                            <th>Nome Projeto</th>
                            <th>Status</th>
                            <th>Ações</th>
                            <%
                                while (rs.next()) {
                            %>
                            <tr>
                <td>
                    <%=rs.getString("projeto_titulo")%>
                </td>
                <td>
                    <%=rs.getString("status_projeto")%>
                </td>
                <td>
                    <a  class="btn btn-default btn-sm" href="mostrar_projeto?&id=<%=rs.getInt("cod_projeto")%>"> Mostrar </a> 
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
