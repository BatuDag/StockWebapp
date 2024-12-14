package stock_analyzer_backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockService {

    @Value("${marketstack.api.key}")
    private String apiKey;

    @Value("${marketstack.api.url}")
    private String apiUrl;

    public Map<String, Double> getPopularStocks() {
        List<String> popularSymbols = List.of("AAPL", "MSFT", "GOOGL");
        Map<String, Double> stockValues = new HashMap<>();

        RestTemplate restTemplate = new RestTemplate();
        for (String symbol : popularSymbols) {
            String url = apiUrl + "/eod?access_key=" + apiKey + "&symbols=" + symbol;
            try {
                Map response = restTemplate.getForObject(url, Map.class);
                List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
                if (data != null && !data.isEmpty()) {
                    Double closePrice = (Double) data.get(0).get("close");
                    stockValues.put(symbol, closePrice);
                }
            } catch (Exception e) {
                System.err.println("Fehler beim Abrufen der Daten für " + symbol + ": " + e.getMessage());
            }
        }
        return stockValues;
    }
}
