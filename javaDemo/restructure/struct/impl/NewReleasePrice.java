package javaDemo.restructure.struct.impl;


import javaDemo.restructure.struct.MovieNew;
import javaDemo.restructure.struct.Price;

/**
 * 描述
 *
 * @author vayi
 * @date 2018/8/1
 * @since 0.0.1
 */
public class NewReleasePrice extends Price {
    public int getPriceCode() {
        return MovieNew.new_release;
    }

    public double getCharge(int dayRented) {
        return dayRented * 3;
    }

    public double getRrequentRenterPoints(int dayRented) {
        if (dayRented > 1) {
            return 2;
        }
        return 1;
    }
}