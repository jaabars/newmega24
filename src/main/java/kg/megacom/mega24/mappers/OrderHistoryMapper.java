package kg.megacom.mega24.mappers;

import kg.megacom.mega24.models.dto.OrderHistoryDto;
import kg.megacom.mega24.models.entity.OrderHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderHistoryMapper {

    OrderHistoryMapper INSTANCE = Mappers.getMapper(OrderHistoryMapper.class);

    OrderHistory toOrderHistory(OrderHistoryDto orderHistoryDto);
    OrderHistoryDto toOrderHistoryDto(OrderHistory orderHistory);
}
