package JavaCore.restructure.struct.impl;


import JavaCore.restructure.struct.MovieNew;
import JavaCore.restructure.struct.Price;

/**
 * 描述
 *
 * @author vayi
 * @date 2018/8/1
 * @since 0.0.1
 */
public class RegularPrice extends Price {
    public int getPriceCode() {
        return MovieNew.regular;
    }

    public double getCharge(int dayRented) {
        double result = 0;
        if (dayRented > 2) {
            result += (dayRented - 2) * 1.5;
        }
        return result;
    }
}