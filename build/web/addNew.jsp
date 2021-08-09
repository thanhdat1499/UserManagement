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
                        <a class="nav-link" href="CreateUserController">Create A New User</a>
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
            <h2 style="color: fuchsia">Welcome ${sessionScope.user.displayName} To Update Page!</h2>
            <br>
            <form action="AddNewController" method="POST">
                
                <div class="form-group">
                    <label style="color: orange">UserName</label>
                    <input name="username" type="text" class="form-control" value="${userAddNew.username}">

                </div>
                <div class="form-group">
                    <label style="color: orange">Password</label>
                    <input name="password" type="password" class="form-control" value="${userAddNew.password}">

                </div>
                <div class="form-group">
                    <label style="color: orange">Name</label>
                    <input name="name" type="text" class="form-control" value="${userAddNew.displayName}">

                </div>

                <div class="form-group">
                    <label style="color: orange">Email</label>
                    <input name="email" type="text" class="form-control" value="${userAddNew.email}">

                </div>
                <div class="form-group">
                    <label style="color: orange" >Phone</label>
                    <input name="phone" type="text" class="form-control" value="${userAddNew.phone}">

                </div>
                <div class="form-group">
                    <label style="color: orange" >Address</label>
                    <input type="text" name="address" class="form-control" value="${userAddNew.address}">

                </div>
                <div class="form-group">
                    <label style="color: orange" >Photo</label>
                    <input type="text" name="photo" class="form-control" value="${userAddNew.photo}">

                </div>

                <button type="submit" class="btn btn-primary">Create</button>
            </form>

            <h5 style="color: red">${err}</h5>
        </div>
    </body>
</html>
