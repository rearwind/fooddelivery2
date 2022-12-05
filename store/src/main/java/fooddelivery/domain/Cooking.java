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

        if (acceptCommand.getAccept()) {
            
            OrderAccepted orderAccepted = new OrderAccepted(this);
            orderAccepted.publishAfterCommit();

            setStatus("주문수락됨");

        } else {
            
            OrderRejected orderRejected = new OrderRejected(this);
            orderRejected.publishAfterCommit();

            setStatus("주문거절됨");

        }

    }
    public void start(){
        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();

        setStatus("요리시작됨");

    }
    public void finish(){
        CookingFinished cookingFinished = new CookingFinished(this);
        cookingFinished.publishAfterCommit();

        setStatus("요리완료됨");

    }

    public static void copyOrderInfo(OrderPlaced orderPlaced){

        /** Example 1:  new item */
        Cooking cooking = new Cooking();

        cooking.setOrderId(orderPlaced.getId());
        cooking.setFoodId(orderPlaced.getFoodId());
        cooking.setCustomerId(orderPlaced.getCustomerId());
        cooking.setQty(orderPlaced.getQty());
        cooking.setAddress(orderPlaced.getAddress());
        cooking.setStatus("미결제");
        
        repository().save(cooking);

        

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

        /** Example 2:  finding and process */
        
        repository().findByOrderId(payAccepted.getOrderId()).ifPresent(cooking->{
            
            cooking.setStatus("결제승인"); // do something
            repository().save(cooking);


         });
        

        
    }


}
