<%-- 
    Document   : emitir_relatorio
    Created on : May 8, 2018, 8:14:48 PM
    Author     : angelo
--%>

<%@page import="br.inf.puc.Controller.Emitir_Relatorio"%>
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
<%    Emitir_Relatorio emitir = new Emitir_Relatorio();
%>
<center>
    <form class="form-horizontal" method="post"
          action="" role="form">
        <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Número de Colaboradores: </label>
            <div class="col-lg-1">
                <%=emitir.numero_colaboradores()%>
            </div>
        </div>
        <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Número de Projetos Elaboração: </label>
            <div class="col-lg-1">
                <%=emitir.projetos_elaboracao()%>
            </div>
        </div>
            
         <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Número de Projetos Andamento: </label>
            <div class="col-lg-1">
                <%=emitir.projetos_andamento()%>
            </div>
        </div>
        
         <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Número de Projetos Concluídos: </label>
            <div class="col-lg-1">
                <%=emitir.projetos_concluidos()%>
            </div>
        </div>
            
         <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Total de projetos: </label>
            <div class="col-lg-1">
                <%=emitir.total_projetos()%>
            </div>
        </div>
            
        <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Quantidade de Publicações: </label>
            <div class="col-lg-1">
                <%=emitir.quantidade_publicacoes()%>
            </div>
        </div>
        
         <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Quantidade de Orientações </label>
            <div class="col-lg-1">
                <%=emitir.quantidade_orientacoes()%>
            </div>
        </div>

    </form>



</center>


<c:import url="rodape.jsp"/>

<%
    }
%>