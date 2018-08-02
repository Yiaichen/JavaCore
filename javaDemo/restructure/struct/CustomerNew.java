package javaDemo.restructure.struct;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 消费者
 *
 * @author vayi
 * @date 2018/7/30
 * @since 0.0.1
 */
public class CustomerNew {

    private Vector RentalNews = new Vector();
    private String name;

    public CustomerNew(String name) {
        super();
        this.name = name;
    }

    public void addRentalNew(RentalNew arg) {
        RentalNews.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration rentals = RentalNews.elements();
        String result = "RentalNewNew Record for" + " " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            RentalNew each = (RentalNew) rentals.nextElement();
            result += "\t" + each.getMovieNew().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " "
                + "frequent renter points";
        return result;
    }

    /**
     * 获取总Charge
     *
     * @return
     */
    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = RentalNews.elements();
        while (rentals.hasMoreElements()) {
            RentalNew each = (RentalNew) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    /**
     * 获取总FrequentRenterPoints
     *
     * @return
     */
    private double getTotalFrequentRenterPoints() {
        double result = 0;
        Enumeration rentals = RentalNews.elements();
        while (rentals.hasMoreElements()) {
            RentalNew each = (RentalNew) rentals.nextElement();
            result += each.getRrequentRenterPoints();
        }
        return result;
    }

}