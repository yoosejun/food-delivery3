package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired LogRepository logRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_카톡알림처리(@Payload OrderPlaced OrderPlaced){

        OrderPlaced event = OrderPlaced;
        System.out.println("\n\n##### listener 카톡알림처리 : " + OrderPlaced + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_카톡알림처리(@Payload DeliveryStarted DeliveryStarted){

        DeliveryStarted event = DeliveryStarted;
        System.out.println("\n\n##### listener 카톡알림처리 : " + DeliveryStarted + "\n\n");


        

        // Sample Logic //

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_AlertViaKakao(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener AlertViaKakao : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        Log.alertViaKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivered'")
    public void wheneverDelivered_AlertViaKakao(@Payload Delivered delivered){

        Delivered event = delivered;
        System.out.println("\n\n##### listener AlertViaKakao : " + delivered + "\n\n");


        

        // Sample Logic //
        Log.alertViaKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_AlertViaKakao(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener AlertViaKakao : " + rejected + "\n\n");


        

        // Sample Logic //
        Log.alertViaKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_AlertViaKakao(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener AlertViaKakao : " + accepted + "\n\n");


        

        // Sample Logic //
        Log.alertViaKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_AlertViaKakao(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener AlertViaKakao : " + cooked + "\n\n");


        

        // Sample Logic //
        Log.alertViaKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_AlertViaKakao(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener AlertViaKakao : " + paid + "\n\n");


        

        // Sample Logic //
        Log.alertViaKakao(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Wrapped'")
    public void wheneverWrapped_AlertViaKakao(@Payload Wrapped wrapped){

        Wrapped event = wrapped;
        System.out.println("\n\n##### listener AlertViaKakao : " + wrapped + "\n\n");


        

        // Sample Logic //
        Log.alertViaKakao(event);
        

        

    }

}


