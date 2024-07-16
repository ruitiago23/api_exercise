package minera.porto.CarRental.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @joinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne
    @joinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
