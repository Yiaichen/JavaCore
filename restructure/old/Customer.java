package restructure.old;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 消费者
 *
 * @author vayi
 * @date 2018/7/30
 * @since 0.0.1
 */
public class Customer {

    private Vector rentals = new Vector();
    private String name;

    public Customer(String name) {
        super();
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentalss = rentals.elements();
        String result = "RentalNew Record for" + " " + getName() + "\n";
        while (rentalss.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentalss.nextElement();

            switch (each.getMovie().getPriceCode()) {
                case Movie.regular:
                    thisAmount += 2;
                    if (each.getDayRented() > 2)
                        thisAmount += (each.getDayRented() - 2) * 1.5;
                    break;

                case Movie.new_release:
                    thisAmount += each.getDayRented() * 3;
                    break;

                case Movie.childrens:
                    thisAmount += 1.5;
                    if (each.getDayRented() > 3)
                        thisAmount += (each.getDayRented() - 3) * 1.5;
                    break;
            }

            //积分  每借一张加1个积分
            frequentRenterPoints++;
            //积分累加条件  新版本的片子，借的时间大于1天
            if ((each.getMovie().getPriceCode() == Movie.new_release) && each.getDayRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " "
                + "frequent renter points";
        return result;
    }
}