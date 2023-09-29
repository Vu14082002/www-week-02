package vn.edu.iuh.fit.backend.resource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.dto.lessProperty.ProductDTO;
import vn.edu.iuh.fit.backend.dto.allProperty.ProductDTOAllProperty;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Path("/products")
public class ProductResource {
    private ProductService productService;

    public ProductResource() {
        productService = new ProductService();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
        ProductDTO productDTO = productService.findById(id, ProductDTO.class);
        if (productDTO != null) {
            return Response.ok(productDTO).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<ProductDTO> productDTOAllProperties = productService.findAll(ProductDTO.class);
        return Response.ok(productDTOAllProperties).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(ProductDTO productDTO) {
        productDTO.setProduct_id(0);
        boolean updated = productService.save(productDTO);
        if (updated) {
            return Response.ok("ADD SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id")Long id,ProductDTO productDTO) {
        productDTO.setProduct_id(id);
        boolean updated = productService.update(productDTO);
        if (updated) {
            return Response.ok("UPDATE SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") Long id) {
        boolean updated = productService.delete(id);
        if (updated) {
            return Response.ok("DELETE SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
