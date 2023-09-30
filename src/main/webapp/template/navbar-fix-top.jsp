<%@ page import="vn.edu.iuh.fit.backend.dto.allProperty.ProductDTOAllProperty" %>
<%@ page import="java.util.Map" %>
<%@ page import="vn.edu.iuh.fit.backend.models.ProductPrice" %>
<%@ page import="java.util.List" %><%
    Map<ProductDTOAllProperty, Integer> cart = (Map<ProductDTOAllProperty, Integer>) session.getAttribute("cart");
    int amount = 0;
    double total = 0.0;
    if (cart != null) { // Check if the cart is not null
        amount = cart.size();
        for (Map.Entry<ProductDTOAllProperty, Integer> entry : cart.entrySet()) {
            ProductDTOAllProperty product = entry.getKey();
            int quantity = entry.getValue();
            List<ProductPrice> prices = product.getProductPrices();
            if (!prices.isEmpty()) {
                ProductPrice lastPrice = prices.get(prices.size() - 1);
                double price = lastPrice.getPrice();
                total += price * quantity;
            }
        }
    }
%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="topNav">
        <div class="container">
            <div class="alignR">
                <div class="pull-left socialNw">
                    <a href="#"><span class="icon-twitter"></span></a>
                    <a href="#"><span class="icon-facebook"></span></a>
                    <a href="#"><span class="icon-youtube"></span></a>
                    <a href="#"><span class="icon-tumblr"></span></a>
                </div>
                <a class="active" href="<%=request.getContextPath()+"/home"%>"> <span class="icon-home"></span> Home</a>
                <a href="<%=request.getContextPath()+"/account"%>"><span class="icon-user"></span> My Account</a>
                <a href="<%=request.getContextPath()+"/register"%>"><span class="icon-edit"></span> Free Register </a>
                <a href="<%=request.getContextPath()+"/cart"%>"><span class="icon-shopping-cart"></span> <%=amount%> Item(s) - <span class="badge badge-warning">
							$<%=String.format("%.2f",total)%></span></a>
            </div>
        </div>
    </div>
</div>