package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Picked extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String customerId;
    private String status;
}


