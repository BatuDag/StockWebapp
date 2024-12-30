package stock_analyzer_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class EconomyNewsService {

    private final String API_KEY = "42f70aec8b1b3eca59f80254fad9ee92"; // Mediastack API Key
    private final String API_URL = "http://api.mediastack.com/v1/news";

    public List<Map<String, Object>> fetchEconomyNews() {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "?access_key=" + API_KEY + "&categories=business&languages=en";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return (List<Map<String, Object>>) response.get("data");
    }
}
