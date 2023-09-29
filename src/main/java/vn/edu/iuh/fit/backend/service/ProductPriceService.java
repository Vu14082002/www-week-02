package vn.edu.iuh.fit.backend.service;

import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.models.ProductPrice;
import vn.edu.iuh.fit.backend.repositories.impl.ProductImageRepository;
import vn.edu.iuh.fit.backend.repositories.impl.ProductPriceRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductPriceService {
    private ProductPriceRepository productPriceRepository;
    private ModelMapper modelMapper;

    public ProductPriceService() {
        modelMapper = new ModelMapper();
        productPriceRepository = new ProductPriceRepository();
    }

    public <T> T findById(LocalDateTime id, Class<T> entityMapper) {
        Optional<ProductPrice> optionalProductPrice = productPriceRepository.findById(id);
        if (optionalProductPrice.isEmpty()) {
            return null;
        }
        return modelMapper.map(optionalProductPrice.get(), entityMapper);
    }

    public <T> List<T> findAll(Class<T> entityMapperClass) {
        List<T> listMapper = new ArrayList<T>();
        productPriceRepository.findAll().forEach(e -> {
            listMapper.add(modelMapper.map(e, entityMapperClass));
        });
        return listMapper;
    }


    public <T> boolean save(T entity) {
        ProductPrice productPrice = modelMapper.map(entity, ProductPrice.class);
        return productPriceRepository.save(productPrice);
    }

    public <T> boolean update(T entity) {
        ProductPrice productPrice = modelMapper.map(entity, ProductPrice.class);
        return productPriceRepository.update(productPrice);
    }

    public boolean delete(LocalDateTime id) {
        return productPriceRepository.delete(id);
    }
}
