package fooddelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long id;
    private Long orderId;
    private Long price;
    private String status;
    private String action;
}


