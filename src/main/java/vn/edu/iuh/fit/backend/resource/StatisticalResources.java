package vn.edu.iuh.fit.backend.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.service.StatisticalService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Path("/statistics")
public class StatisticalResources {
    @Inject
    private StatisticalService statisticalService;

    @GET
    @Produces("application/json")
    public Response statisticalOrderByEmpBetween(){
        LocalDateTime startDate = LocalDateTime.of(2023, Month.SEPTEMBER,30,0,0);
        LocalDateTime endDate = LocalDateTime.of(2023,Month.OCTOBER,30,0,0);
        List<Object[]> objects = statisticalService.statisticalOrderByEmpBetween(startDate, endDate);
        return Response.ok(objects).build();
    }
}
