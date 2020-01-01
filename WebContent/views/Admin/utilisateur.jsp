<%@ page language="java" contentType="text/html;  charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
			if(session != null){
				if(session.getAttribute("nom") != null ){
					
				}else{
					response.sendRedirect("/LicencePro/views/index.jsp");
				}
			}
	
	%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<!-- Left side column. contains the logo and sidebarif(session.getAttribute("role").equals("Super Admin") || session.getAttribute("role").equals("super admin") || session.getAttribute("role").equals("Admin") || session.getAttribute("role").equals("admin") ){
			System.out.print("Eroor:");
		} -->
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
			<li><a href="${pageContext.request.contextPath}/views/Admin/index.jsp"><i class="fa fa-users"></i> <span>Listes
						des utilisateurs </span></a></li>
			<li  class="active"><a href="${pageContext.request.contextPath}/views/Admin/utilisateur.jsp"><i
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
	<section class="content container-fluid">

		<!-- general form elements -->
		<div class="box box-primary">
			<div class="box-header with-border">
				<h3 class="box-title">Ajouter utilisateur :</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form role="form" action="${pageContext.request.contextPath}/AjouterUtilisateurServlet"  method="post">
				<div class="box-body">
					<div class="form-group col-xs-6">
						<label>Nom :</label> <input type="text" class="form-control"
							id="nom" name="nom" placeholder="Nom">
					</div>
					<div class="form-group col-xs-6">
						<label>Prénom :</label> <input type="text" class="form-control"
							id="prenom" name="prenom" placeholder="Prenom">
					</div>
					<div class="form-group col-xs-6">
						<label>N° Télephone Portable:</label> <input type="tel"
							class="form-control" id="numTelPortable" name="numTelPortable"
							placeholder="N° Télephone">
					</div>
					<div class="form-group col-xs-6">
						<label>N° Télephone GSM:</label> <input type="tel"
							class="form-control" id="numTelGsm" name="numTelGsm"
							placeholder="N° Télephone">
					</div>
					<div class="form-group col-xs-6">
						<label>Email :</label> <input type="email" class="form-control"
							id="email" name="email" placeholder="Email">
					</div>
					<div class="form-group col-xs-6">
						<label>Address Maison :</label> <input type="text"
							class="form-control" id="addresse" name="addresse"
							placeholder="Address Maison">
					</div>
					<div class="form-group col-xs-12">
						<label>Rôle :</label> 
						<select class="form-control select2"
							id="role" style="width: 100%;" name="role">
							<option selected="selected" value="1">Administrateur</option>
							<option value="2">Ministere</option>
							<option value="3">Délégue</option>
							<option value="4">Chargé des dossier  AV</option>
							
						</select>
					</div>
					<div class="form-group col-xs-10">
						<label>Password :</label> <input type="password"
							class="form-control" id="genpassword" name="password"
							placeholder="password">
					</div>
					<div class="form-group col-xs-2">
						<label>&nbsp;&nbsp;&nbsp;</label><br>
						<div class="btn-group-vertical">
							<button type="button" class="btn btn-default">
								<i class="fa fa-refresh" onclick="passwordGenrate()"></i>
							</button>
						</div>
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>

	</section>

	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script src="../assets/dist/js/app.js"></script>
<jsp:include page="../includes/footer.jsp"></jsp:include>