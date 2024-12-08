package stock_analyzer_backend.controller;

import stock_analyzer_backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/{symbol}")
    public ResponseEntity<?> getStock(@PathVariable String symbol) {
        try {
            // Abruf der Stock-Daten vom Service
            String response = stockService.getStockData(symbol);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Fehlerbehandlung
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fehler beim Abrufen der Daten.");
        }
    }
}
