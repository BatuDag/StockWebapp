package stock_analyzer_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock_analyzer_backend.service.EconomyNewsService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/economy-news")
public class EconomyNewsController {

    @Autowired
    private EconomyNewsService economyNewsService;

    @GetMapping
    public List<Map<String, Object>> getEconomyNews() {
        return economyNewsService.fetchEconomyNews();
    }
}
