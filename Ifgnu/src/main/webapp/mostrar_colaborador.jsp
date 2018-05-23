<%-- 
    Document   : mostrar_colaborador
    Created on : May 10, 2018, 3:19:20 PM
    Author     : angelo
--%>

<%@page import="br.inf.puc.Controller.Publicacao"%>
<%@page import="br.inf.puc.Controller.Colaborador"%>
<%@page import="br.inf.puc.Controller.Projeto"%>
<%@page import="java.util.ArrayList"%>
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
    <%        Colaborador colaborador = (Colaborador) request.getAttribute("colaborador");
    %>

    <div class="container theme-showcase" role="main">
        <table class="table table-bordered table-hover">
            <th>Nome</th>
            <th>Email</th>

            <tr>
                <td><%=colaborador.getNome()%></td>
                <td><%=colaborador.getEmail()%></td>
            </tr>


        </table>
    </div>
    <div class="container theme-showcase" role="main">
        Projetos:
        <table class="table table-bordered table-hover">
            <th>Título</th>
            <th> Data Término </th>



            <tr>
                <%
                    ArrayList<Projeto> projetos = colaborador.getProjetos();
                    for (Projeto projeto : projetos) {
                %>
                <td> <%=projeto.getTitulo()%></td>
                <td> <%=projeto.getData_termino()%> </td>

            </tr>
            <% } %>


        </table>
    </div>
    <div class="container theme-showcase" role="main">
        Publicações:
        <table class="table table-bordered table-hover">
            <th>Título</th>
            <th> Ano </th>
            
            <tr>
                <% 
                    ArrayList<Publicacao> publicacoes = colaborador.getPublicacao();
                    for (Publicacao publicacao : publicacoes) {
                %>
                    <td> <%=publicacao.getTitulo()%></td>
                    <td> <%=publicacao.getAno()%> </td>
            </tr>
                <% } %>
            </tr>
        </table>
    </div>


</center>

<c:import url="rodape.jsp"/>

<%    }

%>


