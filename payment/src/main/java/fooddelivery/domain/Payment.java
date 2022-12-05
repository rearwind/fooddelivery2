package fooddelivery.domain;

import fooddelivery.domain.PayAccepted;
import fooddelivery.PaymentApplication;
import javax.persistence.*;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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

        if ("cancel".equals(action)) {

            PayCancelled payCancelled = new PayCancelled();
            BeanUtils.copyProperties(this, payCancelled);
            payCancelled.publish();

            
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void beforeCommit(boolean readOnly) {
                    payAccepted.publish();
                }
            });


        } else {

            PayAccepted payAccepted = new PayAccepted();
            BeanUtils.copyProperties(this, payAccepted);

        
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void beforeCommit(boolean readOnly) {
                    payAccepted.publish();
                }
            });


            // try {
            //     Thread.currentThread().sleep((long) (400 + Math.random() * 250));
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }


    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }



    public void pay(){
    }



}
