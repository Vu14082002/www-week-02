package vn.edu.iuh.fit.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.configs.HibernateUtil;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.models.OrderDetailCompositeId;
import vn.edu.iuh.fit.backend.repositories.CRUDRepository;

import java.util.List;
import java.util.Optional;

public class OrderDetailRepositoryImpl implements CRUDRepository<OrderDetail, OrderDetailCompositeId> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger;

    public OrderDetailRepositoryImpl() {
        entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
        transaction = entityManager.getTransaction();
        logger = LoggerFactory.getLogger(this.getClass());

    }

    @Override
    public Optional<OrderDetail> findById(OrderDetailCompositeId id) {

        OrderDetail orderDetail = entityManager.createNamedQuery("order_detail.findById", OrderDetail.class).setParameter("orderID", id.getOrder()).setParameter("procId", id.getProduct()).getSingleResult();
        return orderDetail == null ? Optional.empty() : Optional.of(orderDetail);
    }

    @Override
    public List<OrderDetail> findAll() {
        List<OrderDetail> orderDetailList = entityManager.createNamedQuery("order_detail.findAll", OrderDetail.class).getResultList();
        return orderDetailList;
    }

    @Override
    public boolean save(OrderDetail entity) {
        String sql = "INSERT INTO `order_detail` (`price`, `quantity`, `order_id`, `product_id`, `note`) VALUES (?, ?, ?, ?, ?);";
        try {
            transaction.begin();
//            entityManager.persist(entity);
            double price = entity.getProduct().getProductPrices().get(entity.getProduct().getProductPrices().size() - 1).getPrice();
            entityManager.createNativeQuery(sql)
                    .setParameter(1, price)
                    .setParameter(2, entity.getQuantity())
                    .setParameter(3, entity.getOrder().getId())
                    .setParameter(4, entity.getProduct().getProduct_id())
                    .setParameter(5, entity.getNote()).executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(OrderDetail entity) {
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
    public boolean delete(OrderDetailCompositeId id) {
        Optional<OrderDetail> orderDetailList = findById(id);
        if (orderDetailList.isEmpty()) return false;
        try {
            transaction.begin();
            entityManager.remove(orderDetailList.get());
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

}
