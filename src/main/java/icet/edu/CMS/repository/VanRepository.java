package icet.edu.CMS.repository;

import icet.edu.CMS.dao.VanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VanRepository extends JpaRepository<VanEntity,Long> {
    public List<VanEntity> findVanEntitiesByHostId(String hostId);
}
