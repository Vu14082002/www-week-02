package vn.edu.iuh.fit.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.configs.HibernateUtil;
import vn.edu.iuh.fit.backend.enums.ProductStatus;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.CRUDRepository;

import java.util.List;
import java.util.Optional;

public class ProductRepository implements CRUDRepository<Product, Long> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger;

    public ProductRepository() {
        entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
        transaction = entityManager.getTransaction();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = entityManager.find(Product.class, id);
        return product == null ? Optional.empty() : Optional.of(product);
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = entityManager.createNamedQuery("product.findAll", Product.class).getResultList();
        return products;
    }
    public List<Product> findTopNewProc(int amount) {
        List<Product> products = entityManager.createNamedQuery("product.findTopProcNew", Product.class).setMaxResults(amount).getResultList();
        return products;
    }
    @Override
    public boolean save(Product entity) {
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
    public boolean update(Product entity) {
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
        Optional<Product> optionalProduct = findById(id);
        if(optionalProduct.isEmpty()) return false;
        optionalProduct.get().setStatus(ProductStatus.TERMINATED);
        return update(optionalProduct.get());
    }
    

}