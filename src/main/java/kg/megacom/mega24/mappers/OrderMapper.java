package kg.megacom.mega24.mappers;

import kg.megacom.mega24.models.dto.OrderAppDto;
import kg.megacom.mega24.models.dto.OrderDto;
import kg.megacom.mega24.models.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);


    OrderDto toOrderDto(Order order);

    @Mappings({
            @Mapping(source = "orderAppDto.regionId", target = "region.id"),
            @Mapping(source = "orderAppDto.districtId",target = "district.id"),
            @Mapping(source = "subscriberId",target = "subscriber.id")
    })
    Order orderAppDtoToOrder(OrderAppDto orderAppDto,Long subscriberId);

    @Mappings({
            @Mapping(source = "regionId", target = "region.id"),
            @Mapping(source = "districtId",target = "district.id"),
    })
    Order orderAppDtoToOrder(OrderAppDto orderAppDto);
}
