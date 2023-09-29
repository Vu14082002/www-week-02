package vn.edu.iuh.fit.backend.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.dto.lessProperty.CustomerDTO;
import vn.edu.iuh.fit.backend.dto.lessProperty.EmployeeDTO;
import vn.edu.iuh.fit.backend.service.CustomerService;

import java.util.List;

@Path("/customers")
public class CustomerResources {
    @Inject
    private CustomerService customerService;
    //    http://localhost:8080/api/customers/1
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
        CustomerDTO customerDTO = customerService.findById(id, CustomerDTO.class);
        if (customerDTO != null) {
            return Response.ok(customerDTO).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    //    http://localhost:8080/api/customers
    @GET
    @Produces("application/json")
    public Response getAll() {
        List<CustomerDTO> customerDTOList = customerService.findAll(CustomerDTO.class);
        return Response.ok(customerDTOList).build();
    }
//    http://localhost:8080/api/customers
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response save(CustomerDTO customerDTO) {
        customerDTO.setId(0);
        boolean save = customerService.save(customerDTO);
        if (save) {
            return Response.ok("Add success").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
//    http://localhost:8080/api/customers/{id}
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") Long id, CustomerDTO customerDTO) {
        customerDTO.setId(id);
//       con loi khi xoa cus da co order
        boolean save = customerService.update(customerDTO);
        if (save) {
            return Response.ok("Update success customer id: "+id).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
//    http://localhost:8080/api/customers/{id}
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") Long id) {
        boolean save = customerService.delete(id);
        if (save) {
            return Response.ok("delete success customer id: "+id).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
