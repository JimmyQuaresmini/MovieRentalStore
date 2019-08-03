package moviestore.controllers;

import java.time.LocalDateTime;
import moviestore.entities.Actor;
import moviestore.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jimmy
 */

@Controller
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;
    
    @GetMapping("/all")
    public String getAllActors(Model model) { 
        Iterable<Actor> itActors = actorService.getAllActors();
        model.addAttribute("actors", itActors);
        return "filmActors";
    }
    
    @GetMapping("/add")
    public @ResponseBody String addActor(@RequestParam int id, @RequestParam String fName,
            @RequestParam String lName, @RequestParam LocalDateTime updated) {        
        actorService.saveActor(id, fName, lName, updated);
        return "Saved actor";
    }
    
    
}
