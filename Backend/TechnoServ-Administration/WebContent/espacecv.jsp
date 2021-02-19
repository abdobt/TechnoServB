<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ma.fstt.entities.CV" import="java.util.List"%>
<!DOCTYPE html>
<% List<CV> lc=(List<CV>) request.getAttribute("lc"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Deposez votre CV</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<link rel="stylesheet" href="style2.css">
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
<div class="row" >

<% for(int i=0;i<lc.size();i++){ %>
<div class="col-4" >
<div class="card" style="width: 18rem;">
  <img src="cv.png" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">FIle</h5>
    <p class="card-text">CV</p>
    <form method="get" action="show.cv">
   <input  type="hidden" name="val" value="<%=lc.get(i).getId()%>" />
   <input type="submit" class="btn btn-primary " value="Consulter">
  </form>
  </div>
  </div>
  </div>
<%} %>

</div>
</div>
</body>
</html>