package fooddelivery.domain;

import fooddelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Cooking_table")
@Data

public class Cooking  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Long foodId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){
    }

    public static CookingRepository repository(){
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(CookingRepository.class);
        return cookingRepository;
    }



    public void accept(AcceptCommand acceptCommand){
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

    }
    public void start(){
        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();

    }
    public void finish(){
        CookingFinished cookingFinished = new CookingFinished(this);
        cookingFinished.publishAfterCommit();

    }

    public static void copyOrderInfo(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

        
    }
    public static void updateStatus(PayAccepted payAccepted){

        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(payAccepted.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

        
    }


}
