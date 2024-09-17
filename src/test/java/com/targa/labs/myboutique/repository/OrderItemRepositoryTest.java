package com.targa.labs.myboutique.repository;

import com.targa.labs.myboutique.domain.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderItemRepositoryTest {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    @Transactional
    @Rollback
    public void testSaveOrderItem() {
        OrderItem orderItem = new OrderItem();
        // Set properties of orderItem as needed
        orderItem = orderItemRepository.save(orderItem);
        assertThat(orderItem.getId()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void testFindById() {
        OrderItem orderItem = new OrderItem();
        // Set properties of orderItem as needed
        orderItem = orderItemRepository.save(orderItem);
        Optional<OrderItem> foundOrderItem = orderItemRepository.findById(orderItem.getId());
        assertThat(foundOrderItem).isPresent();
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteOrderItem() {
        OrderItem orderItem = new OrderItem();
        // Set properties of orderItem as needed
        orderItem = orderItemRepository.save(orderItem);
        orderItemRepository.delete(orderItem);
        Optional<OrderItem> foundOrderItem = orderItemRepository.findById(orderItem.getId());
        assertThat(foundOrderItem).isNotPresent();
    }
}
