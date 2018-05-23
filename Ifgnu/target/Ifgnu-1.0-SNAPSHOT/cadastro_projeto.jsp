<%-- 
    Document   : cadastro_projeto
    Created on : Apr 30, 2018, 3:45:14 PM
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
          action="action_cadastro_projeto" role="form">
        <div class="form-group">
            <label for="nome_projeto" class="col-sm-5 control-label">Nome do Projeto</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="nome_projeto" name="nome_projeto"
                       placeholder="Digite Aqui o Nome" />
            </div>
        </div>
        <div class="form-group">
                <label for="data_inicio" class="col-sm-5 control-label">Data de Inicio</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="data_inicio" name="data_inicio"
                           placeholder="Digite Aqui a Data em XX/XX/XXXX" />
                </div>
            </div>
        
         <div class="form-group">
                <label for="data_termino" class="col-sm-5 control-label">Data de Término</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="data_termino" name="data_termino"
                           placeholder="Digite Aqui a Data em XX/XX/XXXX" />
                </div>
            </div>
         <div class="form-group">
            <label for="agencia" class="col-sm-5 control-label">Agência do Projeto</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="agencia" name="agencia"
                       placeholder="Digite Aqui a Agência do Projeto" />
            </div>
        </div>
        <div class="form-group">
            <label for="valor" class="col-sm-5 control-label">Valor do Projeto</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="valor" name="valor"
                       placeholder="Digite Aqui o valor do Projeto" />
            </div>
        </div>
        <div class="form-group">
            <label for="objetivo" class="col-sm-5 control-label">Objetivo do Projeto</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="objetivo" name="objetivo"
                       placeholder="Digite Aqui o objetivo do Projeto" />
            </div>
        </div>
        
        <div class="form-group">
            <label for="objetivo" class="col-sm-5 control-label">Descrição do Projeto</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="descricao" name="descricao"
                       placeholder="Digite Aqui a Descrição do Projeto" />
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
