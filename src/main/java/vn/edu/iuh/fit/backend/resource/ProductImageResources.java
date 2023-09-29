package vn.edu.iuh.fit.backend.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.dto.lessProperty.ProductDTO;
import vn.edu.iuh.fit.backend.dto.lessProperty.ProductImageDTO;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.service.ProductImageService;

import java.util.List;

@Path("/product-images")
public class ProductImageResources {
    @Inject
    private ProductImageService productImageService;
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
        ProductImageDTO productImageDTO = productImageService.findById(id, ProductImageDTO.class);
        if (productImageDTO != null) {
            return Response.ok(productImageDTO).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<ProductImageDTO> imageDTOS = productImageService.findAll(ProductImageDTO.class);
        return Response.ok(imageDTOS).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(ProductImageDTO imageDTO) {
        imageDTO.setImage_id(0);
        boolean updated = productImageService.save(imageDTO);
        if (updated) {
            return Response.ok("ADD SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id")Long id,ProductImageDTO imageDTO) {
        imageDTO.setImage_id(id);
        boolean updated = productImageService.update(imageDTO);
        if (updated) {
            return Response.ok("UPDATE SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") Long id) {
        boolean updated = productImageService.delete(id);
        if (updated) {
            return Response.ok("DELETE SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
