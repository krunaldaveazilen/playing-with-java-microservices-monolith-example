public class ReviewTest {

    @Test
    public void testEquals() {
        Review review1 = new Review("Title1", "Description1", 5L);
        Review review2 = new Review("Title1", "Description1", 5L);
        Review review3 = new Review("Title2", "Description2", 4L);

        assertEquals(review1, review2);
        assertNotEquals(review1, review3);
    }

    @Test
    public void testHashCode() {
        Review review1 = new Review("Title1", "Description1", 5L);
        Review review2 = new Review("Title1", "Description1", 5L);
        Review review3 = new Review("Title2", "Description2", 4L);

        assertEquals(review1.hashCode(), review2.hashCode());
        assertNotEquals(review1.hashCode(), review3.hashCode());
    }

    @Test
    public void testToString() {
        Review review = new Review("Title1", "Description1", 5L);
        String expected = "Review{title='Title1', description='Description1', rating=5}";
        assertEquals(expected, review.toString());
    }
}
