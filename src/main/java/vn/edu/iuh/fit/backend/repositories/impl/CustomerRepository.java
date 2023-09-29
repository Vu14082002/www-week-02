package vn.edu.iuh.fit.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.configs.HibernateUtil;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.repositories.CRUDRepository;

import java.util.List;
import java.util.Optional;

public class CustomerRepository implements CRUDRepository<Customer, Long> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger;

    public CustomerRepository() {
        entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
        transaction = entityManager.getTransaction();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public Optional<Customer> findById(Long id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer == null ? Optional.empty() : Optional.of(customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = entityManager.createNamedQuery("customer.findAll", Customer.class).getResultList();
        return customers;
    }

    @Override
    public boolean save(Customer entity) {
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
    public boolean update(Customer entity) {
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
        Optional<Customer> optionalCustomer = findById(id);
        if (optionalCustomer.isEmpty()) return false;
        try {
            transaction.begin();
            entityManager.remove(optionalCustomer.get());
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

}