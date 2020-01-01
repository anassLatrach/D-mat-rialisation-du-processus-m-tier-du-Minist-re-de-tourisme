<%@ page import ="ma.ministere.models.Utilisateurs,ma.ministere.dao.UtilisateurDao"  %>
<% 
UtilisateurDao udao = new UtilisateurDao("users");
Utilisateurs user = (Utilisateurs) udao.getByID(Integer.parseInt(request.getParameter("id"))); %>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">Modifier Utilisateur</h4>
</div>
<div class="modal-body">
	<form role="form" action="${pageContext.request.contextPath}/ModifierUtilisateurServlet" method="POST">
		<div class="box-body">
		<input type="hidden" class="form-control" id="id" name="id"  >
			<div class="form-group col-xs-6">
				<label>Nom :</label> <input type="text" class="form-control"
					id="nom" name="nom" placeholder="Nom" >
			</div>
			<div class="form-group col-xs-6">
				<label>Prénom :</label> <input type="text" class="form-control"
					id="prenom" name="prenom" placeholder="Prenom">
			</div>
			<div class="form-group col-xs-6">
				<label>N° Télephone :</label> <input type="tel" class="form-control"
					id="numTel" name="numTel" placeholder="N° Télephone" >
			</div>
			<div class="form-group col-xs-6">
				<label>Email :</label> <input type="email" class="form-control"
					id="email" name="email" placeholder="Email" >
			</div>
			<div class="form-group col-xs-6">
				<label>Password :</label> <input type="password"
					class="form-control" id="genpassword" name="password"
					placeholder="password">
			</div>
			<div class="form-group col-xs-6">
				<label>&nbsp;&nbsp;&nbsp;</label><br>
				<div class="btn-group-vertical">
					<button type="button" class="btn btn-default">
						<i class="fa fa-refresh" onclick="passwordGenrate()"></i>
					</button>
				</div>
			</div>
		</div>
		<!-- /.box-body -->
		
<div class="modal-footer">
	<button type="button" class="btn btn-default pull-left"
		data-dismiss="modal">Close</button>
	<div class="box-footer">
		<button type="submit" class="btn btn-primary" >Submit</button>
	</div>
	</form>
</div>
</div>
</div>
