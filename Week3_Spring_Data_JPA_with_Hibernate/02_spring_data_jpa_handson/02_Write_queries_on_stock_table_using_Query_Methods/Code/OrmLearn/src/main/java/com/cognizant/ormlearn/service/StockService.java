package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService( @Autowired StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllCodeStocksOnDateBetween(String code, LocalDate startDate, LocalDate endDate) {
        return stockRepository.findByCodeAndDateBetween(code, startDate, endDate);
    }

    public List<Stock> getAllCodeStocksHigherThanClose(String code, BigDecimal close) {
        return stockRepository.findByCodeAndCloseGreaterThan(code, close);
    }

    public List<Stock> getTop3Stocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    public List<Stock> getTop3StocksByCode(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
}
