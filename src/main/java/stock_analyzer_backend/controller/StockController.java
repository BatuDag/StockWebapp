package stock_analyzer_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock_analyzer_backend.service.StockService;

import java.util.Map;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/popular")
    public ResponseEntity<Map<String, Double>> getPopularStocks() {
        Map<String, Double> popularStocks = stockService.getPopularStocks();
        return ResponseEntity.ok(popularStocks);
    }
}
