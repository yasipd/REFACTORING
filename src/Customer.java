import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>(); // Modern List instead of Vector

    public Customer(String newName) {
        name = newName;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder(header());

        for (Rental rental : rentals) {
            double thisAmount = rental.getCharge(); // Delegated to Rental
            frequentRenterPoints += rental.getFrequentRenterPoints(); // Delegated to Rental
            result.append(lineForRental(rental, thisAmount));
            totalAmount += thisAmount;
        }

        result.append(footer(totalAmount, frequentRenterPoints));
        return result.toString();
    }

    private String header() {
        return "Rental Record for " + getName() + "\n"
             + "\tTitle\t\tDays\tAmount\n";
    }

    private String lineForRental(Rental rental, double amount) {
        return String.format("\t%-15s\t%3d\t%.2f\n",
                rental.getMovie().getTitle(),
                rental.getDaysRented(),
                amount);
    }

    private String footer(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + String.format("%.2f", totalAmount) + "\n"
             + "You earned " + frequentRenterPoints + " frequent renter points";
    }
}