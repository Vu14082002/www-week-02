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
import java.util.List;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    private static String HOME_PAGE="index.jsp";
    private ProductService productService;
    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTOAllProperty> products = productService.findTopProcNew(12,ProductDTOAllProperty.class);
        req.getSession().setAttribute("products",products);
        req.getRequestDispatcher(HOME_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
