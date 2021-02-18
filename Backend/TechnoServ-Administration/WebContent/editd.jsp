<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ma.fstt.entities.Demande"%>
    <%
    	Demande a=(Demande) request.getAttribute("a");
    %>
<!DOCTYPE html>
<html>
<head>
<style>
body{background-image: linear-gradient( 112.1deg,  rgba(32,38,57,1) 11.4%, rgba(63,76,119,1) 70.2% );}
</style>
<meta charset="UTF-8">
<title>Modification d'une demande</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="home.jsp">TechnoServ</a>
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
<div class="container">
<div class="row justify-content-center mt-5">
<div class="col-6">
<div class="card">
  <h5 class="card-header">Modifier une demande</h5>
  <div class="card-body">
   <form method="post" action="confirmedit.cmd">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >Adress </label>
    <input type="text" class="form-control" name="adresse" aria-describedby="emailHelp" value="<%=a.getAdresse() %>">
  </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >id_client</label>
    <input type="text" class="form-control" name="id_client" aria-describedby="emailHelp" value="<%=a.getId_client() %>">
  </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >id_specialite</label>
    <input type="text" class="form-control" name="id_specialite" aria-describedby="emailHelp" value="<%=a.getId_specialite()%>">
  </div>
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >Ratinig</label>
    <input type="text" class="form-control" name="rating" aria-describedby="emailHelp" value="<%=a.getRating()%>">
  </div>
  <input type="hidden" name="id" value=<%=a.getId() %>>
  <div class="col text-center">
  <button type="submit" class="btn btn-warning">Modifier</button>
  </div>
</form>
  </div>
</div>
</div>
</div>
</div>
</body>
</html>