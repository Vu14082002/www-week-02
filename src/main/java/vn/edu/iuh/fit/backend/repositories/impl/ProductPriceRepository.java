package vn.edu.iuh.fit.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.configs.HibernateUtil;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.models.ProductPrice;
import vn.edu.iuh.fit.backend.repositories.CRUDRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceRepository implements CRUDRepository<ProductPrice, LocalDateTime> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger;

    public ProductPriceRepository() {
        entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
        transaction = entityManager.getTransaction();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public Optional<ProductPrice> findById(LocalDateTime localDateTime) {
        ProductPrice productPrice = entityManager.find(ProductPrice.class, localDateTime);
        return productPrice == null ? Optional.empty() : Optional.of(productPrice);
    }

    @Override
    public List<ProductPrice> findAll() {
        List<ProductPrice> productPrices = entityManager.createNamedQuery("product_price.findAll", ProductPrice.class).getResultList();
        return productPrices;
    }

    @Override
    public boolean save(ProductPrice entity) {
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
    public boolean update(ProductPrice entity) {
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
    public boolean delete(LocalDateTime dateTime) {
        Optional<ProductPrice> productPriceOptional = findById(dateTime);
        if (productPriceOptional.isEmpty()) return false;
        try {
            transaction.begin();
            entityManager.remove(productPriceOptional.get());
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

}