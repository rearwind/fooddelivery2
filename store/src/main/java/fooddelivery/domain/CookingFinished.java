package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingFinished extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long foodId;
    private Integer qty;
    private String address;
    private String customerId;
    private String status;

    public CookingFinished(Cooking aggregate){
        super(aggregate);
    }
    public CookingFinished(){
        super();
    }
}
