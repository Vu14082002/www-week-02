package vn.edu.iuh.fit.backend.service;

import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.repositories.impl.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    public CustomerService() {
        customerRepository =new CustomerRepository();
        modelMapper = new ModelMapper();
    }


    public <T>  T findById(Long id, Class<T> entityMapperClass) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) return null;
        Customer customer = optionalCustomer.get();
        return modelMapper.map(customer,entityMapperClass);
    }
    public <T>  T findByEmail(String email, Class<T> entityMapperClass) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isEmpty()) return null;
        Customer customer = optionalCustomer.get();
        return modelMapper.map(customer,entityMapperClass);
    }

    public <T> List<T> findAll(Class<T> entityMapperClass) {
        List<T> entityMappers = new ArrayList<>();
        customerRepository.findAll().forEach(e -> {
            entityMappers.add(modelMapper.map(e, entityMapperClass));
        });
        return entityMappers;
    }

    public <T> boolean save(T entity) {
        Customer customer = modelMapper.map(entity, Customer.class);
        return customerRepository.save(customer);
    }

    public <T> boolean update(T entity) {
        Customer customer = modelMapper.map(entity, Customer.class);
        return customerRepository.update(customer);
    }

    public boolean delete(Long id) {
        return customerRepository.delete(id);
    }

}
