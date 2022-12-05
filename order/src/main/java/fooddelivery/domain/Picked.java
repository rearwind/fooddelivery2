package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Picked extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String customerId;
    private String status;
}
