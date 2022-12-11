<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página web con JSP</title>
        <!-- LINK HACIA LA HOJA DE ESTILOS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">	
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css"/>
        <!-- SCRIPT -->
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
            //Asegurate que el id que le diste a la tabla sea igual al texto despues del simbolo #
            $('#userList').DataTable();
        } );
        </script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	
	<!-- Los iconos tipo Solid de Fontawesome-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
	<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
    </head>
    <body>
        
        <%
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
        %>
        <div class="container">
	<div class="mx-auto col-sm-8 main-section" id="myTab" role="tablist">
		<ul class="nav nav-tabs justify-content-end">
			<li class="nav-item">
			<a href="index.jsp" class="nav-link active" id="list-tab" data-toggle="tab" href="#list" role="tab" aria-controls="list" aria-selected="false">Lista de productos</a>
			</li>
			<li class="nav-item">
			<a href="crear.jsp" class="nav-link" id="form-tab" data-toggle="tab" href="#form" role="tab" aria-controls="form" aria-selected="true">Añadir producto</a>				   	
			</li>
                        <li class="nav-item">
			<a href="listaclientes.jsp" class="nav-link" id="form-tab" data-toggle="tab" href="#form" role="tab" aria-controls="form" aria-selected="true">Lista de clientes</a>				   	
			</li>
                        <li class="nav-item">
			<a href="crearcliente.jsp" class="nav-link" id="form-tab" data-toggle="tab" href="#form" role="tab" aria-controls="form" aria-selected="true">Añadir cliente</a>				   	
			</li>
                        
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="list" role="tabpanel" aria-labelledby="list-tab">
			</div>
			<div class="tab-pane fade" id="form" role="tabpanel" aria-labelledby="form-tab">
			</div>
		</div>
            </div>
        </div>
        
        <div class="card">
	<div class="card-header">
            <h4>ComposStark - Clientes</h4>
	</div>
	<div class="card-body">
		<!-- Lista de usuarios-->
                <div class="table-responsive">
            <table id="userList" class="table table-bordered table-hover table-striped">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Id.</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Dni</th>
                        <th scope="col">Distrito</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Estado</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                            + "BDComposStark3?user=root&password=1010Kaekd");
                        st = con.createStatement();
                        rs = st.executeQuery("SELECT * FROM T_Cliente LEFT JOIN T_Distrito ON T_Cliente.iddis = "
                                + "T_Distrito.iddis WHERE estcli = 1;");
                    while(rs.next()){
                    %>
                    <tr>
                        <th scope="col"><%= rs.getString(1) %></th>
                        <td><%= rs.getString(2) %></td>
                        <td><%= rs.getString(3) %></td>
                        <td><%= rs.getString(4) %></td>
                        <!-- Nombre del distrito -->
                        <td><%= rs.getString(9) %></td>
                        <td><%= rs.getString(5) %></td>
                        <td><%= rs.getString(6) %></td>
                        <td>
                            <!-- EDITAR / ACTUALIZAR -->
                            <a href="actualizarcliente.jsp?txtid=<%= rs.getString(1) %>&txtnombre=<%= rs.getString(2) %>&txtapellido=<%= rs.getString(3) %>&txtdni=<%= rs.getString(4) %>&txtdistrito=<%= rs.getString(7) %>&txtdireccion=<%= rs.getString(5) %>">
                                
                                <i class="fas fa-edit"></i></a> | 
                                
                            <!-- BORRAR / ELIMINAR -->
                                <a href="eliminarcliente.jsp?txtid=<%= rs.getString(1) %>">
                                <i class="fas fa-user-times"></i></a>
			</td>
                    </tr>
                    <%
                        }
                    %>    
                </tbody>
            </table>
        </div>
        </div>
        </div>

                
    </body>
</html>
