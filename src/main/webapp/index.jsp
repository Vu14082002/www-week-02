<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.dto.allProperty.ProductDTOAllProperty" %>
<%@ page import="vn.edu.iuh.fit.backend.models.Product" %>
<%@ page import="vn.edu.iuh.fit.backend.models.ProductImage" %>
<%@ page import="vn.edu.iuh.fit.backend.models.ProductPrice" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="./template/head.jsp"/>
</head>

<body>
<!--
Upper Header Section
-->
<jsp:include page="template/navbar-fix-top.jsp"/>
<!--
Lower Header Section 
-->
<div class="container">

    <!--
Navigation Bar Section 
-->
    <jsp:include page="template/navbar-inner.jsp"/>
    <!--
Body Section 
-->
    <div class="row">
        <jsp:include page="template/span3.jsp"/>
        <div class="span9">
            <div class="well np">
                <div id="myCarousel" class="carousel slide homCar">
                    <div class="carousel-inner">
                        <div class="item">
                            <img style="width:100%" src="assets/img/bootstrap_free-ecommerce.png"
                                 alt="bootstrap ecommerce templates">
                            <div class="carousel-caption">
                                <h4>WWW programming with Java technology</h4>
                                <p><span>Very clean simple to use</span></p>
                            </div>
                        </div>

                        <div class="item active">
                            <img style="width:100%" src="assets/img/carousel3.png" alt="bootstrap ecommerce templates">
                            <div class="carousel-caption">
                                <h4>WWW programming with Java technology</h4>
                                <p><span>Very easy to integrate and expand.</span></p>
                            </div>
                        </div>
                        <div class="item">
                            <img style="width:100%" src="assets/img/bootstrap-templates.png" alt="bootstrap templates">
                            <div class="carousel-caption">
                                <h4>WWW programming with Java technology</h4>
                                <p><span>Compitable to many more opensource cart</span></p>
                            </div>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
                </div>
            </div>
            <!--
New Products
-->
            <% List<ProductDTOAllProperty> products = (List<ProductDTOAllProperty>) request.getAttribute("products");
                List<ProductDTOAllProperty> bestProc = (List<ProductDTOAllProperty>) request.getAttribute("bestProc");
            %>
            <div class="well well-small">
                <h3>New Products </h3>
                <hr class="soften"/>
                <div class="row-fluid">
                    <div id="newProductCar" class="carousel slide">
                        <div class="carousel-inner">
                            <%
                                int numPage = products.size() / 4;
                                for (int index = 0; index < numPage; index++) {%>
                            <div class="item <%=index==0?"active":""%>">
                                <ul class="thumbnails">
                                    <%
                                        for (int item = 0; item < 4; item++) {
                                            ProductDTOAllProperty proc = products.get(item + (index * 4));
                                            if (proc.getProductImageList().size() != 0) {
                                                String pathImg = "";
                                                for (ProductImage e : proc.getProductImageList()) {
                                                    pathImg = e.getPath();
                                                }
                                    %>
                                    <li class="span3">
                                        <div class="thumbnail">
                                            <a class="zoomTool" href="product_details?<%=proc.getProduct_id()%>"
                                               title="add to cart"><span
                                                    class="icon-search"></span> QUICK VIEW</a>
                                            <a href="#" class="tag"></a>
                                            <a href=href="product_details?<%=proc.getProduct_id()%>">
                                                <img src="<%=pathImg%>"
                                                     alt="bootstrap-ring">
                                            </a>
                                        </div>
                                    </li>
                                    <%
                                            }
                                        }
                                    %>
                                </ul>
                            </div>
                            <%}%>
                        </div>
                        <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
                        <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
                    </div>
                </div>
                <div class="row-fluid">
                    <ul class="thumbnails">
                        <%--                        <li class="span4">--%>
                        <%--                            <div class="thumbnail">--%>
                        <%--                                <a class="zoomTool" href="product_details.jsp" title="add to cart"><span--%>
                        <%--                                        class="icon-search"></span>--%>
                        <%--                                    QUICK VIEW</a>--%>
                        <%--                                <a href="product_details.jsp"><img src="assets/img/b.jpg" alt=""></a>--%>
                        <%--                                <div class="caption cntr">--%>
                        <%--                                    <p>Manicure & Pedicure</p>--%>
                        <%--                                    <p><strong> $22.00</strong></p>--%>
                        <%--                                    <h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>--%>
                        <%--                                    <div class="actionList">--%>
                        <%--                                        <a class="pull-left" href="#">Add to Wish List </a>--%>
                        <%--                                        <a class="pull-left" href="#"> Add to Compare </a>--%>
                        <%--                                    </div>--%>
                        <%--                                    <br class="clr">--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                        </li>--%>
                        <%--                        <li class="span4">--%>
                        <%--                            <div class="thumbnail">--%>
                        <%--                                <a class="zoomTool" href="product_details.jsp" title="add to cart"><span--%>
                        <%--                                        class="icon-search"></span>--%>
                        <%--                                    QUICK VIEW</a>--%>
                        <%--                                <a href="product_details.jsp"><img src="assets/img/c.jpg" alt=""></a>--%>
                        <%--                                <div class="caption cntr">--%>
                        <%--                                    <p>Manicure & Pedicure</p>--%>
                        <%--                                    <p><strong> $22.00</strong></p>--%>
                        <%--                                    <h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>--%>
                        <%--                                    <div class="actionList">--%>
                        <%--                                        <a class="pull-left" href="#">Add to Wish List </a>--%>
                        <%--                                        <a class="pull-left" href="#"> Add to Compare </a>--%>
                        <%--                                    </div>--%>
                        <%--                                    <br class="clr">--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                        </li>--%>
                        <%--                        <li class="span4">--%>
                        <%--                            <div class="thumbnail">--%>
                        <%--                                <a class="zoomTool" href="product_details.jsp" title="add to cart"><span--%>
                        <%--                                        class="icon-search"></span>--%>
                        <%--                                    QUICK VIEW</a>--%>
                        <%--                                <a href="product_details.jsp"><img src="assets/img/a.jpg" alt=""></a>--%>
                        <%--                                <div class="caption cntr">--%>
                        <%--                                    <p>Manicure & Pedicure</p>--%>
                        <%--                                    <p><strong> $22.00</strong></p>--%>
                        <%--                                    <h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>--%>
                        <%--                                    <div class="actionList">--%>
                        <%--                                        <a class="pull-left" href="#">Add to Wish List </a>--%>
                        <%--                                        <a class="pull-left" href="#"> Add to Compare </a>--%>
                        <%--                                    </div>--%>
                        <%--                                    <br class="clr">--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                        </li>--%>
                        <%
                            for (int index = 0; index < 3; index++) {
                                ProductDTOAllProperty proc = products.get(index);
                                if (proc.getProductImageList().size() != 0) {
                                    String pathImg = "";
                                    String procImgName = "";
                                    double procPrice = 0.0D;
                                    for (ProductImage e : proc.getProductImageList()) {
                                        pathImg = e.getPath();
                                        procImgName = e.getAlternative();
                                    }
                                    for (ProductPrice e : proc.getProductPrices()) {
                                        procPrice = e.getPrice();
                                    }
                        %>
                        <li class="span4">
                            <div class="thumbnail">
                                <a class="zoomTool" href="product_details?<%=proc.getProduct_id()%>"
                                   title="add to cart"><span
                                        class="icon-search"></span>
                                    QUICK VIEW</a>
                                <a href="product_details?<%=proc.getProduct_id()%>">
                                    <img src="<%=pathImg%>" alt="<%=procImgName%>">
                                </a>
                                <div class="caption cntr">
                                    <p>Manicure & Pedicure</p>
                                    <p><strong> $<%=procPrice%>
                                    </strong></p>
                                    <h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>
                                    <div class="actionList">
                                        <a class="pull-left" href="#">Add to Wish List </a>
                                        <a class="pull-left" href="#"> Add to Compare </a>
                                    </div>
                                    <br class="clr">
                                </div>
                            </div>
                        </li>
                        <%
                                }
                            }
                        %>
                    </ul>
                </div>
            </div>
            <!--
Featured Products
-->
            <div class="well well-small">
                <h3><a class="btn btn-mini pull-right" href="products.html" title="View more">VIew More<span
                        class="icon-plus"></span></a> Featured Products </h3>
                <hr class="soften"/>
                <div class="row-fluid">
                    <ul class="thumbnails">
<%--                        <li class="span4">--%>
<%--                            <div class="thumbnail">--%>
<%--                                <a class="zoomTool" href="product_details.jsp" title="add to cart"><span--%>
<%--                                        class="icon-search"></span>--%>
<%--                                    QUICK VIEW</a>--%>
<%--                                <a href="product_details.jsp"><img src="assets/img/d.jpg" alt=""></a>--%>
<%--                                <div class="caption">--%>
<%--                                    <h5>Manicure & Pedicure</h5>--%>
<%--                                    <h4>--%>
<%--                                        <a class="defaultBtn" href="product_details.jsp" title="Click to view"><span--%>
<%--                                                class="icon-zoom-in"></span></a>--%>
<%--                                        <a class="shopBtn" href="#" title="add to cart"><span class="icon-plus"></span></a>--%>
<%--                                        <span class="pull-right">$22.00</span>--%>
<%--                                    </h4>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                        <li class="span4">--%>
<%--                            <div class="thumbnail">--%>
<%--                                <a class="zoomTool" href="product_details.jsp" title="add to cart"><span--%>
<%--                                        class="icon-search"></span>--%>
<%--                                    QUICK VIEW</a>--%>
<%--                                <a href="product_details.jsp"><img src="assets/img/e.jpg" alt=""></a>--%>
<%--                                <div class="caption">--%>
<%--                                    <h5>Manicure & Pedicure</h5>--%>
<%--                                    <h4>--%>
<%--                                        <a class="defaultBtn" href="product_details.jsp" title="Click to view"><span--%>
<%--                                                class="icon-zoom-in"></span></a>--%>
<%--                                        <a class="shopBtn" href="#" title="add to cart"><span class="icon-plus"></span></a>--%>
<%--                                        <span class="pull-right">$22.00</span>--%>
<%--                                    </h4>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </li>--%>
<%--                        <li class="span4">--%>
<%--                            <div class="thumbnail">--%>
<%--                                <a class="zoomTool" href="product_details.jsp" title="add to cart"><span--%>
<%--                                        class="icon-search"></span>--%>
<%--                                    QUICK VIEW</a>--%>
<%--                                <a href="product_details.jsp"><img src="assets/img/f.jpg" alt=""/></a>--%>
<%--                                <div class="caption">--%>
<%--                                    <h5>Manicure & Pedicure</h5>--%>
<%--                                    <h4>--%>
<%--                                        <a class="defaultBtn" href="product_details.jsp" title="Click to view"><span--%>
<%--                                                class="icon-zoom-in"></span></a>--%>
<%--                                        <a class="shopBtn" href="#" title="add to cart"><span class="icon-plus"></span></a>--%>
<%--                                        <span class="pull-right">$22.00</span>--%>
<%--                                    </h4>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </li>--%>
                        <%
                            for (ProductDTOAllProperty e : bestProc) {
                                if (e.getProductImageList().size() != 0) {
                                    String pathImg = "";
                                    String procImgName = "";
                                    double procPrice = 0.0D;
                                    for (ProductImage img : e.getProductImageList()) {
                                        pathImg = img.getPath();
                                        procImgName = img.getAlternative();
                                    }
                                    for (ProductPrice price : e.getProductPrices()) {
                                        procPrice = price.getPrice();
                                    }

                        %>
                        <li class="span4">
                            <div class="thumbnail">
                                <a class="zoomTool" href="product_details?id=<%=e.getProduct_id()%>" title="add to cart"><span
                                        class="icon-search"></span>
                                    QUICK VIEW</a>
                                <a  href="product_details?id=<%=e.getProduct_id()%>"><img src="<%=pathImg%>" alt="<%=procImgName%>"></a>
                                <div class="caption">
                                    <h5>Manicure & Pedicure</h5>
                                    <h4>
                                        <a class="defaultBtn" href="product_details?id=<%=e.getProduct_id()%>"  title="Click to view"><span
                                                class="icon-zoom-in"></span></a>
                                        <a class="shopBtn" href="#" title="add to cart"><span class="icon-plus"></span></a>
                                        <span class="pull-right">$<%=procPrice%></span>
                                    </h4>
                                </div>
                            </div>
                        </li>
                        <%
                                }
                            }
                        %>

                    </ul>
                </div>
            </div>

            <div class="well well-small">
                <a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
                Popular Products
            </div>
            <hr>
            <div class="well well-small">
                <a class="btn btn-mini pull-right" href="#">View more <span class="icon-plus"></span></a>
                Best selling Products
            </div>
        </div>
    </div>
    <jsp:include page="template/client-footer.jsp"/>
</div><!-- /container -->

<jsp:include page="template/coppyright.jsp"/>
<!-- Placed at the end of the document so the pages load faster -->

</body>

</html>