package vn.edu.iuh.fit;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.impl.CustomerRepository;
import vn.edu.iuh.fit.backend.repositories.impl.OrderRepositoryImpl;

import java.time.LocalDateTime;
import java.util.Optional;

@ApplicationPath("/api")
public class HelloApplication extends Application {


}