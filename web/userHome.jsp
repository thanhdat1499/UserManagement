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
        
        <div class="container mt-3">
            <h2 style="color: fuchsia" style="text-align: center">Your Profile</h2>
            <br>


            <div class="col-md-3">
                ​<picture>
                    <source srcset="Images/${user.photo}" type="image/svg+xml" style="width: 400px">
                    <img src="Images/${user.photo}" class="img-fluid img-thumbnail" alt="..." style="width: 400px"> 
                </picture>                       
            </div>
            <div class="form-group">
                <label style="color: orange">Name</label>
                <input name="name" type="text" class="form-control" value="${user.displayName}">

            </div>

            <div class="form-group">
                <label style="color: orange">Email</label>
                <input name="email" type="text" class="form-control" value="${user.email}">

            </div>
            <div class="form-group">
                <label style="color: orange" >Phone</label>
                <input name="phone" type="text" class="form-control" value="${user.phone}">

            </div>
            <div class="form-group">
                <label style="color: orange" >Address</label>
                <input type="text" name="address" class="form-control" value="${user.address}">

            </div>

            <div class="form-group">
                <a class="btn btn-danger" href="LogoutController">Logout</a>
            </div>
             



        </div>
    </body>
</html>
