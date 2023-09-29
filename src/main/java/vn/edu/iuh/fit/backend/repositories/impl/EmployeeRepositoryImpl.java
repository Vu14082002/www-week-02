package vn.edu.iuh.fit.backend.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.configs.HibernateUtil;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.CRUDRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements CRUDRepository<Employee, Long> {
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private final Logger logger;

    public EmployeeRepositoryImpl() {
        entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
        transaction = entityManager.getTransaction();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee == null ? Optional.empty() : Optional.of(employee);
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createNamedQuery("employee.findAll", Employee.class).getResultList();
    }


    @Override
    public boolean save(Employee entity) {
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Employee entity) {
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        return setStatus(id, EmployeeStatus.TERMINATED);
    }


    public boolean setStatus(Long id, EmployeeStatus status) {
        Optional<Employee> optionalEmployee = findById(id);
        if (optionalEmployee.isEmpty()) return false;
        try {
            transaction.begin();
//            Employee employee = entityManager.createNamedQuery("employee.findById", Employee.class).setParameter("id", id).getSingleResult();
            Employee employee = optionalEmployee.get();
            employee.setStatus(status);
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            transaction.rollback();
            return false;
        }
    }



}
