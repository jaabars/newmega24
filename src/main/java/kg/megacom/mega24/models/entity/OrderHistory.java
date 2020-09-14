package kg.megacom.mega24.models.entity;

import kg.megacom.mega24.models.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orderHistories")
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date startDate;

    private Date endDate;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
