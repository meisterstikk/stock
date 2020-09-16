package demopubsub;

import demopubsub.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReturnAccept_Return(@Payload ReturnAccept returnAccept){

        if(returnAccept.isMe()){
            System.out.println("##### listener Return : " + returnAccept.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRentAccepted_StockCheck(@Payload RentAccepted rentAccepted){

        if(rentAccepted.isMe()){
            System.out.println("##### listener StockCheck : " + rentAccepted.toJson());
        }
    }

}
