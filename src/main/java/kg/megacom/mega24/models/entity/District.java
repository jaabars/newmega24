package kg.megacom.mega24.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "districts")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
