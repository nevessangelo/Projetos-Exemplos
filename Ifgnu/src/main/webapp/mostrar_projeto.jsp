<%-- 
    Document   : mostrar_projeto
    Created on : May 10, 2018, 5:06:49 PM
    Author     : angelo
--%>

<%@page import="br.inf.puc.DAO.PublicacaoDAO"%>
<%@page import="br.inf.puc.Controller.Publicacao"%>
<%@page import="br.inf.puc.Controller.Projeto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.inf.puc.Controller.Colaborador"%>
<%@page import="br.inf.puc.DAO.ProjetoDAO"%>
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

<%
     String value_id = request.getParameter("id");
     int cod_projeto = Integer.parseInt(value_id);
     ProjetoDAO projetodao = new ProjetoDAO();
     Projeto projeto = projetodao.getProjeto(cod_projeto);
     projeto.setId(cod_projeto);
   
%>
<center>
<form class="form-horizontal" method="post"
           action="action_status" role="form">
         <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Título do Projeto</label>
            <div class="col-sm-4">
                <%=projeto.getTitulo()%>
            </div>
        </div>
         
        <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Data Início</label>
            <div class="col-sm-4">
                <%=projeto.getData_inicio()%>
            </div>
     </div>
            
          <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Data Término</label>
            <div class="col-sm-4">
                <%=projeto.getData_termino()%>
            </div>
     </div>
            
            <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Agência</label>
            <div class="col-sm-4">
                <%=projeto.getAgencia()%>
            </div>
     </div>
            
     <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Valor</label>
            <div class="col-sm-4">
                <%=projeto.getValor_financiado()%>
            </div>
     </div>
     
     <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Objetivo</label>
            <div class="col-sm-4">
                <%=projeto.getObjetivo()%>
            </div>
     </div>
     
     <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Descrição</label>
            <div class="col-sm-4">
                <%=projeto.getDescricao()%>
            </div>
     </div>
            
       <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Status</label>
            <div class="col-sm-4">
                <%=projeto.getStatus()%>
            </div>
     </div>
     <div class="form-group">
            <label for="nome" class="col-sm-3 control-label">Participantes</label>
            <br>
            <br>
            <%
                ArrayList<Colaborador> colaboradores = projeto.getParticipantes();
                for (Colaborador colaborador : colaboradores) {
                    

            %>
                <div class="col-sm-8">
                    <%=colaborador.getNome()%>
                 </div>
                 <br>
            <%
                }
            %>
         
     </div>
     
            <div class="form-group">
                <label for="nome" class="col-sm-3 control-label">Projetos</label>
                <br>
                <br>
                <%
                    PublicacaoDAO publicacaodao = new PublicacaoDAO();
                    ArrayList<Publicacao> publicacoes = publicacaodao.PubicacaoOrderByProjeto(cod_projeto);
                    for (Publicacao publicacao : publicacoes) {
                %>
                <div class="col-sm-8">
                    <%=publicacao.getTitulo()%>
                 </div>
                 <br>
                        
                <%
                    }
                %>
            </div>
    
  
       
        



     
     
     
               
     </form>
     
</center>
     

<c:import url="rodape.jsp"/>

<%    }

%>

