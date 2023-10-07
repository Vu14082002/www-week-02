package vn.edu.iuh.fit.backend.service;

import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.dto.lessProperty.OrderDTO;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.impl.OrderRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {
    private OrderRepositoryImpl orderRepository;
    private ModelMapper modelMapper;

    public OrderService() {
        this.orderRepository = new OrderRepositoryImpl();
        modelMapper = new ModelMapper();

    }

    public <T> T findById(Long id,Class<T> entityMapperClass) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.map(order -> modelMapper.map(order, entityMapperClass)).orElse(null);

    }

    public <T> List<T> findAll(Class<T> entityMapperClass) {
        List<Order> orderList = orderRepository.findAll();
        List<T> entityMappers = new ArrayList<>();
        orderList.forEach(e -> {
            entityMappers.add(modelMapper.map(e, entityMapperClass));
        });
        return entityMappers;
    }
    public <T> T findLastOrderByCusId(Long id,Class<T> entityMapperClass) {
        Order order = orderRepository.findLastOrderByCusId(id);
        return modelMapper.map(order,entityMapperClass);

    }

    public <T> boolean save(T entity) {
        Order order = modelMapper.map(entity, Order.class);
        return orderRepository.save(order);
    }

    public <T> boolean update(T entity) {
        Order order = modelMapper.map(entity, Order.class);
        return orderRepository.update(order);
    }

    public boolean delete(Long id) {
        return orderRepository.delete(id);
    }
}
