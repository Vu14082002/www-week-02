package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.dto.lessProperty.CustomerDTO;
import vn.edu.iuh.fit.backend.service.CustomerService;

import java.io.IOException;

@WebServlet("/login")
public class LoginController  extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action =req.getParameter("action");
    switch (action){
        case "loginsubmit":{
            String email = req.getParameter("username");
            CustomerDTO customerDTO = customerService.findByEmail(email, CustomerDTO.class);
            if(email.equals(customerDTO.getEmail())){
                req.getSession().setAttribute("customerId",customerDTO.getId());
                req.getSession().setAttribute("role","customer");
                String uriReq = req.getSession().getAttribute("uriReq").toString();
                if(!uriReq.equalsIgnoreCase("no-req")){
                    resp.sendRedirect(uriReq);
                }else{
                    resp.sendRedirect(req.getContextPath()+"/home");
                }
            }else{
                req.getSession().setAttribute("status","email or password wrong");
                resp.sendRedirect(req.getContextPath()+"/login");
            }
        }
    }
    }
}
