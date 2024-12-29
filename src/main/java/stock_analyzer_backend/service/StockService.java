package stock_analyzer_backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {

    @Value("${marketstack.api.key}")
    private String apiKey;

    @Value("${marketstack.api.url}")
    private String apiUrl;

    public String getStockData(String symbol) {
        String url = apiUrl + "/eod?access_key=" + apiKey + "&symbols=" + symbol;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
