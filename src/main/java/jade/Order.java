package jade;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Data
@NoArgsConstructor
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String item;
  @ManyToOne
  private Customer customer;


  public Order(Customer customer, String item) {
    this.customer = customer;
    this.item = item;
  }
}
