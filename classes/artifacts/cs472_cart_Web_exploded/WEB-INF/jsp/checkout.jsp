<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="component/header.jsp"></jsp:include>
<div class="row shopping-cart">
    <form class="payment-form">
        <div class="form-group row">
            <label for="fullName" class="col-sm-2 col-form-label">Full Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Name" value="${user.fullname}" required>
            </div>
        </div>
        <div class="form-group row">
            <label for="address" class="col-sm-2 col-form-label">Shipping Address</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="address" name="address" placeholder="Address" value="${user.address}" required>
            </div>
        </div>
        <div class="form-group row">
            <label for="address" class="col-sm-2 col-form-label">Payment</label>
            <div class="col-sm-10">
                <div class="form-check">
                    <label class="form-check-label" for="payInStore">
                        <input class="form-check-input" type="radio" id="payInStore" name="payment" value="Pay In Store" checked>
                        Pay In Store
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label" for="card">
                        <input class="form-check-input" type="radio" name="payment" id="card" value="Card">
                        Card
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group row">
            <label for="comment" class="col-sm-2 col-form-label">Comment</label>
            <div class="col-sm-10">
                <textarea cols="100" rows="10" class="form-control" id="comment" name="comment" placeholder="Comment"></textarea>
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-outline-primary">
                    <span class="fa fa-calendar"></span> Confirm
                </button>
            </div>
        </div>
    </form>
</div>
<jsp:include page="component/footer.jsp"></jsp:include>