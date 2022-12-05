package fooddelivery.domain;

import fooddelivery.domain.PayAccepted;
import fooddelivery.PaymentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Payment_table")
@Data

public class Payment  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Long price;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String action;

    @PostPersist
    public void onPostPersist(){
    }
    @PrePersist
    public void onPrePersist(){


        PayAccepted payAccepted = new PayAccepted(this);
        payAccepted.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }



    public void pay(){
    }



}
