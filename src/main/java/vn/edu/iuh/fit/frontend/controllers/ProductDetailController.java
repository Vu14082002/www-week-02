package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jboss.weld.context.http.Http;
import vn.edu.iuh.fit.backend.service.ProductService;

import java.io.IOException;

@WebServlet("/product-details")
public class ProductDetailController extends HttpServlet {
    private static final String PRODUCT_DETAIL_PAGE="product_details.jsp";
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService= new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(PRODUCT_DETAIL_PAGE).forward(req,resp);
    }
}
