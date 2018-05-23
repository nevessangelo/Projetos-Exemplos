<%-- 
    Document   : cadastro_orientacao
    Created on : May 8, 2018, 4:40:35 PM
    Author     : angelo
--%>

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
    <form class="form-horizontal" method="post"
          action="action_orientacao" role="form">
        <div class="form-group">
            <label for="titulo_orientacao" class="col-sm-5 control-label">Título</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="titulo_orientacao" name="titulo_orientacao"
                       placeholder="Digite o título" />
            </div>
        </div>

        <div class="form-group">
            <label for="orientador" class="col-sm-5 control-label">Orientador</label>
            <div class="col-sm-1">

                <jsp:useBean id="cn" class="br.inf.puc.DAO.ColaboradorDAO" scope="page"> </jsp:useBean>
                <%                    ResultSet rs = cn.mostrarProfessores();
                %>

                <select id = 'orientador' name = 'orientador'>
                    <option value="">Selecione</option>
                    <%
                        while (rs.next()) {


                    %>
                    <option value="<%=rs.getInt("cod_professor")%>"> <%=rs.getString("nome_professor")%> </option>
                    <%
                        }
                        rs.close();
                    %>
                </select>

            </div>
        </div>

        <div class="form-group">
            <label for="aluno" class="col-sm-5 control-label">Aluno</label>
            <div class="col-sm-1">

                <jsp:useBean id="cn2" class="br.inf.puc.DAO.ColaboradorDAO" scope="page"> </jsp:useBean>
                <%                    ResultSet rs2 = cn2.mostrarAlunos();
                %>

                <select id = 'aluno' name = 'aluno'>
                    <option value="">Selecione</option>
                    <%
                        while (rs2.next()) {


                    %>
                    <option value="<%=rs2.getInt("cod_aluno")%>"> <%=rs2.getString("nome_aluno")%> </option>
                    <%
                        }
                        rs2.close();
                    %>
                </select>

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

<%
    }
%>
