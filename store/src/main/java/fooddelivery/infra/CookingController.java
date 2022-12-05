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
// @RequestMapping(value="/cookings")
@Transactional
public class CookingController {
    @Autowired
    CookingRepository cookingRepository;



    @RequestMapping(value = "cookings/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cooking accept(@PathVariable(value = "id") Long id, @RequestBody AcceptCommand acceptCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cooking/accept  called #####");
            Optional<Cooking> optionalCooking = cookingRepository.findById(id);
            
            optionalCooking.orElseThrow(()-> new Exception("No Entity Found"));
            Cooking cooking = optionalCooking.get();
            cooking.accept(acceptCommand);
            
            cookingRepository.save(cooking);
            return cooking;
            
    }
    



    @RequestMapping(value = "cookings/{id}/start",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cooking start(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cooking/start  called #####");
            Optional<Cooking> optionalCooking = cookingRepository.findById(id);
            
            optionalCooking.orElseThrow(()-> new Exception("No Entity Found"));
            Cooking cooking = optionalCooking.get();
            cooking.start();
            
            cookingRepository.save(cooking);
            return cooking;
            
    }
    



    @RequestMapping(value = "cookings/{id}/finish",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cooking finish(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cooking/finish  called #####");
            Optional<Cooking> optionalCooking = cookingRepository.findById(id);
            
            optionalCooking.orElseThrow(()-> new Exception("No Entity Found"));
            Cooking cooking = optionalCooking.get();
            cooking.finish();
            
            cookingRepository.save(cooking);
            return cooking;
            
    }
    



}
