package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.configs.HibernateUtil;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class StatisticalRepository {

    private EntityManager entityManager;
    private ModelMapper modelMapper;

    public StatisticalRepository() {
         entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
         modelMapper = new ModelMapper();
    }

    public List<Object[]>  statisticalOrderByEmpBetween(LocalDateTime startDate, LocalDateTime endDate){
       String sql ="select employee_id, count(*) amount from orders " +
               "where order_date between ? and ? group by employee_id";
        List<Object[]> objects = entityManager.createNativeQuery(sql, Object[].class)
                .setParameter(1, startDate).setParameter(2, endDate).getResultList();
        return objects;
    }

    public static void main(String[] args) {
        StatisticalRepository statistical = new StatisticalRepository();
        LocalDateTime startDate = LocalDateTime.of(2023,Month.SEPTEMBER,30,0,0);
        LocalDateTime endDate = LocalDateTime.of(2023,Month.OCTOBER,30,0,0);
        List<Object[]> objects = statistical.statisticalOrderByEmpBetween(startDate, endDate);
        objects.forEach(e->{
            System.out.println(e[0]+" : "+ e[1]);
        });
    }
}
