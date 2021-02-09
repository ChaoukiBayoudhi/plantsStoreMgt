package tn.isg.mppsi.plantsStoreMgt.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.isg.mppsi.plantsStoreMgt.Entities.Plant;
import tn.isg.mppsi.plantsStoreMgt.Services.PlantService;

import java.util.List;

@RestController
@RequestMapping("/plants")
@CrossOrigin("http://localhost:4200")
//add--> ADMIN
//all --> Tous les utilisateurs (ADMIN, USER, CUSTOMER)
//sale --> USER
@PreAuthorize("hasAnyRole('ADMIN','USER', 'CUSTOMER')")
public class PlantController {

    @Autowired
    private PlantService plantServ;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Plant add_Plant(@RequestBody Plant p)
    {
       return plantServ.addPlant(p);
    }
    @GetMapping("/all")
    public List<Plant> getPlants()
    {
        return plantServ.getallPlants();
    }
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/sale/{id}")
    public void saleAPlant(@PathVariable Long id)
    {
        plantServ.salePlant(id);
    }
}
