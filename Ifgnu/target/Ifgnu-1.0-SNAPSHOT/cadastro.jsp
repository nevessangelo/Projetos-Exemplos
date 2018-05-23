<%-- 
    Document   : cadastro.jsp
    Created on : Apr 14, 2018, 2:01:23 PM
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
          action="action_cadastro" role="form">
        <div class="form-group">
            <label for="nome" class="col-sm-5 control-label">Nome</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="nome" name="nome"
                       placeholder="Digite Aqui o Nome" />
            </div>
        </div>

        <div class="form-group">
            <label for="email" class="col-sm-5 control-label">E-mail</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="email" name="email"
                       placeholder="Digite Aqui o E-mail" />
            </div>
        </div>

        <!--        <select id="sel" class="sel">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>-->

        <div class="form-group">
            <label for="tipo" class="col-sm-5 control-label">Tipo Colaborador</label>
            <div class="col-sm-1">

                <select id="sel" name="combo" class="sel">
                    <option value="">Selecione</option>
                    <option value="1">Aluno Graduação</option>
                    <option value="2">Aluno Pós-Graduação</option>
                    <option value="3">Professor</option>
                </select>

            </div>
        </div>


        <div id="id_1" class="esconder"> 
            <div class="form-group">
                <label for="usuario" class="col-sm-5 control-label">Data de Ingresso</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="data" name="data"
                           placeholder="Digite Aqui a Data em XX/XX/XXXX" />
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
                <div class="col-sm-offset-3 col-sm-7">
                    <button type="submit" class="btn btn-default">Cadastrar</button>
                </div>
            </div>

        </div>
        <div id="id_2" class="esconder">
            <div class="form-group">
                <label for="usuario" class="col-sm-5 control-label">Data de Ingresso</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="datap" name="datap"
                           placeholder="Digite Aqui a Data em XX/XX/XXXX" />
                </div>
            </div>

            <div class="form-group">
                <label for="regime" class="col-sm-5 control-label">Regime de Curso</label>
                <div class="col-sm-1">

                    <select id="sel" name="sel" class="sel">
                        <option value="">Selecione</option>
                        <option value="parcial">Parcial</option>
                        <option value="integral">Integral</option>
                    </select>

                </div>
            </div>

            <div class="form-group">
                <label for="orientador" class="col-sm-5 control-label">Orientador</label>
                <div class="col-sm-1">

                    <jsp:useBean id="cn2" class="br.inf.puc.DAO.ColaboradorDAO" scope="page"> </jsp:useBean>
                    <%
                        ResultSet rs2 = cn.mostrarProfessores();
                    %>

                    <select id = 'orientadorp' name = 'orientadorp'>
                        <option value="">Selecione</option>
                        <%
                            while (rs2.next()) {


                        %>
                        <option value="<%=rs2.getInt("cod_professor")%>"> <%=rs2.getString("nome_professor")%> </option>
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


        </div>
        <div id="id_3" class="esconder"> 

            <div class="form-group">
                <label for="usuario" class="col-sm-5 control-label">Usuário</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" id="usuario" name="usuario"
                           placeholder="Digite Aqui o Usuário" />
                </div>
            </div>

            <div class="form-group">
                <label for="senha" class="col-sm-5 control-label">Senha</label>
                <div class="col-sm-3">
                    <input type="password" id="senha" class="form-control" name="password"
                           placeholder="Digite aqui sua senha" />
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-7">
                    <button type="submit" class="btn btn-default">Cadastrar</button>
                </div>
            </div>

        </div> 








        <!--        <div class="form-group">
                    <label for="tipo" class="col-sm-5 control-label">Tipo Colaborador</label>
                    <div class="col-sm-1">
        
                        <select id="seletor">
                            <option value="">Selecione</option>
                            <option value="alunog">Aluno Graduação</option>
                            <option value="alunop">Aluno Pós-Graduação</option>
                            <option value="professor">Professor</option>
                        </select>
        
                    </div>
                </div>
                <div id="alunog" class="esconder">Div 1 </div> 
                <div id="alunop" class="esconder">Div 2 </div>
                <div id="professor" class="esconder">Div 3 </div>-->




        <!--        <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ver Clusters<span class="caret"></span></a>
                      <ul class="dropdown-menu">
                        <li role="separator" class="divider"></li> 
                        <li class="dropdown-header">Clusters</li>
                        <li><a href="#" onclick="document.getElementById('formClusterA').submit();">Cluster A</a></li>
                        <li><a href="#" onclick="document.getElementById('formClusterB').submit();">Cluster B</a></li>
                        <li><a href="#" onclick="document.getElementById('formClusterC').submit();">Cluster C</a></li>
                        <li><a href="#" onclick="document.getElementById('formClusterD').submit();">Cluster D</a></li>
                      </ul>
                    </li>-->



    </form>
</center>

<c:import url="rodape.jsp"/>

<%    }

%>
