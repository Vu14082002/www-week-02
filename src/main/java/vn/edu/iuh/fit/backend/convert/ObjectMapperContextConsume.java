//package vn.edu.iuh.fit.backend.convert;
//
//import com.fasterxml.jackson.databind.Module;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import jakarta.ws.rs.Consumes;
//import jakarta.ws.rs.ext.ContextResolver;
//import jakarta.ws.rs.ext.Provider;
//
//import java.time.LocalDateTime;
//
//@Consumes
//public class ObjectMapperContextConsume implements ContextResolver<ObjectMapper> {
//    final ObjectMapper mapper = new ObjectMapper();
//
//    public ObjectMapperContextConsume() {
//        mapper.registerModule(LocalDateTime.);
//    }
//
//    @Override
//    public ObjectMapper getContext(Class<?> type) {
//        return mapper;
//    }
//}
