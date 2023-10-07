package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.dto.allProperty.ProductDTOAllProperty;
import vn.edu.iuh.fit.backend.dto.lessProperty.ProductDTO;
import vn.edu.iuh.fit.backend.service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListProductController extends HttpServlet {
    private static  String LIST_PRODUCT_VIEW="listview.jsp";
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService= new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTOAllProperty> listProcs = productService.findAll(ProductDTOAllProperty.class);
        req.getSession().setAttribute("uriReq",req.getRequestURI()+"?"+req.getQueryString());
        req.getSession().setAttribute("listProc",listProcs);
        req.getRequestDispatcher(LIST_PRODUCT_VIEW).forward(req,resp);
    }
}
