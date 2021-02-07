package tn.isg.mppsi.plantsStoreMgt.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.isg.mppsi.plantsStoreMgt.Entities.Plant;
import tn.isg.mppsi.plantsStoreMgt.Services.PlantService;

import java.util.List;

@RestController
public class PlantController {

    @Autowired
    private PlantService plantServ;

    @PostMapping("/addplant")
    public Plant add_Plant(@RequestBody Plant p)
    {
       return plantServ.addPlant(p);
    }
    @GetMapping("/all")
    public List<Plant> getPlants()
    {
        return plantServ.getallPlants();
    }
    @DeleteMapping("/sale/{id}")
    public void saleAPlant(@PathVariable Long id)
    {
        plantServ.salePlant(id);
    }
}
