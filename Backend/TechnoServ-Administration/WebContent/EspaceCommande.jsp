<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ma.fstt.entities.Demande" import="java.util.List" %>
<!DOCTYPE html>
<%
	List<Demande> lc=(List<Demande>) request.getAttribute("commandes");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Espace Demande</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="stylesheet" href="style2.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="home.jsp">TechnnoServ</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Espace Client
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="e.c">Gérer les clients</a></li>
            <li><a class="dropdown-item" href="addc.jsp">Ajouter un client</a></li>
          </ul>
        </li>
       <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="e.p" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Espace Technicien
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="e.p">Gérer les technicien</a></li>
            <li><a class="dropdown-item" href="addp.jsp">Ajouter un technicien</a></li>
            <li><a class="dropdown-item" href="e.cv">Les CVs</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Espace Demande
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="e.cmd">Gérer les demandes</a></li>
             <li><a class="dropdown-item" href="addcmd.jsp">Ajouter une demande</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<body>
<div class="sec">
<h1><span class="blue">Espace</span> <span class="yellow">Demande</span></h1>
</div>
<table class="container">
	<thead>
		<tr>
			<th><h1>id</h1></th>
			<th><h1>Adress</h1></th>
			<th><h1>id client</h1></th>
			<th><h1>id_specialite</h1></th>
			<th><h1>Rating</h1></th>
			<th><h1>Latitude</h1></th>
			<th><h1>Longitude</h1></th>
			<th><h1>Delete</h1></th>
			<th><h1>Edit</h1></th>
		</tr>
	</thead>
	<tbody>
	<% for(int i=0;i<lc.size();i++){ %>
		<tr>
			<td><%=lc.get(i).getId() %></td>
			<td><%=lc.get(i).getAdresse() %></td>
			<td><%=lc.get(i).getId_client() %></td>
			<td><%=lc.get(i).getId_specialite()%></td>
			<td><%=lc.get(i).getRating() %></td>
			<td><%=lc.get(i).getLattitude()%></td>
			<td><%=lc.get(i).getLattitude() %></td>

  			<td>
  				<form method="get" action="delete.cmd">
   					<input  type="hidden" name="val" value="<%=lc.get(i).getId()%>" />
   					<input type="submit" class="btn btn-outline-dark " value="Delete">
 				 </form>
 			</td>
    		<td>
  				<form method="get" action="edit.cmd">
   					<input  type="hidden" name="val" value="<%=lc.get(i).getId()%>" />
   					<input type="submit" class="btn btn-outline-info" value="Edit">
  				</form>
  			</td>
		</tr>
		<%} %>
	</tbody>
</table>
</body>
</html>