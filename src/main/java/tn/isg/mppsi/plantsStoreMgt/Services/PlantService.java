package tn.isg.mppsi.plantsStoreMgt.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.isg.mppsi.plantsStoreMgt.Entities.Plant;
import tn.isg.mppsi.plantsStoreMgt.Repositories.PlantRepository;

import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepos;

    public Plant addPlant(Plant p1)
    {
        return plantRepos.save(p1);
    }
    public List<Plant> getallPlants()
    {
        return plantRepos.findAll();
    }
    public void salePlant(Long id)
    {
        plantRepos.deleteById(id);
    }
}
