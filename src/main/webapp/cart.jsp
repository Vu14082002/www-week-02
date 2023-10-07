<%@ page import="vn.edu.iuh.fit.backend.dto.allProperty.ProductDTOAllProperty" %>
<%@ page import="java.util.Map" %>
<%@ page import="vn.edu.iuh.fit.backend.models.ProductImage" %>
<%@ page import="vn.edu.iuh.fit.backend.models.ProductPrice" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="./template/head.jsp"/>
    <script defer src="./assets/js/cart.js"></script>
</head>
<body>
<% Map<ProductDTOAllProperty, Integer> procs = (Map<ProductDTOAllProperty, Integer>) session.getAttribute("cart");
    double totalItems = 0.0;
%>
<jsp:include page="template/navbar-fix-top.jsp"/>
<div class="container">
    <jsp:include page="template/navbar-inner.jsp"/>
    <div class="row">
        <div class="span12">
            <ul class="breadcrumb">
                <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                <li class="active">Check Out</li>
            </ul>
            <div class="well well-small">
                <h1>Check Out <small class="pull-right"> </small></h1>
                <hr class="soften"/>
                <form action="<%=request.getContextPath()+"/cart"%>" method="post">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>Product</th>
                            <th>Description</th>
                            <th> Ref.</th>
                            <th>Avail.</th>
                            <th>Unit price</th>
                            <th>Qty</th>
                            <th>Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Map.Entry<ProductDTOAllProperty, Integer> e : procs.entrySet()) {
                                if (e.getKey().getProductImageList().size() != 0) {
                                    String pathImg = "";
                                    String procImgName = "";
                                    double procPrice = 0.0D;
                                    for (ProductImage img : e.getKey().getProductImageList()) {
                                        pathImg = img.getPath();
                                        procImgName = img.getAlternative();
                                    }
                                    for (ProductPrice price : e.getKey().getProductPrices()) {
                                        procPrice = price.getPrice();
                                    }

                                    String total = String.format("%.2f", procPrice * e.getValue());
                                    totalItems += procPrice * e.getValue();
                        %>
                        <tr>

                            <td><img width="100" src="<%=pathImg%>" alt="anh san pham"></td>
                            <td><%=e.getKey().getName()%>
                            </td>
                            <td>-</td>
                            <td><span class="shopBtn"><span class="icon-ok"></span></span></td>
                            <td class="price">$<%=procPrice%>
                            </td>
                            <td>
                                <input class="span1" style="max-width:34px" placeholder="1" size="16" type="number"
                                       name="<%=e.getKey().getProduct_id()%>" value="<%=e.getValue()%>"/>
                                <div class="input-append">
                                    <button class="btn btn-mini btn-minus" type="button">-</button>
                                    <button class="btn btn-mini btn-add" type="button">+</button>
                                    <button class="btn btn-mini btn-danger" type="submit" name="idDelete"
                                            value="<%=e.getKey().getProduct_id()%>">
                                        <span class="icon-remove"></span>
                                    </button>
                                </div>
                            </td>
                            <td class="totalItem">$<%=total%>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                        <tr>
                            <td colspan="6" class="alignR">Total products:</td>
                            <td class="label label-primary totalItems">$<%=totalItems%>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <br/>
                    <a href="products.html" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue
                        Shopping </a>
                    <input type="submit" value="order" name="order" class="shopBtn btn-large pull-right"/>
                </form>
            </div>
        </div>
    </div>
    <!--
Clients 
-->

</div>
<!-- /container -->


<!-- Placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.easing-1.3.min.js"></script>
<script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
<script src="assets/js/shop.js"></script>
</body>

</html>