<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="component/header.jsp"></jsp:include>
    <div class="row shopping-cart">
        <!-- <h5> Shopping Cart</h5> -->
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Remove</th>
                <th>Image</th>
                <th>Recipe</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total</th>
            </tr>
            </thead>
            <tbody id="tblMyCart">
            <c:forEach items="${myCart}" var="item">
                <tr class="item" id="item_${item.product.id}">
                    <td><input class="check" type="checkbox" value="${item.product.id}" id="optionsCheckbox"></td>
                    <td class="muted center_text"><a href="product?id=${item.product.id}"><img src="<c:url value="resources/images/${item.product.image}" />" class="product-image"></a></td>
                    <td>${item.product.name}</td>
                    <td><input class="qty" type="number" placeholder="1" class="input-mini" value="${item.qty}" productid="${item.product.id}"></td>
                    <td class="price format-money">${item.price}</td>
                    <td class="total format-money">${item.price * item.qty}</td>
                </tr>
            </c:forEach>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><strong id="sum"></strong></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row shopping-cart">
        <div class="col-sm-2 col-md-auto">
            <button type="button" class="btn btn-primary bt active" id="btnRemove">
                <span class="fa fa-check-circle"></span> Remove
            </button>
        </div>
        <div class="col-sm-2 col-md-auto">
            <button type="button" class="btn  btn-primary bt active" id="btnContinueShopping">
                <span class="fa fa-forward"></span> Continue Ordering
            </button>
        </div>
        <div class="col-sm-2 col-md-auto">
            <button type="button" class="btn btn-primary bt active " id="btnCheckout">
                <span class="fa fa-calendar"></span> Checkout
            </button>
        </div>
    </div>
<jsp:include page="component/footer.jsp"></jsp:include>