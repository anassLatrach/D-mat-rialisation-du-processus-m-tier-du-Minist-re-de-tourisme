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
<%@ page
	import="java.io.IOException, java.sql.SQLException,  java.util.*"%>
<%@ page import="ma.ministere.models.AbstractModel"%>
<%@ page import="ma.ministere.models.Agences"%>
<%@ page import="ma.ministere.dao.AgenceDao" %>
<% 
	AgenceDao gdao= new AgenceDao("agences");
ArrayList<AbstractModel> liste = gdao.getAll(); 	
Agences ds;
%>
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
          <ul class="treeview-menu active"><!-- for example : le Délégué peut ajouter des utilisateurs qui avec le role 
            "add-dossier" seulment , et un seul utilisateur qui est le délégué a le droit d'ajouter et les autre utilisateurs, 
            supprimer utilisateur(une colone (name = active) dans la table qui aura la valeur 0) , et approuver le dossier.-->
            <li class="active"><a href="#">Liste des agences</a></li>
            <li ><a href=" Agence.jsp">Ajouter un agence</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#"><i class="fa fa-users"></i> <span>Gestion des Personnels</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li class="treeview">
              <a href="#"><i class="fa fa-users"></i> Gestion des Gérants
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                  <li><a href="indexg.jsp">Liste des gérant</a></li>
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
						<h3 class="box-title">Listes des dossiers des AV :</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<table id="tableUtilisateur"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Numéro Dossier</th>
									<th>Nom Agence</th>
									<th>Forme Juridique</th>
									<th>siegeSociale</th>
									<th>N° Patente</th>
									<th>Nom Gerant</th>
									<th>Nom Directeur</th>
									<th>Types </th>
									<th>Documents </th>
									<th>Commentaire </th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
						<%  	for (AbstractModel abstractModel : liste) { ds = (Agences) abstractModel; %>
								 <tr>
									<td><%= ds.getIddossier() %></td>
									<td><%= ds.getNomAgence() %></td>
									<td><%= ds.getFormeJuridique() %></td>
									<td><%= ds.getSiegeSociale() %></td>
									<td><%= ds.getNumPatent() %></td>
									<td><%= ds.getNomGerant() %> <%= ds.getPrenomGerant() %></td>
									<td><%= ds.getNomDirecteur() %> <%= ds.getPrenomDirecteur() %></td>
									<td><%= ds.getType() %></td>
									
										<% 
										if(ds.getType().equals("morale") && ds.getFormulairedelav().equals("True") && ds.getActNaissance().equals("True")   && ds.getCasierjudiciare().equals("True")  && ds.getCdertinscription().equals("True")  && ds.getAttestationbancaire().equals("True")  && ds.getCopieCertifieeContratAssurance().equals("True") 	&& ds.getRapportPrevisionnel().equals("True")  && ds.getPiecesRelativeOrganisation().equals("True") && ds.getExempCertifSocieté().equals("True")  && ds.getListePersonnelRecruter().equals("True")   && ds.getCertifNegatif().equals("True")  && ds.getCautionBancaire().equals("True")   && ds.getExempAuthentifie().equals("True") ){ %>
												<td>tous les documents sont présent</td>
											<%}else if(ds.getType().equals("physique") && ds.getFormulairedelav().equals("True") && ds.getActNaissance().equals("True")   && ds.getCasierjudiciare().equals("True")  && ds.getCdertinscription().equals("True")  && ds.getAttestationbancaire().equals("True")  && ds.getCopieCertifieeContratAssurance().equals("True") 	&& ds.getRapportPrevisionnel().equals("True")  && ds.getPiecesRelativeOrganisation().equals("True")  && ds.getListePersonnelRecruter().equals("True")   && ds.getCertifNegatif().equals("True")  && ds.getCautionBancaire().equals("True")){ %>
										  		
										  		<td>tous les documents sont présent</td>
										  		<% }else { %>
										  		<td>Dossier Incomplet</td>
										  		<% } %>
									 
									
									
									<td><%= ds.getComment() %></td>
								 		<td>	
										<div class="btn-group">
											
											
											
											<a href="EditUser.jsp" type="button" class="btn btn-primary btn-flat btnDelete"
												data-toggle="modal" data-target="#modal-default"
												id="UtilisateurEdit"><i class="fa fa-pencil-square-o"></i></a>
											 
											
										</div> 
									</td>
								</tr>
							<% } %>
							</tbody>
							<tfoot>
								<tr> 
								<th>Numéro Dossier</th>
									<th>Nom Agence</th>
									<th>Forme Juridique</th>
									<th>siegeSociale</th>
									<th>N° Patente</th>
									<th>Nom Gerant</th>
									<th>Nom Directeur</th>
									<th>Types </th>
									<th>Documents </th>
									<th>Commentaire </th>
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
                <h4 class="modal-title">Validate</h4>
              </div>
              <div class="modal-body">
                  <form role="form"  method="post" action="${pageContext.request.contextPath}/ValidateDossierServlet">
                      <div class="box-body"> 
                        <div class="form-group col-xs-6">
                          <label>Numéro Dossier :</label>
                          <input type="text" class="form-control" id="iddossier" name="iddossier" placeholder="numero dossier">
                        </div>
                        <div class="form-group col-xs-6">
                          <label>Nom Agence :</label>
                          <input type="text" class="form-control" id="nomAgence" name="nomAgence" placeholder="Nom Agence">
                        </div>
                        <div class="form-group col-xs-6">
                          <label>Documents  :</label>
                          <p  id="document"> </p>
                        </div>
                        <div class="form-group col-xs-12">
                          <label>Status :</label>
                          <select class="form-control select2" id="status" name="status" style="width: 100%;">
                            <option selected="selected" value="valide">Validé</option>
                            <option value="Non Valide">Non Validé</option>
                          </select>
                        </div>
                        <div class="form-group col-xs-12" >
                          <label>Commentaire  :</label>
                          <textarea  class="form-control" id="commentaire" name="commentaire" ></textarea>
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
	var iddossier = currentRow.find("td:eq(0)").text().trim(); // get current row 2nd TD
	var nomAgence = currentRow.find("td:eq(1)").text().trim(); // get current row 1st TD value
	var document  = currentRow.find("td:eq(8)").text().trim(); // get current row 8th TD
	$('#iddossier').val(iddossier);
	$('#nomAgence').val(nomAgence); 
	$('#document').text(document);  
});
</script>
<script>
$('#tableUtilisateur tbody').on('click','#delete',function(){
	$(this).closest('tr').remove();
});
</script>

<jsp:include page="../includes/footer.jsp"></jsp:include>


      
  