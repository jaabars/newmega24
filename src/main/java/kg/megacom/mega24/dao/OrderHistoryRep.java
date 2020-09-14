package kg.megacom.mega24.dao;

import kg.megacom.mega24.models.entity.Order;
import kg.megacom.mega24.models.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRep extends JpaRepository<OrderHistory, Long> {

    OrderHistory findByOrderAndEndDateIsNull(Order order);

}
