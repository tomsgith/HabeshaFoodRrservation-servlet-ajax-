<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="component/header.jsp"></jsp:include>
<c:if test="${error_login != null}">
    <div class="alert alert-danger" role="alert">
        <c:out value="${error_login}"/>
    </div>
</c:if>
<div class="row">
    <div class="col-lg-12" >
        <div class="row">
            <div class="col-lg-4 m-md-auto">
                <span class="anchor"></span>

                <div class="card rounded-0">
                    <div class="card-header" >
                        Sign Up Form
                    </div>
                    <div class="card-body">
                        <form class="form" method="post" id="signupForm">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" class="form-control form-control-lg rounded-0" name="email"
                                       id="email" placeholder="email address"
                                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control form-control-lg rounded-0" id="password"
                                       name="password" placeholder="password" required pattern=".{6,}">
                            </div>
                            <div class="form-group">
                                <label for="fullname">Full Name</label>
                                <input type="text" class="form-control form-control-lg rounded-0" id="fullname"
                                       name="fullname" placeholder="full name" required>
                            </div>
                            <div class="form-group">
                                <label for="telephone">Telephone</label>
                                <input type="text" class="form-control form-control-lg rounded-0" id="telephone"
                                       name="telephone" placeholder="telephone" required pattern="\d{9,11}">
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control form-control-lg rounded-0" id="address"
                                       name="address" placeholder="address" required>
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn form-control btn-success btn-lg" value="Sign Up" >
                            </div>
                            <hr/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>