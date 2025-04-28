import java.util.Enumeration;
public class TextStatement extends Statement {
    @Override
    public String value(Customer customer) {
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ").append(customer.getName()).append("\n");
        
        // Instead of doing the rental loop here, we delegate:
        result.append(customer.getRentalLines());
        
        result.append("Amount owed is ").append(customer.getTotalCharge()).append("\n");
        result.append("You earned ").append(customer.getTotalFrequentRenterPoints())
              .append(" frequent renter points");
        
        return result.toString();
    }
}
