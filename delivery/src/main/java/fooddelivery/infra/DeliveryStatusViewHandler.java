package fooddelivery.infra;

import fooddelivery.domain.*;
import fooddelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryStatusViewHandler {


    @Autowired
    private DeliveryStatusRepository deliveryStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_CREATE_1 (@Payload DeliveryStarted deliveryStarted) {
        try {

            if (!deliveryStarted.validate()) return;

            // view 객체 생성
            DeliveryStatus deliveryStatus = new DeliveryStatus();
            // view 객체에 이벤트의 Value 를 set 함
            deliveryStatus.setOrderId(DeliveryStarted.id);
            // view 레파지 토리에 save
            deliveryStatusRepository.save(deliveryStatus);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_1(@Payload Delivered delivered) {
        try {
            if (!delivered.validate()) return;
                // view 객체 조회

                List<DeliveryStatus> deliveryStatusList = deliveryStatusRepository.findByOrderId(delivered.getOrderId());
                for(DeliveryStatus deliveryStatus : deliveryStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    deliveryStatus.setStatus(status);
                // view 레파지 토리에 save
                deliveryStatusRepository.save(deliveryStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenWrapped_then_UPDATE_2(@Payload Wrapped wrapped) {
        try {
            if (!wrapped.validate()) return;
                // view 객체 조회

                List<DeliveryStatus> deliveryStatusList = deliveryStatusRepository.findByOrderId(wrapped.getOrderId());
                for(DeliveryStatus deliveryStatus : deliveryStatusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                deliveryStatusRepository.save(deliveryStatus);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

