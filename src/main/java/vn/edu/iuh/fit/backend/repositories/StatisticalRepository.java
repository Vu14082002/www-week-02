package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.configs.HibernateUtil;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.impl.ProductRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

public class StatisticalRepository {

    private EntityManager entityManager;
    private ModelMapper modelMapper;

    public StatisticalRepository() {
        entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
        modelMapper = new ModelMapper();
    }

    public List<Object[]> statisticalOrderByDate() {
        String sql = "SELECT DATE(order_date) AS date, COUNT(*) AS amountOrder\n" +
                "FROM orders\n" +
                "GROUP BY DATE(order_date)";
        List<Object[]> objects = entityManager.createNativeQuery(sql, Object[].class).getResultList();
        return objects;
    }

    public Long statisticalOrderByDate(LocalDateTime startTime, LocalDateTime endTime) {
        String sql = "SELECT COUNT(*) AS amountOrder FROM orders where order_date between ? and ?";
        Long result = (Long) entityManager.createNativeQuery(sql, Long.class)
                .setParameter(1, startTime)
                .setParameter(2, endTime)
                .getSingleResult();
        return result;
    }

    public List<Object[]> statisticalOrderByEmpBetween(LocalDateTime startDate, LocalDateTime endDate) {
        String sql = "select count(*) amountOrder from orders " +
                "where order_date between ? and ? group by employee_id";
        List<Object[]> objects = entityManager.createNativeQuery(sql, Object[].class)
                .setParameter(1, startDate).setParameter(2, endDate).getResultList();
        return objects;
    }

    // lấy danh sách
    public Map<Product, Double> topProcBestSales(int top) {

        String sql = "select product_id, sum(quantity) as amount from order_detail group by product_id\n" +
                "having  sum(quantity) >=(\n" +
                "\tselect sum(quantity) as amount from order_detail group by product_id order by amount desc limit 1 offset ?\n" +
                ")\n" +
                "order by amount desc";
        List<Object[]> data = entityManager.createNativeQuery(sql).setParameter(1, top - 1).getResultList();
        Map<Product, Double> maps = new LinkedHashMap<>();
        ProductRepository productRepository = new ProductRepository();
        for (Object[] e : data) {
//            tim product theo id
            Long procId = Long.valueOf(e[0].toString());
            Optional<Product> optionalProduct = productRepository.findById(procId);
//           amount proc by id
            Double amount = Double.valueOf(e[1].toString());
            maps.put(optionalProduct.get(), amount);
        }
        return maps;
    }

    public static void main(String[] args) {
        StatisticalRepository statistical = new StatisticalRepository();
////        pass
//        LocalDateTime startDate = LocalDateTime.of(2023, Month.SEPTEMBER, 30, 0, 0);
//        LocalDateTime endDate = LocalDateTime.of(2023, Month.OCTOBER, 30, 0, 0);
//        List<Object[]> objects = statistical.statisticalOrderByEmpBetween(startDate, endDate);
//        objects.forEach(e -> {
//            System.out.println(e[0] + " : " + e[1]);
//        });
////        pass
//        System.out.println("------------------------------------------");
//        statistical.statisticalOrderByDate().forEach(e -> {
//            LocalDate localDate = LocalDate.parse(e[0].toString());
//            System.out.println(localDate + ": " + e[1]);
//        });
//
////        pass
//        LocalDateTime startTime = LocalDateTime.of(2023, Month.SEPTEMBER, 1, 0, 0);
//        LocalDateTime endTime = LocalDateTime.of(2023, Month.SEPTEMBER, 30, 0, 0);
//        Long l = statistical.statisticalOrderByDate(startTime, endTime);
//        System.out.println(l);
        System.out.println("-------------------------");
        Map<Product, Double> maps = statistical.topProcBestSales(4);
        maps.forEach((k, v) -> {
                    System.out.println(k.getProduct_id() + ": " + v);
                }
        );
    }
}
