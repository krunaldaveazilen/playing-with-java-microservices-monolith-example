package com.targa.labs.myboutique.repository;

import com.targa.labs.myboutique.domain.Cart;
import com.targa.labs.myboutique.domain.enumeration.CartStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartRepositoryTest {

    @Mock
    private CartRepository cartRepository;

    private Cart cart;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        cart.setId(1L);
        cart.setStatus(CartStatus.NEW);
    }

    @Test
    public void testFindByStatus() {
        when(cartRepository.findByStatus(CartStatus.NEW)).thenReturn(List.of(cart));

        List<Cart> carts = cartRepository.findByStatus(CartStatus.NEW);

        assertThat(carts).isNotEmpty();
        assertThat(carts.get(0).getStatus()).isEqualTo(CartStatus.NEW);
    }

    @Test
    public void testFindByStatusAndCustomerId() {
        Long customerId = 1L;
        when(cartRepository.findByStatusAndCustomerId(CartStatus.NEW, customerId)).thenReturn(List.of(cart));

        List<Cart> carts = cartRepository.findByStatusAndCustomerId(CartStatus.NEW, customerId);

        assertThat(carts).isNotEmpty();
        assertThat(carts.get(0).getStatus()).isEqualTo(CartStatus.NEW);
    }
}
