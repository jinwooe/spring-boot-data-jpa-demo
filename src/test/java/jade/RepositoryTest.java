package jade;

import jade.domain.Order;
import jade.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
  @Autowired
  private OrderRepository orderRepository;

  @Test
  public void test() {
    Order order = orderRepository.findOne(1L);
    Assert.assertNotNull(order);
    Assert.assertNotNull(order.getCustomer());
    Assert.assertEquals("Jack", order.getCustomer().getFirstName());
  }
}
