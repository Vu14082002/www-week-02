package vn.edu.iuh.fit.backend.service;

import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.dto.lessProperty.OrderDetailDTO;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.models.OrderDetailCompositeId;
import vn.edu.iuh.fit.backend.repositories.impl.OrderDetailRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDetailService {
    private OrderDetailRepositoryImpl orderDetailRepository;
    private OrderService orderService;
    private ProductService productService;
    private ModelMapper modelMapper;

    public OrderDetailService() {
        this.orderDetailRepository = new OrderDetailRepositoryImpl();
        orderService=new OrderService();
        productService= new ProductService();
        modelMapper = new ModelMapper();

    }

    public OrderDetailDTO findById(OrderDetailCompositeId id) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
        if (optionalOrderDetail.isEmpty()) return null;
        OrderDetailDTO orderDetailDTO = modelMapper.map(optionalOrderDetail.get(), OrderDetailDTO.class);
        return orderDetailDTO;
    }

    public List<OrderDetailDTO> findAll() {
        List<OrderDetail> repositoryAll = orderDetailRepository.findAll();
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        repositoryAll.forEach(e -> {
            orderDetailDTOList.add(modelMapper.map(e, OrderDetailDTO.class));
        });
        return orderDetailDTOList;
    }

    public boolean save(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = modelMapper.map(orderDetailDTO, OrderDetail.class);
        return orderDetailRepository.save(orderDetail);
    }

    public boolean update(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = modelMapper.map(orderDetailDTO, OrderDetail.class);
        return orderDetailRepository.update(orderDetail);
    }

    public boolean delete(OrderDetailCompositeId id) {
        return orderDetailRepository.delete(id);
    }
}
