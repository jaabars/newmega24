package kg.megacom.mega24.dao;

import kg.megacom.mega24.models.entity.Order;
import kg.megacom.mega24.models.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRep extends JpaRepository<Order, Long> {

    Order findTopBySubscriberOrderByIdDesc(Subscriber subscriber);

}
