package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/cart/*","/account/*"})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = ((HttpServletResponse) servletResponse);
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        if (checkLogin(servletRequest, servletResponse)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath() + "/login?action=login");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private Boolean checkLogin(ServletRequest request, ServletResponse response) {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        return session != null && session.getAttribute("customerId") != null;
    }
}