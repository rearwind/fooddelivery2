package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PayAccepted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;

    public PayAccepted(Payment aggregate){
        super(aggregate);
    }
    public PayAccepted(){
        super();
    }
}
