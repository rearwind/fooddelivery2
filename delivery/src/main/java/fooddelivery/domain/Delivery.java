package fooddelivery.domain;

import fooddelivery.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){
    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }



    public void pick(){
        Picked picked = new Picked(this);
        picked.publishAfterCommit();

    }
    public void confirmDelivered(){
        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();

    }

    public static void copyOrderInfo(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }
    public static void updateStatus(CookingFinished cookingFinished){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookingFinished.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
