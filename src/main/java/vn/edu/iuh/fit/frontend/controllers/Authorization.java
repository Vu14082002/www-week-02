package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/cart/*","/account/*"})
public class Authorization implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = ((HttpServletResponse) servletResponse);
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        if (checkRole(servletRequest, servletResponse)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
    private Boolean checkRole(ServletRequest request, ServletResponse response) {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        String role=session.getAttribute("role").toString();
        return session != null && session.getAttribute("role").toString().equalsIgnoreCase("customer");
    }
}