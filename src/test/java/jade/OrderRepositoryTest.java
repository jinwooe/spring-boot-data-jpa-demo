package jade;

import jade.domain.Customer;
import jade.domain.Order;
import jade.repository.CustomerRepository;
import jade.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  public void test() {
    Customer jackBauer = new Customer("Jack", "Bauer");
    jackBauer.setOrders(new ArrayList<Order>(){{
      add(new Order(jackBauer, "Sandwich"));
    }});

    customerRepository.save(jackBauer);
    Order order = orderRepository.findOne(1L);
    Assert.assertNotNull(order);
    Assert.assertNotNull(order.getCustomer());
    Assert.assertEquals("Jack", order.getCustomer().getFirstName());
  }
}
