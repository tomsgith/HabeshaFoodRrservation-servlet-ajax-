<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>
<!-- /.col-lg-9 -->

</div>
<!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-lg-2 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Habesha Restaurant 2019</p>
    </div>
    <!-- /.container -->
</footer>

<div id="myModal" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Notice</h5>
            </div>
            <div class="modal-body">
                <p id="alertBody">Thank you for your ordering. Your order will be ready in  one Hour.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript -->
<script src="<c:url value="resources/js/jquery.min.js" />"></script>
<script src="<c:url value="resources/js/bootstrap.bundle.min.js"/>"></script>
<script src="<c:url value="resources/js/script.js"/>"></script>

<c:if test="${pageContext.request.servletPath.contains(\"shopping-cart\")}">
    <script src="<c:url value="resources/js/shopping-cart.js"/>"></script>
</c:if>

<c:if test="${pageContext.request.servletPath.contains(\"checkout\")}">
    <script src="<c:url value="resources/js/checkout.js"/>"></script>
</c:if>

</body>

</html>