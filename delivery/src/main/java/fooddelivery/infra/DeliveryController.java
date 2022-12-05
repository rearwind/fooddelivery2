package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/deliveries")
@Transactional
public class DeliveryController {
    @Autowired
    DeliveryRepository deliveryRepository;



    @RequestMapping(value = "deliveries/{id}/pick",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Delivery pick(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /delivery/pick  called #####");
            Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);
            
            optionalDelivery.orElseThrow(()-> new Exception("No Entity Found"));
            Delivery delivery = optionalDelivery.get();
            delivery.pick();
            
            deliveryRepository.save(delivery);
            return delivery;
            
    }
    



    @RequestMapping(value = "deliveries/{id}/confirmdelivered",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Delivery confirmDelivered(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /delivery/confirmDelivered  called #####");
            Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);
            
            optionalDelivery.orElseThrow(()-> new Exception("No Entity Found"));
            Delivery delivery = optionalDelivery.get();
            delivery.confirmDelivered();
            
            deliveryRepository.save(delivery);
            return delivery;
            
    }
    



}
