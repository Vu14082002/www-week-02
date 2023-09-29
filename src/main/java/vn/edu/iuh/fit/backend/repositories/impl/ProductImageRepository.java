package vn.edu.iuh.fit.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.configs.HibernateUtil;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.repositories.CRUDRepository;

import java.util.List;
import java.util.Optional;

public class ProductImageRepository implements CRUDRepository<ProductImage, Long> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger;

    public ProductImageRepository() {
        entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
        transaction = entityManager.getTransaction();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public Optional<ProductImage> findById(Long id) {
        ProductImage productImage = entityManager.find(ProductImage.class, id);
        return productImage == null ? Optional.empty() : Optional.of(productImage);
    }

    @Override
    public List<ProductImage> findAll() {
        List<ProductImage> productImages = entityManager.createNamedQuery("product_image.findAll", ProductImage.class).getResultList();
        return productImages;
    }

    @Override
    public boolean save(ProductImage entity) {
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(ProductImage entity) {
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Optional<ProductImage> productImageOptional = findById(id);
        if (productImageOptional.isEmpty()) return false;
        try {
            transaction.begin();
            entityManager.remove(productImageOptional.get());
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

}