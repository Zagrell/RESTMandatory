package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.models.Thing;
import rest.repositories.ThingsRepo;

import java.util.List;

@RestController
public class Things {

    private ThingsRepo repo;


    @GetMapping("/things")
    public List<Thing> getAllThings(){
        return repo.findAll();
    }

    @GetMapping("/things/{id}")
    public Thing getThingById(@PathVariable Long id){
        return repo.findById(id).get();
    }

    @PostMapping("/things")
    public Thing addThing(@RequestBody Thing thingToAdd){
        return repo.save(thingToAdd);
    }

    @PutMapping("/things/{id}")
    public String setThing(@PathVariable Long id, @RequestBody Thing thingToSet){
        if(repo.existsById(id)){
            thingToSet.setId(id);
            repo.save(thingToSet);
            return "ok";
        }
            return "error";
    }

    @PatchMapping("/things/{id}")
    public boolean updateThing(@PathVariable Long id, @RequestBody Thing thingToUpdateWith){
        return repo.findById(id).map(foundThing -> {
            if(thingToUpdateWith.getName() != null) foundThing.setName(thingToUpdateWith.getName());
            if(thingToUpdateWith.getDescription() != null) foundThing.setDescription(thingToUpdateWith.getDescription());
            repo.save(foundThing);
            return true;
        }).orElse(false);
    }

    @DeleteMapping("/things/{id}")
    public boolean deleteThingById(@PathVariable Long id){
        repo.deleteById(id);
        return true;
    }

    @Autowired
    public void setRepo(ThingsRepo repo){
        this.repo = repo;
    }

    public ThingsRepo getRepo(){
        return repo;
    }


}
