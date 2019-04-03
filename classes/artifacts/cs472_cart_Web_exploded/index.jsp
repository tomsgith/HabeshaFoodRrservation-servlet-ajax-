<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/jsp/component/header.jsp"></jsp:include>

      <div class="row col-lg-9 col-md-6 mb-4">

        <c:forEach items="${products}" var="product">
          <c:url value="shopping-cart" var="linkAddToCart">
            <c:param name="productId" value="${product.id}"/>
          </c:url>
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="product?id=${product.id}"><img class="card-img-top" src="<c:url value="resources/images/${product.image}" />" alt=""></a>
              <div class="card-body">
                <h4 class="card-title ">
                  <a  class="a1 text-warning" href="product?id=${product.id}">${product.name}</a>
                </h4>
                <p class="card-text">${product.shortDescription}</p>
                <p class="card-text"> $ ${product.price}</p>
              </div>
              <div class="card-footer text-center">
                <a href="${linkAddToCart}" class="btn btn-primary bt active addToCart" role="button" aria-pressed="true">Add order</a>
              </div>
            </div>
          </div>
        </c:forEach>

      </div>

<jsp:include page="WEB-INF/jsp/component/footer.jsp"></jsp:include>