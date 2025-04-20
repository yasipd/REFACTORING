import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RentalTest {

    @Test
    public void testGetChargeForRegularMovie() {
        Movie movie = new Movie("Regular", Movie.REGULAR);
        Rental rental = new Rental(movie, 4); // 2 + (2 * 1.5) = 5.0
        assertEquals(5.0, rental.getCharge());
    }

    @Test
    public void testGetChargeForChildrensMovie() {
        Movie movie = new Movie("Toy Story", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 5); // 1.5 + (2 * 1.5) = 4.5
        assertEquals(4.5, rental.getCharge());
    }

    @Test
    public void testGetChargeForNewRelease() {
        Movie movie = new Movie("Matrix", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 3); // 3 * 3 = 9
        assertEquals(9.0, rental.getCharge());
    }

    @Test
    public void testFrequentRenterPointsStandard() {
        Movie movie = new Movie("Standard", Movie.REGULAR);
        Rental rental = new Rental(movie, 2);
        assertEquals(1, rental.getFrequentRenterPoints());
    }

    @Test
    public void testFrequentRenterPointsBonus() {
        Movie movie = new Movie("Bonus", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 3);
        assertEquals(2, rental.getFrequentRenterPoints());
    }
}
