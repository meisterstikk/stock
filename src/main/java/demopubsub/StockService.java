package demopubsub;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public void decreaseStock(Long stockId, Integer qty) {

        /**
         * 주문이 발생시, 수량을 줄인다.
         */
        Optional<Stock> stockOptional = stockRepository.findById(stockId);
        Stock stock = stockOptional.get();

        Integer currentQty = stock.getQty();
        
        if(currentQty>=qty){
        
        stock.setQty(currentQty - qty );
        stockRepository.save(stock);    
        }

    }

    public void increaseStock(Long stockId, int qty) {
        /**
         * 주문 취소시, 수량을 늘인다
         */
        Optional<Stock> stockOptional = stockRepository.findById(stockId);
        Stock stock = stockOptional.get();

        Integer currentQty = stock.getQty();
            
        stock.setQty(currentQty + qty );


        stockRepository.save(stock);
    }

    public Stock save(String data){
        ObjectMapper mapper = new ObjectMapper();
        Stock stock = null;
        try {
            stock = mapper.readValue(data, Stock.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockRepository.save(stock);
    }

}
