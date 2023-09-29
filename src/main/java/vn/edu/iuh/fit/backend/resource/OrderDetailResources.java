package vn.edu.iuh.fit.backend.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.dto.lessProperty.OrderDetailDTO;
import vn.edu.iuh.fit.backend.models.OrderDetailCompositeId;
import vn.edu.iuh.fit.backend.service.OrderDetailService;

import java.util.List;

@Path("/order-details")
public class OrderDetailResources {
    @Inject
    private OrderDetailService orderDetailService;
    @GET
    @Path("/{orderId}/{procId}")
    @Produces("application/json")
    public Response findById(@PathParam("orderId") Long orderId, @PathParam("procId") Long procId) {
        OrderDetailDTO orderDetailDTO = orderDetailService.findById(new OrderDetailCompositeId(orderId, procId));
        if (orderDetailDTO != null) {
            return Response.ok(orderDetailDTO).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        List<OrderDetailDTO> orderDetailServiceAll = orderDetailService.findAll();
        return Response.ok(orderDetailServiceAll).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response save(OrderDetailDTO orderDetailDTO) {
        boolean save = orderDetailService.save(orderDetailDTO);
        if (save) {
            return Response.ok("Add success").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    //    http://localhost:8080/api/order-details/{id}/{id}
    @PUT
    @Path("/{orderId}/{procId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("orderId") Long orderId,@PathParam("procId") Long procId ,OrderDetailDTO orderDetailDTO) {
        boolean save = orderDetailService.update(orderDetailDTO);
        if (save) {
            return Response.ok("Update success orderDetail orderId: " + orderId+" procId: "+procId).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    //    http://localhost:8080/api/order-details/{id}/{id}
    @DELETE
    @Path("/{orderId}/{procId}")
    @Produces("application/json")
    public Response delete(@PathParam("orderId") Long orderId,@PathParam("procId") Long procId) {
        boolean save = orderDetailService.delete(new OrderDetailCompositeId(orderId,procId));
        if (save) {
            return Response.ok("Delete success orderDetail orderId: " + orderId+" procId: "+procId).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
