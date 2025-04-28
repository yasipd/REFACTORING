import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    // New method: moved from TextStatement
    public String getRentalLines() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append("\t")
                  .append(rental.getMovie().getTitle())
                  .append("\t")
                  .append(rental.getCharge())
                  .append("\n");
        }
        return result.toString();
    }
}
