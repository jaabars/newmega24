package kg.megacom.mega24.dao;

import kg.megacom.mega24.models.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRep extends JpaRepository<Region , Long> {
}
