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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  @Transactional
  public void test() {
    Customer jackBauer = new Customer("Jack", "Bauer");
    Order order = new Order(jackBauer, "Sandwich");
    jackBauer.setOrders(Arrays.asList(order));
    order.setCustomer(jackBauer);

    customerRepository.save(jackBauer);
    orderRepository.save(order);

    Customer customer = customerRepository.findOne(1L);
    List<Order> orders =  customer.getOrders();
    Assert.assertNotNull(orders);
    Assert.assertEquals(1, orders.size());
    Assert.assertEquals("Sandwich", orders.get(0).getItem());
  }
}
