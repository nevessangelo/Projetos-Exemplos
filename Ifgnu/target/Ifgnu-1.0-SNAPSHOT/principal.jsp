<%
if(session.getAttribute("id") == null){
%>

<center>
       <form class="form-horizontal" method="post"
                        action="login" role="form">
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
                                <button type="submit" class="btn btn-default">Login</button>
                            </div>
                        </div>
 
       </form>
        
    </center>

<%
}else{

%>

<center> Bem Vindo</center>

<%
}
%>

<!--<table class="table table-bordered table-hover">
       
            <th>nDCG</th>
            <th>Recall</th>
            <tr>
               <td>
                   Cosseno: <div align = 'right'>  <div id="graph"> <input class='btn btn-primary' type='submit' href="#" onclick="check();" value='Show Graph'/> </div> </div> 
                   <div id='showgraph'> </div>
                </td>
                <td>
                   Cosseno: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
               </td>
            </tr>
            
             <tr>
               <td>
                  JRIP: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
                </td>
                <td>
                   JRIP: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
               </td>
            </tr>
            
             <tr>
               <td>
                  J48: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
                </td>
                <td>
                   J48: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
               </td>
            </tr> 
            
            <tr>
               <td>
                  Bayesian: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
                </td>
                <td>
                   Bayesian: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
               </td>
            </tr> 
            
            
            <tr>
               <td>
                  Social Network: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
                </td>
                <td>
                   Social Network: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
               </td>
            </tr> 
            
             <tr>
               <td>
                  All Methods nDCG: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
                </td>
                <td>
                   All Methods Recall: <div align = 'right'> <input class='btn btn-primary' type='submit' value='Show Graph'/> </div> 
               </td>
            </tr> 
             
    </table>


  -->
   


