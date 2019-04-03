<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 3/17/2019
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Reception</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="<c:url value="resources/css/bootstrap.css" />">
    <%--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="form-group">
        <label for="fullname">Search Customer</label>
        <input type="text" class="form-control form-control-lg rounded-0" id="email"
               name="Email" placeholder="Customers email" >
    </div>


    <button href="reception" type="button" class="btn btn-info btn-lg" id="searchBtn">Search Customer</button>
    <div class="table">
        <table id="custbody">
            <thead>
            <tr>
                <th>Id</th>
                <th>Email</th>
                <th>Full name</th>
                <th>Telephone</th>
                <th>Address</th>
            </tr>
            </thead >
            <tbody >

            </tbody>
        </table>
    </div>
</div>

<!-- Bootstrap core JavaScript -->
<script src="<c:url value="resources/js/jquery.min.js" />"></script>
<script src="<c:url value="resources/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="resources/js/script.js"/>"></script>
</body>
</html>
