package vn.edu.iuh.fit.backend.service;

import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.StatisticalRepository;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StatisticalService {
    private StatisticalRepository statisticalRepository;
    private ModelMapper modelMapper;

    public StatisticalService() {
        statisticalRepository = new StatisticalRepository();
        modelMapper = new ModelMapper();
    }

    public List<Object[]> statisticalOrderByEmpBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return statisticalRepository.statisticalOrderByEmpBetween(startDate, endDate);
    }

    public Map<Product, Double> topProcBestSales(int top) {
        return statisticalRepository.topProcBestSales(top);
    }

    public <T> List<T> topProcBestSales(int top, Class<T> entityMapper) {
        Map<Product, Double> maps = statisticalRepository.topProcBestSales(top);
        List<T> data = new ArrayList<>();
        maps.forEach((k, v) -> {
            data.add(modelMapper.map(k, entityMapper));
        });
        return data;
    }
}
