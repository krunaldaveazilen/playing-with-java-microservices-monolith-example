public class OrderItemTest {

    @Test
    public void testEquals() {
        Product product1 = new Product();
        product1.setName("Product1");
        Order order1 = new Order();
        OrderItem item1 = new OrderItem(5L, product1, order1);

        Product product2 = new Product();
        product2.setName("Product1");
        Order order2 = new Order();
        OrderItem item2 = new OrderItem(5L, product2, order2);

        assertEquals(item1, item2);
    }

    @Test
    public void testNotEquals() {
        Product product1 = new Product();
        product1.setName("Product1");
        Order order1 = new Order();
        OrderItem item1 = new OrderItem(5L, product1, order1);

        Product product2 = new Product();
        product2.setName("Product2");
        Order order2 = new Order();
        OrderItem item2 = new OrderItem(5L, product2, order2);

        assertNotEquals(item1, item2);
    }

    @Test
    public void testHashCode() {
        Product product1 = new Product();
        product1.setName("Product1");
        Order order1 = new Order();
        OrderItem item1 = new OrderItem(5L, product1, order1);

        Product product2 = new Product();
        product2.setName("Product1");
        Order order2 = new Order();
        OrderItem item2 = new OrderItem(5L, product2, order2);

        assertEquals(item1.hashCode(), item2.hashCode());
    }

    @Test
    public void testToString() {
        Product product = new Product();
        product.setName("Product1");
        Order order = new Order();
        OrderItem item = new OrderItem(5L, product, order);

        String expected = "OrderItem{quantity=5, product=Product1}";
        assertEquals(expected, item.toString());
    }
}
