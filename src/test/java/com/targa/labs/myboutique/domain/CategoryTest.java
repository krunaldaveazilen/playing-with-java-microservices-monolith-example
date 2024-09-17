public class CategoryTest {

    @Test
    public void testEquals() {
        Category category1 = new Category("Electronics", "Devices and gadgets", null);
        Category category2 = new Category("Electronics", "Devices and gadgets", null);
        Category category3 = new Category("Books", "Reading materials", null);

        assertEquals(category1, category2);
        assertNotEquals(category1, category3);
    }

    @Test
    public void testHashCode() {
        Category category1 = new Category("Electronics", "Devices and gadgets", null);
        Category category2 = new Category("Electronics", "Devices and gadgets", null);
        Category category3 = new Category("Books", "Reading materials", null);

        assertEquals(category1.hashCode(), category2.hashCode());
        assertNotEquals(category1.hashCode(), category3.hashCode());
    }

    @Test
    public void testToString() {
        Category category = new Category("Electronics", "Devices and gadgets", null);
        String expected = "Category{name='Electronics', description='Devices and gadgets'}";
        assertEquals(expected, category.toString());
    }
}
