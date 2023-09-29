package vn.edu.iuh.fit.backend.service;

import vn.edu.iuh.fit.backend.repositories.StatisticalRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class StatisticalService {
    private StatisticalRepository statisticalRepository;

    public StatisticalService() {
        statisticalRepository = new StatisticalRepository();
    }

    public List<Object[]> statisticalOrderByEmpBetween(LocalDateTime startDate, LocalDateTime endDate){
       return statisticalRepository.statisticalOrderByEmpBetween(startDate, endDate);
    }
}
