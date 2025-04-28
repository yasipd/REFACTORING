import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

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
        return new TextStatement().value(this);
    }

    public Enumeration<Rental> getRentals() {
        return rentals.elements();
    }

    public double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = getRentals();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result += rental.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = getRentals();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }
}