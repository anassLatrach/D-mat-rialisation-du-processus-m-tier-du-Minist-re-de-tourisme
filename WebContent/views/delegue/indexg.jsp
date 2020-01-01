<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%
			if(session != null){
				if(session.getAttribute("nom") != null ){
					
				}else{
					response.sendRedirect("/LicencePro/views/index.jsp");
				}
			}
	
	%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<script src="../assets/dist/js/app.js"></script>
<%@ page import="ma.ministere.dao.GerantDao"%>
<%@ page
	import="java.io.IOException, java.sql.SQLException,  java.util.*"%>
<%@ page import="ma.ministere.models.AbstractModel"%>
<%@ page import="ma.ministere.models.Gerants"%>


<%  GerantDao udao = new GerantDao("gerants"); %>
<% ArrayList<AbstractModel> liste = udao.getAll(); %>
<% Gerants ds; %>


<!-- Left side column. contains the logo and sidebar -->
 <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../assets/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form>
      <!-- /.search form -->


      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Gestion  </li>
        <!-- Optionally, you can add icons to the links -->
        <li class=""><a href="#"><i class="fa fa-link"></i> <span>Toute les listes  </span></a></li>
        <li class="treeview active">
          <a href="#"><i class="fa fa-institution"></i> <span>Gestion des Agences</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu"><!-- for example : le Délégué peut ajouter des utilisateurs qui avec le role 
            "add-dossier" seulment , et un seul utilisateur qui est le délégué a le droit d'ajouter et les autre utilisateurs, 
            supprimer utilisateur(une colone (name = active) dans la table qui aura la valeur 0) , et approuver le dossier.-->
            <li  ><a href="indexg.jsp">Liste des agences</a></li>
            <li><a href="Agence.jsp">Ajouter un agence</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#"><i class="fa fa-users"></i> <span>Gestion des Personnels</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu active">
            <li class="treeview">
              <a href="#"><i class="fa fa-users"></i> Gestion des Gérants
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu active">
                  <li class="active"><a href="indexg.jsp">Liste des gérant</a></li>
                  <li><a href="Gerant.jsp">Ajouter un gérant</a></li>
                </ul>
          </li>
          <li class="treeview">
            
                
                  <a href="#"><i class="fa fa-users"></i> Gestion des Directeurs
                    <span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
                  </a>
                  <ul class="treeview-menu">
                      <li><a href="indexd.jsp">Liste des directeurs</a></li>
                      <li><a href="Directeur.jsp">Ajouter un directeur</a></li>
                    </ul>
              
             
          </li>
          </ul>
        </li>
        <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li>
        
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
          
          INFORMATIONS GENERALES 
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>
     
    <!-- Main content -->
    <section class="content container-fluid">
        <div class="row">
            <div class="col-xs-12">
              <div class="box box-default">
                <div class="box-header with-border">
                  <h3 class="box-title">Gérant :</h3>
                </div>
                <div class="box-body">
                      <table id="example1" class="table table-bordered table-striped">
                  <thead>
                    <tr>
						<th>#</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Nationalité</th>
						<th>Email</th>
						<th>Numero de Tel°</th>
						<th>Cin</th>
						<th>Niveau d’instruction</th>
						<th>Qualification professionnelle </th>
						 <th>Action</th>
								</tr>
                  </thead>
                  <tbody>
                     <% for (AbstractModel abstractModel : liste) { ds = (Gerants) abstractModel; %>
								<tr>
									<td><%= ds.getId() %></td>
									<td><%= ds.getNom()%></td>
									<td><%= ds.getPrenom() %></td>
									<td><%= ds.getNationalite() %></td>
									<td><%= ds.getEmail() %></td>
									<td><%= ds.getTel() %></td> 
									<td><%= ds.getCin() %></td> 
									<td><%= ds.getNiveauInstruction() %></td>
									<td><%= ds.getQualificationProfessionnelle() %></td>
									 <td>
									<form role="form" method="post" action="${pageContext.request.contextPath}/SupprimerUtilisateurServlet">
											
										<div class="btn-group">
											
											
											 
												
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
					<th>Nationalité</th>
					<th>Email</th>
					<th>Numero de Tel°</th>
					<th>Cin</th>
					<th>Niveau d’instruction</th>
					<th>Qualification professionnelle </th>
					 <th>Action</th>
				</tr>
                  </tfoot>
                </table>
                         
                </div>
              </div>
            </div>
          </div>
    </section>
    </div>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
$('#tableUtilisateur tbody').on('click','#delete',function(){
	$(this).closest('tr').remove();
});
</script>
<jsp:include page="../includes/footer.jsp"></jsp:include>
    