<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Tabela</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">
        <divclass="col-md-12 col-md-6 col-md-offset-3 col-xs-12">
            <table class="table table-bordered table-hover">

        </div>
    </div>
</div>
</div>

<thead>
<tr>
    <th>Id</th>
    <th>Imie</th>
    <th>Nazwisko</th>
    <th>Email</th>
</tr>
</thead>
<tbody>
    <c:forEach var ="user" items = "${usersList}">
<tr>
    <td>${user.id}</td>
    <td>${user.firstName}</td>
    <td>${user.lastName}</td>
    <td>${user.email}</td>
</tr>
    </c:forEach>
    
</tbody>
</table>
<a href="/users/create">Dodaj usera</a>
</body>
