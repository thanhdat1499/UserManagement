<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" style="color: orangered">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="AdminHomeController">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AddNewController">Create A New User</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ShowConfirmController">Confirm List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ShowPromotionListController">Promotion List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="LogoutController">Logout</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="SearchController" method="POST">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="name" value="${param.name}">
                    <button class="btn btn-outline-success my-2 my-sm-0" name="action" type="submit">Search</button>
                </form>

            </div>
        </nav>
        <div class="container mt-3">
            
                <h2 style="color: fuchsia">Welcome ${sessionScope.user.displayName} To Confirm Page!</h2>
                <br>
                
                <form action="UpdateConfirmController" method="POST">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">No</th>
                                <th scope="col">Photo</th>
                                <th scope="col">Name</th>
                                <th scope="col">Rank</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listPromotion}" var="P" varStatus="track">
                                <tr>
                                    <th scope="row">${track.count}</th>
                                    <td><img src="Images/${P.photo}" style="height: 150px"></td>
                                        <c:forEach items="${listUser}" var="U">
                                            <c:if test="${P.userId == U.id}">
                                            <td>${U.displayName}</td> 
                                        </c:if>
                                    </c:forEach>                
                                    <td style="width: 20%"><input type="number" name="rank${track.count-1}" step="any" min="1" max="10" value="${P.rankPromo}" required="true">  
                                    <td><a class="btn btn-danger" href="DeleteConfirmController?id=${P.userId}" onclick="return confirm('Are you sure you want to delete this user ?');">Delete</a></td>                                             
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <button type="submit" name="action" class="btn btn-success" style="width: 100px; margin-left: 68%">Update</button>
                    <a class="btn btn-danger" style="width: 100px; margin-left: 30px" href="DeleteConfirmController?deleteAll=1" onclick="return confirm('Are you sure you want to delete all user in list?');">Delete All</a>
                    <a class="btn btn-primary" style="width: 100px; margin-left: 30px" href="AddToPromotionListController">Confirm</a>
                </form>
            

        </div>
    </body>
</html>
