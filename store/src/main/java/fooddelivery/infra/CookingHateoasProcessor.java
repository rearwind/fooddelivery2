package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class CookingHateoasProcessor implements RepresentationModelProcessor<EntityModel<Cooking>>  {

    @Override
    public EntityModel<Cooking> process(EntityModel<Cooking> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/accept").withRel("accept"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/start").withRel("start"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/finish").withRel("finish"));

        
        return model;
    }
    
}
