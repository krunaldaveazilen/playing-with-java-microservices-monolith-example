public class CustomerTest {

    @Test
    public void testEquals() {
        Customer customer1 = new Customer("John", "Doe", "john.doe@example.com", "1234567890", null, true);
        Customer customer2 = new Customer("John", "Doe", "john.doe@example.com", "1234567890", null, true);
        Customer customer3 = new Customer("Jane", "Doe", "jane.doe@example.com", "0987654321", null, false);

        assertEquals(customer1, customer2);
        assertNotEquals(customer1, customer3);
    }

    @Test
    public void testHashCode() {
        Customer customer1 = new Customer("John", "Doe", "john.doe@example.com", "1234567890", null, true);
        Customer customer2 = new Customer("John", "Doe", "john.doe@example.com", "1234567890", null, true);
        Customer customer3 = new Customer("Jane", "Doe", "jane.doe@example.com", "0987654321", null, false);

        assertEquals(customer1.hashCode(), customer2.hashCode());
        assertNotEquals(customer1.hashCode(), customer3.hashCode());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", "1234567890", null, true);
        String expected = "Customer{firstName='John', lastName='Doe', email='john.doe@example.com', telephone='1234567890', enabled=true}";
        assertEquals(expected, customer.toString());
    }
}
