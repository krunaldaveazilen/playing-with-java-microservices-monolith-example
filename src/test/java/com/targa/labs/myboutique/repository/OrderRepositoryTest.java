package com.targa.labs.myboutique.repository;

import com.targa.labs.myboutique.domain.Order;
import com.targa.labs.myboutique.domain.Cart;
import com.targa.labs.myboutique.domain.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Mock
    private TestEntityManager entityManager;

    @InjectMocks
    private OrderRepository orderRepository;

    @Test
    public void testFindByCartCustomer_Id() {
        // Given
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setId(customerId);

        Cart cart = new Cart();
        cart.setCustomer(customer);

        Order order = new Order();
        order.setCart(cart);

        entityManager.persist(customer);
        entityManager.persist(cart);
        entityManager.persist(order);
        entityManager.flush();

        // When
        List<Order> foundOrders = orderRepository.findByCartCustomer_Id(customerId);

        // Then
        assertThat(foundOrders).isNotEmpty();
        assertThat(foundOrders.get(0).getCart().getCustomer().getId()).isEqualTo(customerId);
    }
}
