package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.dto.allProperty.ProductDTOAllProperty;
import vn.edu.iuh.fit.backend.dto.lessProperty.CustomerDTO;
import vn.edu.iuh.fit.backend.dto.lessProperty.OrderDTO;
import vn.edu.iuh.fit.backend.dto.lessProperty.OrderDetailDTO;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.impl.OrderDetailRepositoryImpl;
import vn.edu.iuh.fit.backend.repositories.impl.OrderRepositoryImpl;
import vn.edu.iuh.fit.backend.repositories.impl.ProductRepository;
import vn.edu.iuh.fit.backend.service.CustomerService;
import vn.edu.iuh.fit.backend.service.OrderDetailService;
import vn.edu.iuh.fit.backend.service.OrderService;
import vn.edu.iuh.fit.backend.service.ProductService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private static Map<ProductDTOAllProperty, Integer> cart;
    private final String CART_PAGE = "cart.jsp";
    private ProductService productService;
    private OrderService orderService;
    private CustomerService customerService;
    private OrderDetailService orderDetailService;
    private OrderDetailRepositoryImpl orderDetailRepository;
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        cart = new LinkedHashMap<>();
        productService = new ProductService();
        customerService = new CustomerService();
        orderService = new OrderService();
        orderDetailService = new OrderDetailService();
        orderDetailRepository = new OrderDetailRepositoryImpl();
        productRepository= new ProductRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(cart==null){
            cart = new LinkedHashMap<>();
            req.getSession().setAttribute("cart",cart);
        }
        req.getRequestDispatcher(CART_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDelete = req.getParameter("idDelete");
        String order = req.getParameter("order");
        if (idDelete != null) {
            Iterator<Map.Entry<ProductDTOAllProperty, Integer>> iterator = cart.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<ProductDTOAllProperty, Integer> next = iterator.next();
                if (next.getKey().getProduct_id() == Long.parseLong(idDelete)) {
                    iterator.remove();
                }

            }
            req.getSession().setAttribute("cart", cart);
            resp.sendRedirect(req.getContextPath() + "/cart");
        } else if (order != null) {
            Map<String, String[]> map = req.getParameterMap();
            Long cusid = Long.parseLong(req.getSession().getAttribute("customerId").toString());
            OrderDTO orderDTO = new OrderDTO(0, LocalDateTime.now(), cusid, "cussname", 1L, "employname");
            boolean saveOrderDto = orderService.save(orderDTO);
            for (String idProcSt : map.keySet()) {
                if (idProcSt.equalsIgnoreCase("order")) break;
                long idProc = Long.parseLong(idProcSt);
                double quantity = Double.parseDouble(map.get(idProcSt)[0]);
                Product proc = productRepository.findById(idProc).get();
                double price = proc.getProductPrices().get(proc.getProductPrices().size() - 1).getPrice();
                Order lastOrderByCusId = orderService.findLastOrderByCusId(cusid, Order.class);
                OrderDetail orderDetail = new OrderDetail(lastOrderByCusId, proc, quantity, price, "humm");
                boolean saved = orderDetailRepository.save(orderDetail);
            }
            cart.clear();
        } else {
            boolean flag = false;
            Long id = Long.parseLong(req.getParameter("id"));
            Integer amount = Integer.parseInt(req.getParameter("amount"));
            for (Map.Entry<ProductDTOAllProperty, Integer> e : cart.entrySet()) {
                if (e.getKey().getProduct_id() == id) {
                    Integer newValue = e.getValue() + amount;
                    e.setValue(newValue);
                    flag = true;
                }
            }
            if (!flag) {
                ProductDTOAllProperty proc = productService.findById(id, ProductDTOAllProperty.class);
                cart.put(proc, amount);
            }
        }
        req.getSession().setAttribute("cart", cart);
        resp.sendRedirect(req.getContextPath() + "/home");
    }

}
