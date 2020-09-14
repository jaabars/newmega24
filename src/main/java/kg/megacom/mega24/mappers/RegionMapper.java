package kg.megacom.mega24.mappers;

import kg.megacom.mega24.models.dto.RegionDto;
import kg.megacom.mega24.models.entity.Region;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionMapper {

    RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

    Region toRegion(RegionDto regionDto);
    RegionDto toRegionDto(Region region);
}
