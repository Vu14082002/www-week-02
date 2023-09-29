package vn.edu.iuh.fit.backend.service;


import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.dto.lessProperty.EmployeeDTO;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.impl.EmployeeRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepositoryImpl employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeService() {
        employeeRepository = new EmployeeRepositoryImpl();
        modelMapper=new ModelMapper();
    }

    public <T> T  findById(Long id, Class<T> entityMapperClass) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.map(employee -> modelMapper.map(employee, entityMapperClass)).orElse(null);
    }
    public <T> List<T> findAll(Class<T> entityMapperClass){
        List<T> entityMappers = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        employees.forEach(e->{
            entityMappers.add(modelMapper.map(e, entityMapperClass));
        });
        return entityMappers;
    }

    public <T> boolean save(T entity) {
        Employee employee = modelMapper.map(entity, Employee.class);
        return employeeRepository.save(employee);
    }

    public <T> boolean update(T entity ) {
        Employee employee = modelMapper.map(entity, Employee.class);
        return employeeRepository.update(employee);
    }

    public boolean delete(Long id) {
        return employeeRepository.delete(id);
    }

}
