package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.StockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	static Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void testStockMethods(ApplicationContext context) {
		LOGGER.info("Start.....");

		StockService service = context.getBean(StockService.class);

		List<Stock> stocks = service.getAllCodeStocksOnDateBetween("FP", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
		LOGGER.debug("Calling getAllCodeStocksOnDateBetween : \n{}", stocks);

		stocks = service.getAllCodeStocksHigherThanClose("GOOGL", new BigDecimal(1250));
		LOGGER.debug("Calling getAllCodeStocksHigherThanClose : \n{}", stocks);

		stocks = service.getTop3Stocks();
		LOGGER.debug("Calling getTop3Stocks : \n{}", stocks);

		stocks = service.getTop3StocksByCode("NFLX");
		LOGGER.debug("Calling getTop3StocksByCode : \n{}", stocks);

		LOGGER.info("End.....");
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		testStockMethods(context);
	}
}
