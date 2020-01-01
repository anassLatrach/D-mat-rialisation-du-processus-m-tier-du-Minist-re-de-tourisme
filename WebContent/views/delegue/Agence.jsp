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
<!-- Left side column. contains the logo and sidebar -->
<%@ page import="ma.ministere.dao.GerantDao"%>
<%@ page import="ma.ministere.dao.DirecteurDao"%>
<%@ page
	import="java.io.IOException, java.sql.SQLException,  java.util.*"%>
<%@ page import="ma.ministere.models.AbstractModel"%>
<%@ page import="ma.ministere.models.Gerants"%>
<%@ page import="ma.ministere.models.Directeurs"%>
<%  GerantDao udao = new GerantDao("gerants"); %>
<% ArrayList<AbstractModel> liste = udao.getAll(); %>
<% Gerants ds; %>

<%  DirecteurDao ddao = new DirecteurDao("directeurs"); %>
<% ArrayList<AbstractModel> listDire = ddao.getAll(); %>
<% Directeurs directeur; %>

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
         
        <li class="treeview active">
          <a href="#"><i class="fa fa-institution"></i> <span>Gestion des Agences</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu "><!-- for example : le Délégué peut ajouter des utilisateurs qui avec le role 
            "add-dossier" seulment , et un seul utilisateur qui est le délégué a le droit d'ajouter et les autre utilisateurs, 
            supprimer utilisateur(une colone (name = active) dans la table qui aura la valeur 0) , et approuver le dossier.-->
            <li><a href="indexg.jsp">Liste des agences</a></li>
            <li class="active"><a href="Agence.html">Ajouter un agence</a></li>
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
                  <ul class="treeview-menu active">
                      <li><a href="indexd.jsp">Liste des directeurs</a></li>
                      <li><a href="Directeur.jsp">Ajouter un directeur</a></li>
                    </ul> 
          </li>
          </ul>
        </li>
        
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

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
          <div class="box box-primary">
            <div class="box-header">
              <h3 class="box-title">Fiche signalétique de l’agence de voyages   :</h3>
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body ">
              <form role="form" method="post" action="${pageContext.request.contextPath}/AjouterAgenceServlet">
                  <div class="form-group col-xs-6">
                    <label>Nom de l'agence :</label>
                    <input type="text" class="form-control" id="nomAgence" name="nomAgence" placeholder="Nom de l'agence">
                  </div>
                  <div class="form-group col-xs-6">
                      <label>Nom et Prenom du Gérant :</label>
                      <select class="form-control select2" style="width: 100%;" name="idGerant">
                   
	  <% for (AbstractModel abstractModel : liste) { ds = (Gerants) abstractModel; %> 
                        <option value="<%= ds.getId() %>"> <%= ds.getNom() %>  <%= ds.getPrenom() %> </option>
                        <%} %>
                      </select>
                  </div>
                  <div class="form-group col-xs-6">
                      <label>Nom et Prenom du directeur :</label>
                      <select class="form-control select2" style="width: 100%; " name="idDirecteur">
                        <% for (AbstractModel abstractModel : listDire) { directeur = (Directeurs) abstractModel; %> 
                        <option value="<%= directeur.getId() %>"> <%= directeur.getNom() %>  <%= directeur.getPrenom() %> </option>
                        <%} %>
                      </select>
                  </div>
                  <div class="form-group col-xs-6">
                    <label>Raison Sociale :</label>
                    <input type="text" class="form-control" id="raisonSociale" name="raisonSociale" placeholder="Raison Sociale">
                  </div>
                  <div class="form-group col-xs-6">
                    <label>Forme Juridique :</label>
                    <input type="text" class="form-control" id="formeJuridique" name="formeJuridique" placeholder="Forme Juridique">
                  </div>
                  <div class="form-group col-xs-6">
                    <label>Siége Social :</label>
                    <input type="text" class="form-control" id="siegeSociale" name="siegeSociale" placeholder="Siége Social">
                  </div>
                  <div class="form-group col-xs-6">
                      <label >Capital Souscrit :</label>
                      <input type="text" class="form-control" id="capitalSouscrit" name="capitalSouscrit" placeholder="Capital Souscrit">
                  </div>
                  <div class="form-group col-xs-6">
                      <label >Capital Libéré :</label>
                      <input type="text" class="form-control" id="capitalLibere" name="capitalLibere"  placeholder="Capital Libéré">
                  </div>
                  <div class="form-group col-xs-6">
                    <label >Registre du commerce :</label>
                    <input type="text" class="form-control" id="registreCommerce" name="registreCommerce" placeholder="Registre du commerce">
                  </div>
                  <div class="form-group col-xs-6">
                    <label >N° de patente  :</label>
                    <input type="text" class="form-control" id="numPatente" name="numPatente" placeholder="N° de patente" onchange="myFunction()">
                  </div>
                  <div class="form-group col-xs-6">
                    <label>N° Télephone :</label>
                    <input type="tel" class="form-control" id="numTel" name="numTel" placeholder="N° Télephone">
                  </div> <div class="form-group col-xs-6">
                    <label>N° Fax :</label>
                    <input type="tel" class="form-control" id="fax" name="fax" placeholder="N° Fax">
                  </div>
                  <div class="form-group col-xs-6">
                    <label>Email  :</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                  </div>
                  <div class="form-group col-xs-6">
                    <label>Site Web  :</label>
                    <input type="text" class="form-control" id="siteweb" name="siteWeb" placeholder="site Web">
                  </div>
                  
                 <!-- <div class="form-group col-xs-6">
                    <label >Nom du gérant :</label>
                    <input type="text" class="form-control" id="registreCommerce" name="registreCommerce" placeholder="Registre du commerce">
                  </div>
                  <div class="form-group col-xs-6">
                    <label >prénom du gérant   :</label>
                    <input type="text" class="form-control" id="numPatente" name="numPatente" placeholder="N° de patente">
                  </div>
                  <div class="form-group col-xs-6">
                    <label >Participation dans d’autres affaires  :</label>
                    <input type="text" class="form-control"  placeholder="Niveau d’instruction">
                  </div>
                -->
                 
                  <div class="form-group col-xs-12">
                    <label>Identifiant du dossier :</label>
                    <input type="text" class="form-control" id="iddossier" name="iddossier" >
                  </div>
                  
                  <div class="form-group col-xs-12">
                    <label>Type Pormoteur :</label>
                    <select class="form-control select2" id="typePromoteur" name="typePromoteur" style="width: 100%;">
                      <option selected="selected" value="physique">Personne physique</option>
                      <option value="morale">Personne morale</option>
                    </select>
                  </div>
                  <div id="PersonnePhysique">
                    <div class="checkbox col-xs-6">
                      <label>
                         2 exemplaires du formulaire de demande de licence d’agence de voyages, dûment remplis et signés (signature légalisée).
                       </label>
                      	<select class="form-control" style="width: 20%;" name="formulairedelav">
                      	<option value="True">True</option>
                      	<option value="False" selected>False</option>
                      	</select>
                     
                      <label>
                       1 extrait d’acte de naissance, daté de moins de trois mois (original).
                      </label>
                      <select class="form-control" style="width: 20%;" name="actNaissance">
                      	<option value="True">True</option>
                      	<option value="False" selected>False</option>
                      	</select>
                      <label>
                          1 extrait du casier judiciaire ou de la fiche anthropométrique, daté de moins de trois mois (original).
                      </label>
                      <select class="form-control" style="width: 20%;" name="casierjudiciare">
                      	<option value="True">True</option>
                      	<option value="False" selected>False</option>
                      	</select>
                      <label>
                          1 certificat d’inscription au registre du commerce dûment légalisé, précisant l'unicité d'activité 'agence de voyage', ou, le cas échéant, une déclaration d’intention de s’y inscrire comme agent de voyages à remettre après l'accord de principe du comité technique.
                      </label>
                      <select class="form-control" style="width: 20%;" name="cdertinscription">
                      		<option value="True">True</option>
                      		<option value="False" selected>False</option>
                      </select>
                      <label>
                            1 Attestation bancaire de Capacité Financière au nom de la société et portant en-tête de la banque, ou le cas échéant, un engagement sur l'honneur de la présenter avant la délivrance de la licence provisoire.
                        </label>
                        <select class="form-control" style="width: 20%;" name="attestationbancaire">
                      	<option value="True">True</option>
                      	<option value="False" selected>False</option>
                      	</select>
                    </div>
                    <div class="checkbox col-xs-6">
                        <label>
                               1 copie certifiée conforme d’un contrat d’assurance contre les conséquences pécuniaires de la responsabilité civile professionnelle (à déposer ultérieurement).
                        </label>
                      <select class="form-control" style="width: 20%;" name="copieCertifieeContratAssurance">
                      		<option value="True">True</option>
                      		<option value="False" selected>False</option>
                      </select>
                        <label>
                             1 rapport prévisionnel sur les activités que compte entreprendre le promoteur dans le cadre de son agence de voyages (plan d’action).
                        </label>
                      <select class="form-control" style="width: 20%;" name="rapportPrevisionnel">
                      		<option value="True">True</option>
                      		<option value="False" selected>False</option>
                      </select>
                        <label>
                               Des pièces relatives à l’organisation matérielle de l’agence : plan de situation, plan d’aménagement intérieur, détail de l’équipement .
                        </label>
                      <select class="form-control" style="width: 20%;" name="PiecesRelativeOrganisation">
                      		<option value="True">True</option>
                      		<option value="False" selected>False</option>
                      </select>
                        <label>
                             La liste du personnel à recruter et ses qualifications .
                        </label>
                      <select class="form-control" style="width: 20%;" name="listePersonnelRecruter">
                      		<option value="True">True</option>
                      		<option value="False" selected>False</option>
                      </select>
                        <label>
                                1 Certificat négatif.
                        </label>
                      <select class="form-control" style="width: 20%;" name="certifNegatif">
                      		<option value="True">True</option>
                      		<option value="False" selected>False</option>
                      </select>
                        <label>
                                1 caution bancaire de 200.000 Dhs, à déposer ultérieurement auprès de la Caisse de Dépôt et de gestion.
                        </label>
                      <select class="form-control" style="width: 20%;" name="cautionBancaire">
                      		<option value="True">True</option>
                      		<option value="False" selected>False</option>
                      </select>
                    </div>
                  </div>
                  <div id="PersonneMorale" style="display:none;">
                      <div class="checkbox col-xs-12">
                          <label>
                               1 exemplaire certifié conforme des Statuts de la société en prenant soin de veiller à la conformité 
                              de l’objet de la société avec les dispositions de l’article 1 
                              du dahir portant Loi n° 31-96 du 4 chaoual 1417 ( 12 février 1997) portant statut des agences de voyages. 
                          </label>
                           <select class="form-control" style="width: 20%;" name="exempCertifSociete">
                      		<option value="True">True</option>
                      		<option value="False" selected>False</option>
                      </select>
                          <label>
                                 1 exemplaire authentifié de la liste des actionnaires et des membres du conseil d’administration
                          </label>
                           <select class="form-control" style="width: 20%;" name="exempAuthentifie">
                      		<option value="True">True</option>
                      		<option value="False" selected>False</option>
                      </select>
                      </div>
                  </div><br>
       	<div class="form-group col-xs-12">
                    <label>Commentaire  :</label>
                    <textarea  class="form-control" id="comment" name="comment"  rows="3" cols="2"></textarea>
                  </div>
      	
                 
                <!-- /.box-body -->
      
                <div class="box-footer col-xs-12">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </form>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>

    </section>
       
    <!-- /.content -->
  </div>
  
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<div class="modal fade" id="gerant">
  <div class="modal-dialog">
    <div class="modal-content">
    	<div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
      <h4 class="modal-title">Ajouter gérant</h4>
    </div>
    <div class="modal-body">
    </div>
  </div>
  <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</div>





<div class="modal fade" id="modal-default2">
  <div class="modal-dialog">
    <div class="modal-content">
      
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
      <h4 class="modal-title"> Ajouter Directeur</h4>
    </div>
    <div class="modal-body">  
    
       
    </div>
  </div>
  <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</div>

<script>
function myFunction() {
	  var nomAgence = document.getElementById("nomAgence");
	  var numPatente = document.getElementById("numPatente");
	  var all = nomAgence.value[0] +  nomAgence.value[1] +  nomAgence.value[2] +    nomAgence.value[3] + numPatente.value;
	  document.getElementById("iddossier").value = all;
	}
</script>


<jsp:include page="../includes/footer.jsp"></jsp:include>

