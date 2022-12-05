package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Integer qty;
    private Long price;
    private String customerId;
    private String address;
    private String status;
    private Long foodId;
}


