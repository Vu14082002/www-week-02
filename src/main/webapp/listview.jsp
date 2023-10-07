<%@ page import="vn.edu.iuh.fit.backend.dto.allProperty.ProductDTOAllProperty" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.models.ProductImage" %>
<%@ page import="vn.edu.iuh.fit.backend.models.ProductPrice" %>
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
        <%

            List<ProductDTOAllProperty> listProc = (List<ProductDTOAllProperty>) session.getAttribute("listProc");
        %>
        <div class="span9">
            <div class="well well-small">
                <%
                    for (ProductDTOAllProperty e : listProc) {
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
                <div class="row-fluid">
                    <div class="span2">
                        <img src="<%=pathImg%>" alt="<%=procImgName%>"/>
                    </div>
                    <div class="span6">
                        <h5><%=e.getName()%>
                        </h5>
                        <p><<%=e.getDescription()%>
                        </p>
                    </div>
                    <div class="span4 alignR">
                        <div class="form-horizontal qtyFrm">
                            <h3>$<%=procPrice%>
                            </h3>
                            <div class="btn-group">
                                <form action="<%=request.getContextPath()%>/cart" method="post">
                                    <input type="hidden" name="amount" value="1">
                                    <input type="hidden" name="id" value="<%=e.getProduct_id()%>">
                                    <input type="submit" value="Add to cart">
<%--                                    <button type="submit" name="id" value="<%=e.getProduct_id()%>" class="shopBtn">--%>
<%--                                        <span class="icon-shopping-cart">--%>
<%--                                            Add to cart--%>
<%--                                        </span>--%>
<%--                                    </button>--%>
                                </form>
                                <a href="<%=request.getContextPath()+"/product-details?id="+e.getProduct_id()%>"
                                   class="shopBtn">VIEW</a>
                            </div>
                        </div>
                    </div>
                </div>
                <hr class="soften">
                <% }
                }%>
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