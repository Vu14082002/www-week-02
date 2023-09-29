//package vn.edu.iuh.fit.frontend.model;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = {"/sale"})
//public class HomeController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action =req.getParameter("action");
//        if(action==null){
//            resp.sendRedirect(req.getContextPath()+"/sale?action=home");
//        }
//        switch (action){
//            case "home":{
//                req.getRequestDispatcher("/index.jsp").forward(req,resp);
//                break;
//            }
//            default:
//                resp.sendRedirect(req.getContextPath()+"/sale?action=home");
//        }
//
//    }
//}
