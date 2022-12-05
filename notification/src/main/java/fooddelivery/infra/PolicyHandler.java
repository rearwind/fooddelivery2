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
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderAccepted'")
    public void wheneverOrderAccepted_SendNotification(@Payload OrderAccepted orderAccepted){

        OrderAccepted event = orderAccepted;
        System.out.println("\n\n##### listener SendNotification : " + orderAccepted + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderRejected'")
    public void wheneverOrderRejected_SendNotification(@Payload OrderRejected orderRejected){

        OrderRejected event = orderRejected;
        System.out.println("\n\n##### listener SendNotification : " + orderRejected + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Picked'")
    public void wheneverPicked_SendNotification(@Payload Picked picked){

        Picked event = picked;
        System.out.println("\n\n##### listener SendNotification : " + picked + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookingStarted'")
    public void wheneverCookingStarted_SendNotification(@Payload CookingStarted cookingStarted){

        CookingStarted event = cookingStarted;
        System.out.println("\n\n##### listener SendNotification : " + cookingStarted + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCancelled'")
    public void wheneverOrderCancelled_SendNotification(@Payload OrderCancelled orderCancelled){

        OrderCancelled event = orderCancelled;
        System.out.println("\n\n##### listener SendNotification : " + orderCancelled + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookingFinished'")
    public void wheneverCookingFinished_SendNotification(@Payload CookingFinished cookingFinished){

        CookingFinished event = cookingFinished;
        System.out.println("\n\n##### listener SendNotification : " + cookingFinished + "\n\n");


        

        // Sample Logic //

        

    }

}


