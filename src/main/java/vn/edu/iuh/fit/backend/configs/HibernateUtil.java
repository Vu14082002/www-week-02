package vn.edu.iuh.fit.backend.configs;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;

public class HibernateUtil {
    private static HibernateUtil instance;
    private EntityManagerFactory factory;

    public HibernateUtil() {
        factory =Persistence.createEntityManagerFactory("week02_lab_NguyenVanVu_20002865");
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }
}
