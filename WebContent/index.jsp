<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="bootstrap/css/custom.css">
<link rel="stylesheet" href="bootstrap/css/datepicker.css">
<link rel="shortcut icon" href="img/trofeu.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                $('#dateinic').datepicker({
                    format: "dd/mm/yyyy"
                });  
            });
            
            $(document).ready(function () {
                $('#datefim').datepicker({
                    format: "dd/mm/yyyy"
                });  
            });
        </script>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<title>INDEX | GCE</title>
</head>
<body>
<c:import url="view/login.html"></c:import>
<c:import url="view/header.html"></c:import>
<br>

<div class="container">
	<c:import url="view/atletas.html"></c:import>
	<c:import url="view/equipes.html"></c:import>
	<c:import url="view/local.html"></c:import>
	<c:import url="view/competicao.html"></c:import>
	<c:import url="view/cartoes.jsp"></c:import>
	<c:import url="view/artilheiros.jsp"></c:import>
	<c:import url="view/tabela.jsp"></c:import>
	
	<c:import url="view/view_admin.html"></c:import>
</div>
<br>
<c:import url="view/footer.html"></c:import>
</body>
</html>