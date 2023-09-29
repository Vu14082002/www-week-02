package vn.edu.iuh.fit.backend.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.dto.lessProperty.EmployeeDTO;
import vn.edu.iuh.fit.backend.service.EmployeeService;

import java.util.List;

@Path("/employees")
public class EmployeeResources {
    @Inject
    private EmployeeService employeeService;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
        EmployeeDTO employeeDTO = employeeService.findById(id, EmployeeDTO.class);
        if (employeeDTO != null) {
            return Response.ok(employeeDTO).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<EmployeeDTO> employeeDTOs = employeeService.findAll(EmployeeDTO.class);
        return Response.ok(employeeDTOs).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response save(EmployeeDTO employeeDTO) {
        employeeDTO.setId(0);
        boolean save = employeeService.save(employeeDTO);
        if (save) {
            return Response.ok("Add success").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") long id, EmployeeDTO employeeDTO) {
        employeeDTO.setId(id);
        boolean save = employeeService.update(employeeDTO);
        if (save) {
            return Response.ok("Update success employee id: "+id).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        boolean save = employeeService.delete(id);
        if (save) {
            return Response.ok("delete success employee id: "+id).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
