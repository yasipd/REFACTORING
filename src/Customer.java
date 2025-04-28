import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentalsEnum = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentalsEnum.hasMoreElements()) {
            Rental each = (Rental) rentalsEnum.nextElement();

            double thisAmount = each.getCharge(); 

            frequentRenterPoints += each.getFrequentRenterPoints();


            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}
