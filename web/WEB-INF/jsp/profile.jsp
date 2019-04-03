
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="component/header.jsp"></jsp:include>
<c:if test="${error_login != null}">
    <div class="alert alert-danger" role="alert">
        <c:out value="${error_login}"/>
    </div>
</c:if>
<div class="row shopping-cart">
    <!-- <h5> Shopping Cart</h5> -->

    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Full Name</th>
            <th>Email</th>
            <th>Telephone</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody id="tblMyCart">
        <tr class="item">
            <td>${user.fullname}</td>
            <td>${user.email}</td>
            <td>${user.telephone}</td>
            <td>${user.address}</td>
        </tr>

        </tbody>
    </table>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>