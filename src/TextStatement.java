import java.util.Enumeration;
public class TextStatement {
    public String value(Customer customer) {
        Enumeration<Rental> rentals = customer.getRentals();
        String result = "Rental Record for " + customer.getName() + "\n";
        
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
        }

        result += "Amount owed is " + customer.getTotalCharge() + "\n";
        result += "You earned " + customer.getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }
}