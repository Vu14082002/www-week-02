<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="./template/head.jsp"/>
</head>

<body>
<jsp:include page="template/navbar-fix-top.jsp"/>
<div class="container">
    <jsp:include page="template/navbar-inner.jsp"/>
    <div class="row">
        <jsp:include page="template/span3.jsp"/>
        <div class="span9">
            <div class="well well-small">
                <div class="row-fluid">
                    <div class="span2">
                        <img src="assets/img/a.jpg" alt="">
                    </div>
                    <div class="span6">
                        <h5>Product Name </h5>
                        <p>
                            Nowadays the lingerie industry is one of the most successful business spheres.
                            We always stay in touch with the latest fashion tendencies -
                            that is why our goods are so popular..
                        </p>
                    </div>
                    <div class="span4 alignR">
                        <form class="form-horizontal qtyFrm">
                            <h3> $140.00</h3>
                            <div class="btn-group">
                                <a href="product_details.jsp" class="defaultBtn"><span
                                        class=" icon-shopping-cart"></span> Add to
                                    cart</a>
                                <a href="product_details.jsp" class="shopBtn">VIEW</a>
                            </div>
                        </form>
                    </div>
                </div>
                <hr class="soften">
            </div>
        </div>
    </div>
    <!--
Clients 
-->
    <jsp:include page="template/client-footer.jsp"/>
</div><!-- /container -->
<jsp:include page="template/coppyright.jsp"/>
</body>

</html>