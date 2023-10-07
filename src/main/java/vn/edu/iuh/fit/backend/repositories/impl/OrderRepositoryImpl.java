package vn.edu.iuh.fit.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.configs.HibernateUtil;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.CRUDRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements CRUDRepository<Order, Long> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger;

    public OrderRepositoryImpl() {
        entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
        transaction = entityManager.getTransaction();
        logger = LoggerFactory.getLogger(this.getClass());

    }

    @Override
    public Optional<Order> findById(Long id) {
        Order order = entityManager.find(Order.class, id);
        return order == null ? Optional.empty() : Optional.of(order);
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = entityManager.createNamedQuery("order.findAll", Order.class).getResultList();
        return orderList;
    }
    public Order findLastOrderByCusId(Long cusId) {
        String sql="select * from orders where cust_id = ? order by order_id desc limit 1";
        return (Order) entityManager.createNativeQuery(sql, Order.class).setParameter(1, cusId).getSingleResult();
    }
    @Override
    public boolean save(Order entity) {
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
    public boolean update(Order entity) {
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
        Optional<Order> optionalOrder = findById(id);
        if (optionalOrder.isEmpty()) return false;
        Order order = optionalOrder.get();
        try {
            transaction.begin();
            entityManager.remove(order);
//            entityManager.createNativeQuery("delete  from orders where order_id = :id").setParameter("id",id).executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }
    public  Long  statisticalOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate){
        Long result = entityManager.createNamedQuery("order.statisticalOrderDateBetween", Long.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate).getSingleResult();
        return result;
    }

}
