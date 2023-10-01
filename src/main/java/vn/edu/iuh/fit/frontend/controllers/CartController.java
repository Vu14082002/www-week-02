package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.dto.allProperty.ProductDTOAllProperty;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.service.ProductService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private static Map<ProductDTOAllProperty, Integer> cart;
    private  final String CART_PAGE="cart.jsp";
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        cart = new LinkedHashMap<>();
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        cart = (Map<ProductDTOAllProperty, Integer>) req.getSession().getAttribute("cart");
        req.getRequestDispatcher(CART_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        ProductDTOAllProperty proc = productService.findById(id, ProductDTOAllProperty.class);
        cart.put(proc, amount);
        req.getSession().setAttribute("cart", cart);
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
