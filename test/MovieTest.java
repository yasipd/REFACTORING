import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void testMovieGettersAndSetters() {
        Movie movie = new Movie("Inception", Movie.NEW_RELEASE);
        assertEquals("Inception", movie.getTitle());
        assertEquals(Movie.NEW_RELEASE, movie.getPriceCode());

        movie.setPriceCode(Movie.REGULAR);
        assertEquals(Movie.REGULAR, movie.getPriceCode());
    }
}
