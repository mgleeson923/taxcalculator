package michaelgleeson;

import java.text.DecimalFormat;

/**
 * Created by michaelgleeson on 11/15/17.
 */
public class Tax {
    int quantity = 0;
    String productName = null;
    double price = 0.0;
    boolean imported = false;
    boolean exempt = false;
    double tax = 0.0;
    DecimalFormat df = new DecimalFormat("#.##");

    public void CalculateSalesTax(){
        double totalTax = 0.0;
        if (imported)
            totalTax = 0.05;
        if (!exempt)
            totalTax = 0.10;
        if ((imported) && (!exempt))
            totalTax = 0.15;
        tax = totalTax * price;
    }

    public String toString() {
        df.setMinimumFractionDigits(2);
        double total = price + tax;
        return quantity + " " + productName + ": $" + df.format(total);
    }

}
