package demopubsub;
import demopubsub.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class StockApplication {
    protected static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(StockApplication.class, args);


        
        //최초 마우스 설정 1:무선 20개, 2:유선 50개
        StockRepository stockRepository = applicationContext.getBean(StockRepository.class);

        Stock stock = new Stock();
        stock.setMouseName("WIRELESS");
        stock.setQty(20);
        stockRepository.save(stock);

        Stock stock2 = new Stock();
        stock2.setMouseName("COMMON");
        stock2.setQty(50);
        stockRepository.save(stock2);        

    }
}
