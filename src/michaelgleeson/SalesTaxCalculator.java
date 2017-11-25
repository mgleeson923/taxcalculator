package michaelgleeson;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by michaelgleeson on 11/15/17.
 */
public class SalesTaxCalculator {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList receipt = new ArrayList();
        int num = 1;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setMinimumFractionDigits(2);

        while (true) {
            //Tax object
            Tax tax = new Tax();

            //Series of queries to add items to your list
            //Includes scanners and calls to Tax class
            System.out.println("Product(s): " + num);

            System.out.println("Product Name: ");
            String product = scnr.nextLine();
            tax.productName = product;

            System.out.println("Quantity: ");
            int quantity = scnr.nextInt();
            tax.quantity = quantity;
            scnr.nextLine();

            System.out.println("Unit Price of Item: ");
            double price = scnr.nextDouble();
            tax.price = price;
            scnr.nextLine();

            System.out.println("Is the item Imported?) (Y/N): ");
            String importStatus = scnr.nextLine();
            if (importStatus.equalsIgnoreCase("Y"))
                tax.imported = true;

            System.out.println("Is the Item Tax Exempt? (Medicine, Food, or Book?) (Y/N): ");
            String exempted = scnr.nextLine();
            if (exempted.equalsIgnoreCase("Y"))
                tax.exempt = true;

            //Call to determine sales tax and update price for receipt
            tax.CalculateSalesTax();
            receipt.add(tax);
            num++;

            System.out.println("Do you have more products to add? (Y/N): ");
            String addMore = scnr.nextLine();
            if (addMore.equalsIgnoreCase("N"))
                break;
        }
        double taxPrice = 0.00;
        double taxTaxed = 0.00;

        //for Loop that iterates through the Receipt Arraylist, determines the Price and Tax on each item
        for (int i = 0; i < receipt.size() ; i++) {
            Tax tax = (Tax) receipt.get(i);
            taxPrice = taxPrice + tax.price;
            taxTaxed = taxTaxed + tax.tax;
            System.out.println(tax);
        }
        double grandTotal = taxPrice + taxTaxed;
        System.out.println("Sales Tax: $" + df.format(taxTaxed));
        System.out.println("Grand Total: $" + df.format(grandTotal));

    }

}
