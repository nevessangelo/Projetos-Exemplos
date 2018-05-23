<%
    if (session.getAttribute("id") == null) {
%>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Ifgnu</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}">Início</a></li>
                <!--<li><a href="#sobre" onclick="document.getElementById('formSobre').submit();">Sobre</a></li>-->
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<form id="formSobre" action="${pageContext.request.contextPath}/sobre" method="post">
    <input type="hidden" name="sobre" value="Sobre">
</form>

<%
} else if (session.getAttribute("id") != null) {
    if (session.getAttribute("nivel").equals("Administrador")) {
%>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Ifgnu</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}">Início</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastro<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                                <li><a href="#cadastro" onclick="document.getElementById('formCadastro').submit();">Cadastrar Colaborador</a></li>
                                <li><a href="#cadastro_projeto" onclick="document.getElementById('formCadastroProjeto').submit();">Cadastrar Projeto</a></li>
                                <li><a href="#cadastro_pubicacao" onclick="document.getElementById('formCadastroPublicacao').submit();">Cadastrar Publicação</a></li>
                                <li><a href="#cadastro_orientacao" onclick="document.getElementById('formCadastroOrientacao').submit();">Cadastrar Orientação</a></li>
                        </ul>
                    </li>
                <li><a href="#consulta" onclick="document.getElementById('formConsulta').submit();">Consulta por Colaborador</a></li>
                <li><a href="#listar_projeto" onclick="document.getElementById('formListarProjeto').submit();">Listar Projetos</a></li>
                <li><a href="#emitir_relatorio" onclick="document.getElementById('formRelatorio').submit();">Emitir Relatório</a></li>
                <li><a href="#logout" onclick="document.getElementById('formLogout').submit();">Sair</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
                    
<form id="formConsulta" action="${pageContext.request.contextPath}/consulta" method="post">
    <input type="hidden" name="consulta" value="consulta">
</form>

<form id="formListarProjeto" action="${pageContext.request.contextPath}/listar_projetos" method="post">
    <input type="hidden" name="listar_projetos" value="listar_projetos">
</form>
    
<form id="formCadastroPublicacao" action="${pageContext.request.contextPath}/cadastro_publicacao" method="post">
    <input type="hidden" name="cadastro_publicacao" value="cadastro_publicacao">
</form>
                
<form id="formCadastroProjeto" action="${pageContext.request.contextPath}/cadastro_projeto" method="post">
    <input type="hidden" name="cadastro_projeto" value="cadastro_projeto">
</form>
    
<form id="formCadastroOrientacao" action="${pageContext.request.contextPath}/cadastro_orientacao" method="post">
    <input type="hidden" name="cadastro_orientacao" value="cadastro_orientacao">
</form>
                
<form id="listar" action="${pageContext.request.contextPath}/listar_colaboradores" method="post">
    <input type="hidden" name="listar" value="listar">
</form>
                                
<form id="formCadastro" action="${pageContext.request.contextPath}/cadastro" method="post">
    <input type="hidden" name="cadastro" value="cadastro">
</form>

<form id="formSobre" action="${pageContext.request.contextPath}/sobre" method="post">
    <input type="hidden" name="sobre" value="Sobre">
</form>
    
<form id="formRelatorio" action="${pageContext.request.contextPath}/relatorio" method="post">
    <input type="hidden" name="relatorio" value="relatorio">
</form>

<form id="formLogout" action="${pageContext.request.contextPath}/logout" method="post">
    <input type="hidden" name="logout" value="Logout">
</form>

<%
} else if (session.getAttribute("nivel").equals("Gerente")) {

%>

<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Ifgnu</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}">Início</a></li>
                <li><a href="#sobre" onclick="document.getElementById('formVisuProjetos').submit();">Visualizar Projetos</a></li>
                <!--<li><a href="#sobre" onclick="document.getElementById('formSobre').submit();">Sobre</a></li>-->
                <li><a href="#logout" onclick="document.getElementById('formLogout').submit();">Sair</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<form id="formVisuProjetos" action="${pageContext.request.contextPath}/visualizar_projetos_professor" method="post">
    <input type="hidden" name="sobre" value="visualizarProjetosProfessor">
</form>

<form id="formLogout" action="${pageContext.request.contextPath}/logout" method="post">
    <input type="hidden" name="logout" value="Logout">
</form>

<%        }
    }

%>

