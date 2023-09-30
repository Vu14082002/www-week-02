package vn.edu.iuh.fit.backend.service;

import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.dto.lessProperty.ProductDTO;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.impl.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;


    public ProductService() {
        productRepository = new ProductRepository();
        modelMapper = new ModelMapper();
    }

    public <T> T findById(Long id, Class<T> entityMapperClass) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) return null;
        return modelMapper.map(optionalProduct.get(), entityMapperClass);
    }

    public <T> List<T> findAll(Class<T> entityMapperClass) {
        List<T> listMapper = new ArrayList<T>();
        productRepository.findAll().forEach(e -> {
            listMapper.add(modelMapper.map(e, entityMapperClass));
        });
        return listMapper;
    }


    public <T> boolean save(T entity) {
        Product product = modelMapper.map(entity, Product.class);
        return productRepository.save(product);
    }

    public <T> boolean update(T entity) {
        Product product = modelMapper.map(entity, Product.class);
        return productRepository.update(product);
    }

    public boolean delete(Long id) {
        return productRepository.delete(id);
    }

    public <T> List<T> findTopProcNew(int amount, Class<T> entityMapperClass) {
        List<T> listMapper = new ArrayList<T>();
        productRepository.findTopNewProc(amount).forEach(e -> {
            listMapper.add(modelMapper.map(e, entityMapperClass));
        });
        return listMapper;
    }
}
