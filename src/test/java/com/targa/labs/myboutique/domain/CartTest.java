public class CartTest {

    @Test
    public void testCartConstructorWithCustomer() {
        Customer customer = new Customer();
        Cart cart = new Cart(customer);
        assertEquals(customer, cart.getCustomer());
        assertEquals(CartStatus.NEW, cart.getStatus());
    }

    @Test
    public void testCartConstructorWithCustomerAndStatus() {
        Customer customer = new Customer();
        CartStatus status = CartStatus.COMPLETED;
        Cart cart = new Cart(customer, status);
        assertEquals(customer, cart.getCustomer());
        assertEquals(status, cart.getStatus());
    }

    @Test
    public void testEquals() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Cart cart1 = new Cart(customer1, CartStatus.NEW);
        Cart cart2 = new Cart(customer1, CartStatus.NEW);
        Cart cart3 = new Cart(customer2, CartStatus.COMPLETED);

        assertTrue(cart1.equals(cart2));
        assertFalse(cart1.equals(cart3));
    }

    @Test
    public void testHashCode() {
        Customer customer = new Customer();
        Cart cart1 = new Cart(customer, CartStatus.NEW);
        Cart cart2 = new Cart(customer, CartStatus.NEW);

        assertEquals(cart1.hashCode(), cart2.hashCode());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer();
        Cart cart = new Cart(customer, CartStatus.NEW);
        String expected = "Cart{customer=" + customer + ", status=NEW}";
        assertEquals(expected, cart.toString());
    }
}
