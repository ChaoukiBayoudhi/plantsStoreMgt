package tn.isg.mppsi.plantsStoreMgt.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.isg.mppsi.plantsStoreMgt.Entities.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant,Long> {
}
