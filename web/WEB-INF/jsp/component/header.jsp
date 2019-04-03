<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Habesha Restaurant</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="<c:url value="resources/css/bootstrap.css" />">
    <%--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom fixed-top shadow-sm p-lg-1 mb-lg-3">
    <div class="container">
        <a class="navbar-brand text-black-50" href="#">Habesha Restaurant</a>
        <a class="navbar-brand text-black-50" href="#">About</a>
        <a class="navbar-brand text-black-50" href="#">Contact</a>
        <a class="navbar-brand text-black-50" href="#">Reception</a>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <c:if test="${email == null}">
                    <li class="nav-item active ">
                        <a class="nav-link text-black-50" href="login">Login</a>
                    </li>
                    <li class="nav-item active ">
                        <a class="nav-link text-black-50" href="register">Register</a>
                    </li>
                </c:if>
                <c:if test="${email != null}">
                    <li class="nav-item active ">
                        <a class="nav-link text-black-50" href="profile">Profile</a>
                    </li>
                    <li class="nav-item active ">
                        <a class="nav-link text-black-50" href="logout">Logout</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->

<div class="container">

    <div class="row">


        <!-- /.col-lg-3 -->

        <div class="col-lg-9" >

            <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <img class="d-block img-fluid" src="<c:url value="resources/images/bnnr1c.png" />" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid" src="<c:url value="resources/images/bnnr2c.jpg" />" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid" src="<c:url value="resources/images/bnnr3c.jpg" />" alt="Third slide">
                    </div>


                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

        </div>

        <div class="col-md-3">

            <h1 class="my-auto ">Habesha Restaurant </h1>


            <div class="list-group">
                <a href="/cart" class="list-group-item d-inline justify-content-between align-items-center text-primary">
                    Home
                </a>
                <a href="/cart/cat?id=1" class="list-group-item d-inline justify-content-between align-items-center text-primary" >
                    Large Plate
                </a>
                <a href="/cart/cat?id=2" class="list-group-item d-inline justify-content-between align-items-center text-primary" >
                    Small Plate
                </a>
                <a href="shopping-cart" class="list-group-item d-inline justify-content-between align-items-center text-primary" >
                    View Order
                    <span>
                        <i class="fa fa-shopping-cart"></i>
                        <span id="num-of-items" class="badge badge-primary badge-pill">${numItems}</span>
                    </span>
                </a>
            </div>

        </div>
    </div>
</div>
</body>