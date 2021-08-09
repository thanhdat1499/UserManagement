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
            <h2 style="color: fuchsia">Welcome ${sessionScope.user.displayName} To Administration Page!</h2>
            <br>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="AdminHomeController?role_id=0">All</a>
                </li>
                <c:forEach items="${listRole}" var="R">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="AdminHomeController?role_id=${R.id}">${R.nameRole}</a>
                    </li>
                </c:forEach>
            </ul>


            <!-- Tab panes -->
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">Photo</th>
                        <th scope="col">Name</th>
                        <th scope="col">Username</th>
                        <th scope="col">Role</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Address</th>
                        <th scope="col">Create Date</th>
                        <th scope="col">Status</th>        
                        <th scope="col">Action</th>   
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listUser}" var="U" varStatus="counter">
                        <tr>
                            <th scope="row">${counter.count}</th>
                            <td><img src="Images/${U.photo}" style="height: 150px"></td>
                            <td>${U.displayName}</td>
                            <td>${U.username}</td>
                            <c:forEach items="${listRole}" var="R">
                                <c:if test="${U.role_Id == R.id}">
                                    <td style="color: salmon">${R.nameRole}</td>
                                </c:if>
                            </c:forEach>

                            <td>${U.email}</td>
                            <td>${U.phone}</td>
                            <td>${U.address}</td>
                            <td>${U.create_Date}</td>
                            <c:choose>
                                <c:when test="${U.status == 1}">
                                    <td class="text-success"><b>Active</b></td>
                                </c:when>
                                <c:otherwise>
                                    <td class="text-danger"><u>Inactive</u></td>
                                        </c:otherwise>
                                    </c:choose>
                            

                            <td colspan="2" style="width: 200px">
                                <a class="btn btn-info" href="UpdateController?id=${U.id}">Update</a>
                                <a class="btn btn-danger" href="DeleteController?id=${U.id}" onclick="return confirm('Are you sure you want to delete this user ?');">Delete</a>
                                <c:if test="${U.role_Id != 2 && U.status != 0}">
                                    <a class="btn btn-warning" style="margin-top: 5px" href="ConfirmController?id=${U.id}"
                                       <c:forEach items="${listPromotion}" var="P">
                                           <c:if test="${P.userId == U.id}">onclick="alert('User has already added')"</c:if>
                                       </c:forEach>
                                       <c:forEach items="${sessionScope.listPromotion}" var="P">
                                           <c:if test="${P.userId == U.id}">onclick="alert('User has already added to Confirm')"</c:if>
                                       </c:forEach>
                                       >Promote</a>
                                </c:if></td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
