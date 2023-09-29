package vn.edu.iuh.fit.backend.service;

import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.dto.lessProperty.ProductDTO;
import vn.edu.iuh.fit.backend.dto.lessProperty.ProductImageDTO;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.repositories.impl.ProductImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductImageService {
    private ProductImageRepository productImageRepository;
    private ModelMapper modelMapper;

    public ProductImageService() {
        modelMapper = new ModelMapper();
        productImageRepository = new ProductImageRepository();
    }

    public <T> T findById(Long id, Class<T> entityMapper) {
        Optional<ProductImage> optionalProductImage = productImageRepository.findById(id);
        if (optionalProductImage.isEmpty()) {
            return null;
        }
        return modelMapper.map(optionalProductImage.get(), entityMapper);
    }

    public <T> List<T> findAll(Class<T> entityMapperClass) {
        List<T> listMapper = new ArrayList<T>();
        productImageRepository.findAll().forEach(e -> {
            listMapper.add(modelMapper.map(e, entityMapperClass));
        });
        return listMapper;
    }


    public <T> boolean save(T entity) {
        ProductImage productImage = modelMapper.map(entity, ProductImage.class);
        return productImageRepository.save(productImage);
    }

    public <T> boolean update(T entity) {
        ProductImage productImage = modelMapper.map(entity, ProductImage.class);
        return productImageRepository.update(productImage);
    }

    public boolean delete(Long id) {
        return productImageRepository.delete(id);
    }
}
