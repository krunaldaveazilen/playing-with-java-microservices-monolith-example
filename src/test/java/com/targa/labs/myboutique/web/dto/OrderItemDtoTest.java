package com.targa.labs.myboutique.web.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderItemDtoTest {

    @Test
    public void testNoArgsConstructor() {
        OrderItemDto orderItemDto = new OrderItemDto();
        assertNotNull(orderItemDto);
    }

    @Test
    public void testAllArgsConstructor() {
        OrderItemDto orderItemDto = new OrderItemDto(1L, 2L, 3L, 4L);
        assertEquals(1L, orderItemDto.getId());
        assertEquals(2L, orderItemDto.getQuantity());
        assertEquals(3L, orderItemDto.getProductId());
        assertEquals(4L, orderItemDto.getOrderId());
    }

    @Test
    public void testSettersAndGetters() {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(1L);
        orderItemDto.setQuantity(2L);
        orderItemDto.setProductId(3L);
        orderItemDto.setOrderId(4L);

        assertEquals(1L, orderItemDto.getId());
        assertEquals(2L, orderItemDto.getQuantity());
        assertEquals(3L, orderItemDto.getProductId());
        assertEquals(4L, orderItemDto.getOrderId());
    }

    @Test
    public void testEqualsAndHashCode() {
        OrderItemDto orderItemDto1 = new OrderItemDto(1L, 2L, 3L, 4L);
        OrderItemDto orderItemDto2 = new OrderItemDto(1L, 2L, 3L, 4L);
        OrderItemDto orderItemDto3 = new OrderItemDto(5L, 6L, 7L, 8L);

        assertEquals(orderItemDto1, orderItemDto2);
        assertNotEquals(orderItemDto1, orderItemDto3);
        assertEquals(orderItemDto1.hashCode(), orderItemDto2.hashCode());
        assertNotEquals(orderItemDto1.hashCode(), orderItemDto3.hashCode());
    }

    @Test
    public void testToString() {
        OrderItemDto orderItemDto = new OrderItemDto(1L, 2L, 3L, 4L);
        String expectedString = "OrderItemDto(id=1, quantity=2, productId=3, orderId=4)";
        assertEquals(expectedString, orderItemDto.toString());
    }
}
