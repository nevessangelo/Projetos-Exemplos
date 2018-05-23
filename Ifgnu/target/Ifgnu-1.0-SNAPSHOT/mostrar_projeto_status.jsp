<%-- 
    Document   : mostrar_projeto_status
    Created on : May 2, 2018, 2:54:07 AM
    Author     : angelo
--%>

<%@page import="br.inf.puc.Controller.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.ObjectOutputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="br.inf.puc.Controller.Colaborador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.inf.puc.Controller.Projeto"%>
<%@page import="br.inf.puc.DAO.ProjetoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
     <%        String value_id = request.getParameter("id");
               int cod_projeto = Integer.parseInt(value_id);
               ProjetoDAO projetoDAO = new ProjetoDAO();
               Projeto projeto = projetoDAO.getProjeto(cod_projeto);
               projeto.setId(cod_projeto);
               
     %>
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
                ArrayList<Integer> ids = new ArrayList<Integer>();
                for (Colaborador colaborador : colaboradores) {
                    Class cls = colaborador.getClass();
                    if (cls.getTypeName().equals("br.inf.puc.Controller.Aluno")) {
                        int id = colaborador.getId();
                        ids.add(id);
                    }


            %>
                <div class="col-sm-8">
                    <%=colaborador.getNome()%>
                 </div>
                 <br>
            <%
                }
                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                final ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(ids);
                oos.flush();
                final String result = new String(Base64.getEncoder().encode(baos.toByteArray()));

            %>
     </div>
    
  
        <input type = "hidden" name="id_projeto" value="<%=cod_projeto%>" />
        <input type = "hidden" name="projeto_status" value="<%=projeto.getStatus()%>" /> 
        <input type = "hidden" name="<%="lista_cod_alunos"%>" value="<%=result %>" />

        



     
     <div class="form-group">
                <div class="col-sm-offset-3 col-sm-7">
                    <button type="submit" class="btn btn-default">Mudar Status</button>
                </div>
      </div>
     
               
     </form>
     
     
     
        
</center>

<%
    }
%>


