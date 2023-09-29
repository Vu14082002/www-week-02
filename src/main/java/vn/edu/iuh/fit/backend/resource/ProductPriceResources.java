package vn.edu.iuh.fit.backend.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.dto.lessProperty.ProductPriceDTO;
import vn.edu.iuh.fit.backend.service.ProductPriceService;

import java.time.LocalDateTime;
import java.util.List;

@Path("/product-prices")
public class ProductPriceResources {
    @Inject
    private ProductPriceService productPriceService;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") String id) {
        LocalDateTime localDateTime = LocalDateTime.parse(id);
        ProductPriceDTO productPriceDTO = productPriceService.findById(localDateTime, ProductPriceDTO.class);
        if (productPriceDTO != null) {
            return Response.ok(productPriceDTO).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<ProductPriceDTO> priceDTOS = productPriceService.findAll(ProductPriceDTO.class);
        return Response.ok(priceDTOS).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(ProductPriceDTO productPriceDTO) {
        productPriceDTO.setPrice_date_time(LocalDateTime.now());
        boolean updated = productPriceService.save(productPriceDTO);
        if (updated) {
            return Response.ok("ADD SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") String id, ProductPriceDTO productPriceDTO) {
        productPriceDTO.setPrice_date_time(LocalDateTime.parse(id));
        boolean updated = productPriceService.update(productPriceDTO);
        if (updated) {
            return Response.ok("UPDATE SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") String id) {
        boolean updated = productPriceService.delete(LocalDateTime.parse(id));
        if (updated) {
            return Response.ok("DELETE SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
