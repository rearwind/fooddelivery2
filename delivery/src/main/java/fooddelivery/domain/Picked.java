package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Picked extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String customerId;
    private String status;

    public Picked(Delivery aggregate){
        super(aggregate);
    }
    public Picked(){
        super();
    }
}
