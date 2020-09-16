package demopubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

 @RestController
 public class StockController {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockService stockService;


    @PutMapping("/stock/decreaseStock/{mouseId}")
    void decreaseStock(@PathVariable(value = "mouseId") Long mouseId, Integer qty) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.stockService.decreaseStock(mouseId, qty);
    }
    
    @PutMapping("/stock/increaseStock/{mouseId}")
    void increaseStock(@PathVariable(value = "mouseId") Long mouseId, Integer qty) {
        this.stockService.increaseStock(mouseId, qty);

 }
}
