import java.util.Enumeration;
public class TextStatement {
    public String value(Customer customer) {
        String result = "Rental Record for " + customer.getName() + "\n";
        result += getRentalLines(customer);
        result += "Amount owed is " + customer.getTotalCharge() + "\n";
        result += "You earned " + customer.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private String getRentalLines(Customer customer) {
        String result = "";
        Enumeration<Rental> rentals = customer.getRentals();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
        }
        return result;
    }
}
