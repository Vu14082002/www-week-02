package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.dto.allProperty.ProductDTOAllProperty;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.service.ProductService;
import vn.edu.iuh.fit.backend.service.StatisticalService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    private static String HOME_PAGE="index.jsp";
    private ProductService productService;
    private StatisticalService statisticalService;
    @Override
    public void init() throws ServletException {
        productService = new ProductService();
        statisticalService = new StatisticalService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTOAllProperty> products = productService.findTopProcNew(12,ProductDTOAllProperty.class);
        List<ProductDTOAllProperty> bestProc = statisticalService.topProcBestSales(4, ProductDTOAllProperty.class);
        req.setAttribute("products",products);
        req.setAttribute("bestProc",bestProc);
        req.getRequestDispatcher(HOME_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
