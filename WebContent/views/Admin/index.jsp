<%@ page language="java" contentType="text/html;  charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="ma.ministere.dao.UtilisateurDao"%>
<%@ page
	import="java.io.IOException, java.sql.SQLException,  java.util.*"%>
<%@ page import="ma.ministere.models.AbstractModel"%>
<%@ page import="ma.ministere.models.Utilisateurs"%>
<%
			if(session != null){
				if(session.getAttribute("nom") != null ){
					
				}else{
					response.sendRedirect("/LicencePro/views/index.jsp");
				}
			}
	
	%>
<%  UtilisateurDao udao = new UtilisateurDao("users"); %>
<% ArrayList<AbstractModel> liste = udao.getAll(); %>
<% Utilisateurs ds; %>
<jsp:include page="../includes/header.jsp"></jsp:include>
<script src="../assets/dist/js/app.js"></script>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">

		<!-- Sidebar user panel (optional) -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="../assets/dist/img/user2-160x160.jpg" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>Alexander Pierce</p>
				<!-- Status -->
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>


		<!-- Sidebar Menu -->
		<ul class="sidebar-menu" data-widget="tree">
			<li class="header">Dashboard</li>
			<!-- Optionally, you can add icons to the links -->
			<li class="active"><a href="${pageContext.request.contextPath}/views/Admin/index.jsp"><i class="fa fa-users"></i> <span>Listes
						des utilisateurs </span></a></li>
			<li><a href="${pageContext.request.contextPath}/views/Admin/utilisateur.jsp"><i
					class="fa fa-user"></i> <span>Ajouter un utilisateur</a></li>

		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Dashboard <small>Control panel</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li class="active">Dashboard</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<div class="row">
			<div class="col-lg-4 col-xs-6">
				<!-- small box -->
				<div class="small-box bg-aqua">
					<div class="inner">
						<h3>150</h3>

						<p>Utilisateurs ActivÃ©</p>
					</div>
					<div class="icon">
						<i class="fa fa-users"></i>
					</div>
				</div>
			</div>
			<!-- ./col -->
			<div class="col-lg-4 col-xs-6">
				<!-- small box -->
				<div class="small-box bg-green">
					<div class="inner">
						<h3>53</h3>

						<p>Utilisateurs DÃ©sactivÃ©</p>
					</div>
					<div class="icon">
						<i class="fa fa-users"></i>
					</div>
				</div>
			</div>
			<!-- ./col -->
			<div class="col-lg-4 col-xs-6">
				<!-- small box -->
				<div class="small-box bg-yellow">
					<div class="inner">
						<h3>44</h3>

						<p>RÃ´les</p>
					</div>
					<div class="icon">
						<i class="fa fa-link"></i>
					</div>
				</div>
			</div>

		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-xs-12">


				<!-- /.box-header -->

				<div class="box">
					<div class="box-header">
						<h3 class="box-title">Listes des Utilisateurs</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<table id="tableUtilisateur"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>#</th>
									<th>Nom</th>
									<th>Prénom</th>
									<th style="display: none;">Password</th>
									<th>Rôle</th>
									<th>Email</th>
									<th>Numero de Tel°</th>
									<th>Adresse</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<% for (AbstractModel abstractModel : liste) { ds = (Utilisateurs) abstractModel; %>
								<tr>
									<td><%= ds.getId() %></td>
									<td><%= ds.getNom()%></td>
									<td><%= ds.getPrenom() %></td>
									<td style="display: none;"><%= ds.getMdp() %></td>
									<td><%= ds.getRole() %></td>
									<td><%= ds.getEmail() %></td>
									<td><%= ds.getTel() %></td>
									<td>Adress</td>
									<td>
									<form role="form" method="post" action="${pageContext.request.contextPath}/SupprimerUtilisateurServlet">
											
										<div class="btn-group">
											
											
											
											<a href="EditUser.jsp?id=<%= ds.getId() %>" type="button" class="btn btn-primary btn-flat btnDelete"
												data-toggle="modal" data-target="#modal-default"
												id="UtilisateurEdit"><i class="fa fa-pencil-square-o"></i></a>
												
												<button  type="submit" class="btn btn-danger btn-flat" id="delete">
													<i class="fa fa-close"></i>
												</button>
												<input type="hidden" id ="id" name="idDelete" value="<%= ds.getId() %>">
											
										</div>
									</form>
									</td>
								</tr>
								<% } %>
							</tbody>
							<tfoot>
								<tr>
									<th>#</th>
									<th>Nom</th>
									<th>Prénom</th>
									<th style="display: none;">Password</th>
									<th>Rôle</th>
									<th>Email</th>
									<th>Numero de Tel°</th>
									<th>Adresse</th>
									<th>Action</th>
								</tr>
							</tfoot>
						</table>
					</div>

					<!-- /.box-body -->
				</div>
				<!-- /.box -->

				<!-- /.box -->
			</div>
			<!-- /.col -->
		</div>
		   <div class="modal fade" id="modal-default">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Default Modal</h4>
              </div>
              <div class="modal-body">
                  <form role="form" action="${pageContext.request.contextPath}/ModifierUtilisateurServlet" method="POST">
                      <div class="box-body">
                        <div class="form-group col-xs-6">
                          <label>Nom :</label>
                          <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom">
                        </div>
                        <div class="form-group col-xs-6">
                          <label>Prénom :</label>
                          <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prenom">
                        </div>
                        <div class="form-group col-xs-6">
                          <label>N° Télephone :</label>
                          <input type="tel" class="form-control" id="numTel" name="numTel" placeholder="N° Télephone">
                        </div>
                        <div class="form-group col-xs-6">
                          <label>Email  :</label>
                          <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                        </div>
                        <div class="form-group col-xs-12">
                          <label>Status :</label>
                          <select class="form-control select2" id="role" style="width: 100%;">
                            <option selected="selected" value="1">active</option>
                            <option value="0">inactive</option>
                          </select>
                        </div>
                        <div class="form-group col-xs-6">
                          <label>Password  :</label>
                          <input type="password" class="form-control" id="genpassword" name="password" placeholder="password">
                        </div>
                        <div class="form-group col-xs-6">
                          <label>&nbsp;&nbsp;&nbsp;</label><br>
                             <div class="btn-group-vertical">
                                 <button type="button" class="btn btn-default"><i class="fa fa-refresh" onclick="passwordGenrate()"></i></button>
                             </div>
                        </div>
                      </div>
                      <!-- /.box-body -->
            
                    
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
                </form>
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script>

$("#tableUtilisateur").on('click', '#UtilisateurEdit', function() {
	// get the current row
	var currentRow = $(this).closest("tr");
	var id = currentRow.find("td:eq(0)").text().trim(); // get current row 2nd TD
	var nom = currentRow.find("td:eq(1)").text().trim(); // get current row 1st TD value
	var prenom = currentRow.find("td:eq(2)").text().trim(); // get current row 2nd TD
	var mdp = currentRow.find("td:eq(3)").text().trim(); // get current row 3rd TD
	var role = currentRow.find("td:eq(4)").text().trim(); // get current row 3rd TD
	var email = currentRow.find("td:eq(5)").text().trim(); // get current row 4th TD
	var numTel = currentRow.find("td:eq(6)").text().trim(); // get current row 5th TD
	$('#id').val(id);
	$('#nom').val(nom);
	$('#prenom').val(prenom);
	$('#numTel').val(numTel);
	$('#email').val(email);
	$('#genpassword').val(mdp);

});
</script>
<script>
$('#tableUtilisateur tbody').on('click','#delete',function(){
	$(this).closest('tr').remove();
});
</script>

<jsp:include page="../includes/footer.jsp"></jsp:include>


      
